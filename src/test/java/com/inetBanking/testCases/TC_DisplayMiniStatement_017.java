package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.MiniStatementPage;

public class TC_DisplayMiniStatement_017 extends BaseClass {
	@Test
	public void displayMiniStatement() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		
		MiniStatementPage mp = new MiniStatementPage(driver);
		String accNo = "87542";
		mp.scrollPage();
		mp.openMiniStatementPage();
		logger.info("The ministatement page was opened");
		mp.setAccount(accNo);
		logger.info("Account was added");
		mp.submitForm();
		logger.info("The form was submitted");
		
		Thread.sleep(3000);
		
		if(this.isAlertPresentOnPage() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test failed");
			Assert.assertTrue(false);
		}
		else {
			if(driver.getPageSource().contains("Last Five Transaction Details for Account No: " + accNo)) {
				logger.info("Test passed");
				Assert.assertTrue(true);
			}
			else {
				captureScreen(driver, "displayMiniStatement");
				logger.info("Test failed");
				Assert.assertTrue(false);
			}
		}
	}
}