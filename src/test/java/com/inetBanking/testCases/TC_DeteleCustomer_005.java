package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.DeleteCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_DeteleCustomer_005 extends BaseClass {
	@Test
	public void deleteCustomer() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		
		DeleteCustomerPage delC = new DeleteCustomerPage(driver);
		
		delC.openDeleteCustomerPage();
		logger.info("Open delete customer page");
		delC.setCustomerID("17979");
		logger.info("Set customer id");
		delC.submitForm();
		
		Thread.sleep(3000);
		
		String alertText = driver.switchTo().alert().getText();
		if(alertText.contentEquals("Please fill all fields")) {
			driver.switchTo().alert().accept();
			captureScreen(driver, "deleteCustomer");
			logger.info("Test failed");
			Assert.assertTrue(false);
		}
		else {
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			String alertText2 = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			if(alertText2.contentEquals("Customer deleted Successfully")) {
				logger.info("Test passed");
				Assert.assertTrue(true);
			}
			else {
				logger.info("Test failed");
				throw new Exception("Mesajul gasit este : " + alertText2);
				//Assert.assertTrue(false);
			}
		}
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}
}