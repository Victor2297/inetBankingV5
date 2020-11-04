package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.WithdrawalPage;

public class TC_N_Withdrawal_012 extends BaseClass {
	@Test(priority = 0)
	public void loginInApp() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
	}
	@Test(dataProvider = "Data", dataProviderClass = ClassDP1.class, priority = 1)
	public void nMakeWithdrawal(String accountNo, String amount, String description) throws InterruptedException, IOException {
		
		WithdrawalPage wp = new WithdrawalPage(driver);
		wp.openNewCustomer();
		wp.closeAds();
		wp.openWithdrawal();
		logger.info("Withdrawal page is opened");
		wp.setAccountNo(accountNo);
		logger.info("Account is entered");
		wp.setAmount(amount);
		logger.info("Amount is entered");
		wp.setDescription(description);
		logger.info("Description is added");
		wp.submitform();
		
		Thread.sleep(2000);
		
		if(this.isAlertPresentOnPage() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
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