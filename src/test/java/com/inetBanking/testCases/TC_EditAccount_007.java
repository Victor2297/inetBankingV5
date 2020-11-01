package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.EditAccountPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_EditAccount_007 extends BaseClass {
	@Test
	public void editAccount() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		
		EditAccountPage editAcc = new EditAccountPage(driver);
		editAcc.closeAds();
		editAcc.openEditAccountPage();
		editAcc.setAccountNo("86683");
		editAcc.submitAccountNo();
		
		Thread.sleep(1000);
		
		if(this.isAlertPresentOnPage() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test Failed");
			Assert.assertTrue(false);
		}
		else {
			editAcc.selectTA();
			editAcc.submitAccountNo();
			Thread.sleep(1000);
			if(this.isAlertPresentOnPage() == true) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				logger.info("Test Failed");
				Assert.assertTrue(false);
			}
			else {
				boolean t = driver.getPageSource().contains("Account details updated Successfully!!!");
				if(t == true) {
					logger.info("Test Passed");
					Assert.assertTrue(true);
				}
				else {
					logger.info("Test Failed");
					Assert.assertTrue(false);
				}
			}
		}
	}
	
}