package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.ChangePasswordPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_ChangePassword_014 extends BaseClass {
	@Test
	public void changePassword() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		
		ChangePasswordPage c1 = new ChangePasswordPage(driver);
		c1.openNewCustomerPage();
		logger.info("New customer page was opened");
		c1.openChangePasswordPage();
		logger.info("Change password page was opened");
		c1.setOldPassword("123456@");
		logger.info("Entered old password");
		c1.setNewPassword("123456_");
		logger.info("Entered new Password");
		c1.setConfirmPassword("123456_");
		logger.info("Entered confirm password");
		c1.submitForm();
		logger.info("The form was submitted");
		
		Thread.sleep(2000);
		
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if(alertMessage.equalsIgnoreCase("Password is Changed")) {
			logger.info("Test Passed");
			Assert.assertTrue(true);
		}
		else {
			logger.info(alertMessage);
			logger.info("Test Failed");
			Assert.assertTrue(false);
		}
		
	}
}