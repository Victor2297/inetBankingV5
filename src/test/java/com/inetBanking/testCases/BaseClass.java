package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	WebDriver driver;
	ReadConfig readConfig = new ReadConfig();
	String username = readConfig.getUserName();
	String password = readConfig.getPassword();
	String baseUrl = readConfig.getBaseUrl();
	Logger logger;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String browser) throws Exception {
		logger = Logger.getLogger("log ");
		PropertyConfigurator.configure("./log4j.properties");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChDriverPath());
			driver = new ChromeDriver();
			}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFfDriverPath());
			driver = new FirefoxDriver();
		}
		else {
			throw new Exception("Wrong browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		logger.info("Page was opened");
	}
	
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String fileName) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("./Screenshots/" + fileName + ".png");
		FileUtils.copyFile(SrcFile, DestFile);
		System.out.println("Screenshot taken");
	}
	
	public String generateRandomString() {
		String generatedString = RandomStringUtils.randomAlphanumeric(10);
		return generatedString;
	}
	
	public boolean isAlertPresentOnPage() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
}