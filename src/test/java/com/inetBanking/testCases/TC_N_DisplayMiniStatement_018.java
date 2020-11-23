package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.MiniStatementPage;

public class TC_N_DisplayMiniStatement_018 extends BaseClass {
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
	@Test(dataProvider = "Data", dataProviderClass = ClassDP2.class)
	public void n_displayMiniStatement(String accNo, String v) throws InterruptedException, IOException {
		MiniStatementPage mp = new MiniStatementPage(driver);
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
			logger.info("Test passed");
			Assert.assertTrue(true);
		}
		else {
				captureScreen(driver, "n_displayMiniStatement");
				logger.info("Test failed");
				Assert.assertTrue(false);
			}
	}
	
}