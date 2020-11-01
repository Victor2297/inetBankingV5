package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.NewCustomerPage;

public class TC_AddNewCustomer_003 extends BaseClass{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username was entered");
		lp.setPassword(password);
		logger.info("Password was entered");
		lp.clickOnLoginButton();
		Thread.sleep(3000);
		
		NewCustomerPage newC = new NewCustomerPage(driver);
		newC.openNewCustomer();
		newC.setCustomerName("Victor");
		newC.setDateB("04221997");
		newC.setAddress("Strada Grigore Ureche");
		newC.setCity("Chisinau");
		newC.setState("MD");
		newC.setPin("324562");
		newC.setMNumber("3456789876562");
		String email = generateRandomString() + "@gmail.com";
		newC.setEmail(email);
		newC.setPassword("1234");
		newC.submitForm();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			captureScreen(driver, "addNewCustomer");
			logger.info("Test failed");
			Assert.assertTrue(false);
		}
		else {
			if(driver.getPageSource().contains("Customer Registered Successfully!!!")) {
				logger.info("Test passed");
				Assert.assertTrue(true);
			}
			else {
				captureScreen(driver, "addNewCustomer");
				logger.info("Test failed");
				Assert.assertTrue(false);
			}
		}
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
}