# PageLoadStrategy with Selenium JAVA

## About PageLoadStrategy
With Selenium 4, support for PageLoadStrategies has been introduced. These help to speed up the automation depending upon the webpage that is being loaded.
These strategies serve as kind of an alternative to pageLoadTimeOut() which is being deprecated in latest version.

Page Load Strategies make use of readyState of the document whenever a webpage is loaded. 

These strategies are broadly classified into 3 types :
1. Normal : Waits for entire page to be loaded along with all sub-resources like CSS, frames, scripts etc.
2. Eager : Waits for only the HTML content of the page to be loaded and not for all sub-resources like CSS, frames, scripts etc.
3. None : Waits for only initial DOM content to be loaded and moves the control to next step.


## About Project
It is created using the latest Selenium 4 features with Java, TestNG and Maven for Web-based automation.

This is the list of tools, being used in this framework:
1. Apache Maven
2. Java 8
3. Selenium Cloud Grid - [LambdaTest](https://www.lambdatest.com) Platform
4. TestNG Framework

## Steps for Local Execution
1. Import this project in Eclipse/IntelliJ as “Existing Maven Project”
2. Go to TestPageLoadStrategy.java and Run test case for your desired page load strategy
3. You can see the logs coming up on Console as your execution progresses.
4. Since we are using RemoteWebDriver and executing on Cloud Grid platform, LambdaTest, you can login to same and view detailed logs on dashboard.


