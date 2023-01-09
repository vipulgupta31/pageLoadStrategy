package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.*;
import java.util.HashMap;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestPageLoadStrategy {

	public RemoteWebDriver driver = null;
	String username = "<lambdtest_username>";
	String accessKey = "<lambdtest_accesskey>";
	
	ChromeOptions chromeOptions = new ChromeOptions();
	HashMap<String, Object> ltOptions = new HashMap<String, Object>();	

	private void setup(String buildName) {

		chromeOptions.setPlatformName("Windows 10");
		chromeOptions.setBrowserVersion("108.0");

		ltOptions.put("project", "Page Load Strategy");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		ltOptions.put("networkThrottling", "Regular 2G");
		ltOptions.put("build", buildName);
	}

	private void checkPageLoad() {

		try {
			driver = new RemoteWebDriver(
					new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), chromeOptions);

			Instant startTime = Instant.now();
			System.out.println("Page load started at : " + startTime.toString());
			System.out.println("Navigating to the URL");
			driver.get("https://ecommerce-playground.lambdatest.io/");
			Instant endTime = Instant.now();
			System.out.println("Page load ended at : " + endTime.toString());

			Duration duration = Duration.between(startTime, endTime);
			System.out.println("Total PageLoad time : " + duration.toMillis() + " milli seconds");

		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} finally {
			driver.quit();
		}
	}

	@Test
	public void testNormalStrategy() {
		setup("Page Load Strategy - Normal");

		// To set PageLoadStrategy = Normal
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		chromeOptions.setCapability("LT:Options", ltOptions);

		checkPageLoad();

	}

	@Test
	public void testEagerStrategy() {
		setup("Page Load Strategy - Eager");

		// To set PageLoadStrategy = Eager
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

		chromeOptions.setCapability("LT:Options", ltOptions);

		checkPageLoad();
	}

	@Test
	public void testNoneStrategy() {
		setup("Page Load Strategy - None");

		// To set PageLoadStrategy = None
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);

		chromeOptions.setCapability("LT:Options", ltOptions);

		checkPageLoad();

	}
}
