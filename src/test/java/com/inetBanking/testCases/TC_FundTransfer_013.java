package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.FundTransferPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_FundTransfer_013 extends BaseClass {
	@Test
	public void fundTranssfer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		
		FundTransferPage fp = new FundTransferPage(driver);
		fp.openFundTransferPage();
		logger.info("Transfer page was opened");
		fp.setPersAccNo("87130");
		logger.info("First account is added");
		fp.setPeesAccNo("87131");
		logger.info("Second account is added");
		fp.setAmmount("22");
		logger.info("Ammount wad added");
		fp.setDescription("Description");
		logger.info("Descriptions was added");
		fp.submitForm();
		logger.info("Form was submited");
		
		Thread.sleep(2000);
		
		if(this.isAlertPresentOnPage() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test failed");
			Assert.assertTrue(false);
		}
		else {
			if(driver.getPageSource().contains("Fund Transfer Details")) {
				logger.info("Test passed");
				Assert.assertTrue(true);
			}
			else {
				captureScreen(driver, "fundTranssfer");
				logger.info("Test failed");
				Assert.assertTrue(false);
			}
		}
	}
	
}