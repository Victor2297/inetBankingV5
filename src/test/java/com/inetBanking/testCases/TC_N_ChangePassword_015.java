package com.inetBanking.testCases;


import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.ChangePasswordPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_N_ChangePassword_015 extends BaseClass {
	LoginPage lp;
	WebDriverWait wait;
	@Test(priority = 0)
	public void n_ChangePassword_login() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
	}
	@Test(dataProvider = "Data", dataProviderClass = ClassDP2.class, priority = 1)
	public void n_ChangePassword(String oldP, String newP, String confP) throws InterruptedException {
		
		ChangePasswordPage c1 = new ChangePasswordPage(driver);
		c1.openNewCustomerPage();
		logger.info("New customer page was opened");
		c1.openChangePasswordPage();
		logger.info("Change password page was opened");
		c1.setOldPassword(oldP);
		logger.info("Entered old password");
		c1.setNewPassword(newP);
		logger.info("Entered new Password");
		c1.setConfirmPassword(confP);
		logger.info("Entered confirm password");
		c1.submitForm();
		logger.info("The form was submitted");
		
		//Thread.sleep(3000);
		
		//wait.until(ExpectedConditions.alertIsPresent());
		String alertMessage = null;
		if(isAlertP() == true) {
			
		alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if(alertMessage.equalsIgnoreCase("Password is Changed")) {
			
			lp.setUsername(username);
			logger.info("Entered Username");
			lp.setPassword(newP);
			logger.info("Entered new Password");
			lp.clickOnLoginButton();
			
			logger.info("Test Failed");
			Assert.assertTrue(false);
		}
		else {
			logger.info("Test Passed");
			Assert.assertTrue(true);
		}
		
		}
		
	}
	public boolean isAlertP(){
	    boolean presenceOfAlert = false;
	    wait = new WebDriverWait(driver, 20);
	    try {
	        wait.until(ExpectedConditions.alertIsPresent());
	        return presenceOfAlert = true;
	    } catch (TimeoutException e) {
	    	logger.info("Excetie - > alert nu a fost gasit");
	        return isAlertP();
	    }
	}
}