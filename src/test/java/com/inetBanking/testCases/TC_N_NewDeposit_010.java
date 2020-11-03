package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.DepositPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_N_NewDeposit_010 extends BaseClass{
	@Test(priority = 0)
	public void loginOnPage() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
	}
	@Test(dataProvider = "Data", dataProviderClass = ClassDP.class, priority = 1)
	public void createNewDeposit_N(String account, String amount, String description) throws InterruptedException, IOException {
		DepositPage dp = new DepositPage(driver);
		dp.closeAds();
		Thread.sleep(1000);
		logger.info("Ads was closed");
		dp.openDepositPage();
		logger.info("Deposit page is opened");
		dp.setAccountNo(account);
		logger.info("AccountNo is entered");
		dp.setAmount(amount);
		logger.info("Amount is entered");
		dp.addDescription(description);
		logger.info("Description is added");
		dp.submitAmountDepositForm();
		logger.info("The submit is executed");
		Thread.sleep(3000);
		
		if(this.isAlertPresentOnPage() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test passed");
			Assert.assertTrue(true);
		}
		else {
				logger.info("Test failed");
				Assert.assertTrue(false);
		}
	}
}