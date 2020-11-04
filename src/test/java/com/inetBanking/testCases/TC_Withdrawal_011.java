package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.WithdrawalPage;

public class TC_Withdrawal_011 extends BaseClass {
	@Test
	public void makeWithdrawal() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		
		WithdrawalPage wp = new WithdrawalPage(driver);
		wp.openNewCustomer();
		wp.closeAds();
		wp.openWithdrawal();
		logger.info("Withdrawal page is opened");
		wp.setAccountNo("86973");
		logger.info("Account is entered");
		wp.setAmount("250");
		logger.info("Amount is entered");
		wp.setDescription("Extragere a banilor");
		logger.info("Description is added");
		wp.submitform();
		
		Thread.sleep(2000);
		
		if(this.isAlertPresentOnPage() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test failed");
			Assert.assertTrue(false);
		}
		else {
			if(driver.getPageSource().contains("Transaction details of Withdrawal for Account")) {
				logger.info("Test passed");
				Assert.assertTrue(true);
			}
			else {
				captureScreen(driver, "makeWithdrawal");
				logger.info("Test failed");
				Assert.assertTrue(false);
			}
		}
	}
}