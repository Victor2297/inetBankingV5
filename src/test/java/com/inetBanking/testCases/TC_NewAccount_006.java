package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.NewAccountPage;

public class TC_NewAccount_006 extends BaseClass {
	@Test
	public void createNewAccount() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		
		NewAccountPage newAcc = new NewAccountPage(driver);
		newAcc.closeAds();
		newAcc.clickNewAccount();
		newAcc.setCustomerID("14148");
		newAcc.selectTypeA();
		newAcc.setDeposit("1234567");
		newAcc.clickSubmitButton();
		
		Thread.sleep(1000);
		if(isAlertPresentOnPage() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test failed");
			Assert.assertTrue(false);
		}
		else {
			if(driver.getPageSource().contains("Account Generated Successfully!!!")) {
				logger.info("Test passed");
				Assert.assertTrue(true);
			}
			else {
				logger.info("Test failed");
				captureScreen(driver, "createNewAccount");
				Assert.assertTrue(false);
			}
		}
	}
	
}