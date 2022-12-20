package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


public class TestPageLoadStrategy {

	public RemoteWebDriver driver = null;
	String username = "<lambdatest_username>";
	String accessKey = "<lambdatest_accesskey";

	@Test
	public void testNormalStrategy() {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPlatformName("Windows 10");
		chromeOptions.setBrowserVersion("108.0");
		
		//To set PageLoadStrategy = Normal
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("project", "Page Load Strategy");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		ltOptions.put("build", "Page Load Strategy - Normal");
		chromeOptions.setCapability("LT:Options", ltOptions);

		try {
			driver = new RemoteWebDriver(
					new URL("https://" + username + ":" + accessKey
							+ "@hub.lambdatest.com/wd/hub"), chromeOptions);
			
			System.out.println("Navigating to the URL");
			driver.get("https://www.lambdatest.com/selenium-playground");
			
			String pageTitle = driver.findElement(By.xpath("//h1")).getText();
			System.out.println("Title of the page : " + pageTitle);
		} 
		catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		}
		finally {
			driver.quit();
		}

	}
	
	@Test
	public void testEagerStrategy() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPlatformName("Windows 10");
		chromeOptions.setBrowserVersion("108.0");
		
		//To set PageLoadStrategy = Eager
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("project", "Page Load Strategy");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		ltOptions.put("build", "Page Load Strategy - Eager");
		chromeOptions.setCapability("LT:Options", ltOptions);

		try {
			driver = new RemoteWebDriver(
					new URL("https://" + username + ":" + accessKey
							+ "@hub.lambdatest.com/wd/hub"), chromeOptions);
			System.out.println("Navigating to the URL");
			driver.get("https://www.lambdatest.com/selenium-playground");
			String pageTitle = driver.findElement(By.xpath("//h1")).getText();
			System.out.println("Title of the page : " + pageTitle);
		} 
		catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		}
		finally {
			driver.quit();
		}

	}
	
	@Test
	public void testNoneStrategy() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPlatformName("Windows 10");
		chromeOptions.setBrowserVersion("108.0");
		
		//To set PageLoadStrategy = None
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("project", "Page Load Strategy");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		ltOptions.put("build", "Page Load Strategy - None");
		chromeOptions.setCapability("LT:Options", ltOptions);

		try {
			driver = new RemoteWebDriver(
					new URL("https://" + username + ":" + accessKey
							+ "@hub.lambdatest.com/wd/hub"), chromeOptions);
			System.out.println("Navigating to the URL");
			driver.get("https://www.lambdatest.com/selenium-playground");
			String pageTitle = driver.findElement(By.xpath("//h1")).getText();
			System.out.println("Title of the page : " + pageTitle);
		} 
		catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		}
		finally {
			driver.quit();
		}

	}
}


