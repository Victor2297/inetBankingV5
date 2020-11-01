package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.EditCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_EditCustomer_004 extends BaseClass{
	@Test
	public void editCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Enterd password");
		lp.clickOnLoginButton();
		logger.info("Click on login button");
		
		Thread.sleep(3000);
		
		EditCustomerPage editC = new EditCustomerPage(driver);
		editC.openEditCustomerPage();
		editC.setCustomerID("25446");
		editC.submitCustomerID();
		
		if(isAlertPresentOnPage() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			captureScreen(driver, "editCustomer");
			logger.info("Test failed");
			Assert.assertTrue(false);
		}
		else {
			editC.scrollPage();
			editC.setAddress("Strada test");
			editC.setCity("Cau");
			editC.setState("MD1");
			editC.setPin("254462");
			editC.setMobileNumber("34567654554422");
			
			WebElement c = driver.findElement(By.id("message4"));
			WebElement s = driver.findElement(By.id("message5"));
			WebElement p = driver.findElement(By.id("message6"));
			WebElement m = driver.findElement(By.id("message7"));
			if(c.isDisplayed()||s.isDisplayed()||p.isDisplayed()||m.isDisplayed()) {
				captureScreen(driver, "editCustomer");
				logger.info("Test failed");
				Assert.assertTrue(false);
			}
			else {
				editC.sendChanges();
				if(isAlertPresentOnPage() == true) {
					driver.switchTo().alert().accept();
					driver.switchTo().defaultContent();
					captureScreen(driver, "editCustomer");
					logger.info("Test failed");
					Assert.assertTrue(false);
				}
				else {
					logger.info("Test passed");
					Assert.assertTrue(true);
				}
			}
			Thread.sleep(10000);
		}
		
	}
	
}