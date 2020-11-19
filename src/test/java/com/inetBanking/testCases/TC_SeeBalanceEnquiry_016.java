package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.BalanceEnquiryPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_SeeBalanceEnquiry_016 extends BaseClass{
	@Test
	public void seeBalanceEnquiry() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		
		BalanceEnquiryPage bep = new BalanceEnquiryPage(driver);
		String accountNo = "87417";
		bep.openNewCustomerPage();
		logger.info("New Customer page was opened");
		bep.scrollPage();
		bep.openBalanceEnquiryPage();
		logger.info("Balance page was opened");
		bep.setAccountNo(accountNo);
		logger.info("Enetered account no");
		bep.submitForm();
		logger.info("The page was submitted");
		
		Thread.sleep(3000);
		
		if(this.isAlertPresentOnPage()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test failed");
			Assert.assertTrue(false);
		}
		else {
			if(driver.getPageSource().contains("Balance Details for Account " + accountNo)) {
				logger.info("Test passed");
				Assert.assertTrue(true);
			}else {
				logger.info("Test failed");
				Assert.assertTrue(false);
			}
		}
	}
}