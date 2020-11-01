package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void loginInApp() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username was entered");
		lp.setPassword(password);
		logger.info("Password was entered");
		lp.clickOnLoginButton();
		Thread.sleep(3000);
		
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
			logger.info("Test is passed");
			Assert.assertTrue(true);
		}
		else {
			captureScreen(driver, "loginInApp");
			logger.info("Test is failed");
			Assert.assertTrue(false);
		}
		
	}
}