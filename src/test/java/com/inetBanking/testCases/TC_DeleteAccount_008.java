package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.DeleteAccountPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_DeleteAccount_008 extends BaseClass{
	@Test
	public void deleteAccount() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		
		DeleteAccountPage dAcc = new DeleteAccountPage(driver);
		dAcc.closeAds();
		logger.info("Ads was removed");
		dAcc.openDeleteAccountPage();
		logger.info("Delete page was opened");
		dAcc.setAccountNo("86812");
		logger.info("Account is entered");
		dAcc.submitAccounNo();
		logger.info("Account is sent");
		
		Thread.sleep(3000);
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		if(!alertText.equalsIgnoreCase("Do you really want to delete this Account?")) {
			captureScreen(driver, "deleteAccount");
			logger.info("Test failed");
			Assert.assertTrue(false);
		}
		else {
			String alertMessage = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			if(alertMessage.equalsIgnoreCase("Account Deleted Sucessfully")) {
				logger.info("Test passed");
				Assert.assertTrue(true);
			}
			else {
				logger.info("Test failed");
				Assert.assertTrue(false);
			}
		}
	}
}
