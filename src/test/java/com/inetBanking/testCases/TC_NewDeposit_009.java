package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.DepositPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_NewDeposit_009 extends BaseClass {
	@Test
	public void createNewDeposit() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		
		DepositPage dp = new DepositPage(driver);
		dp.closeAds();
		dp.openDepositPage();
		dp.setAccountNo("86879");
		dp.setAmount("345");
		dp.addDescription("A fost creat un depozit nou");
		dp.submitAmountDepositForm();
		Thread.sleep(1000);
		
		if(this.isAlertPresentOnPage() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test failed");
			Assert.assertTrue(false);
		}
		else {
			if(driver.getPageSource().contains("Transaction details of Deposit for Account 86879")) {
				logger.info("Test passed");
				Assert.assertTrue(true);
			}
			else {
				captureScreen(driver, "createNewDeposit");
				logger.info("Test failed");
				Assert.assertTrue(false);
			}
		}
	}
}