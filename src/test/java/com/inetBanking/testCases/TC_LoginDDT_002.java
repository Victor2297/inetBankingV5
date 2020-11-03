package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	@Test(dataProvider = "LoginData")
	public void loginDDT(String usern, String pass) throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(usern);
		logger.info("Username was entered");
		lp.setPassword(pass);
		logger.info("Pssword was entered");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		
		if(this.verifyAlert()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test failed");
			Assert.assertTrue(false);
		}
		else {
			lp.clickOnLogoutButton();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test Passed");
			Assert.assertTrue(true);
		}
		
	}
	public boolean verifyAlert() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
		
@DataProvider(name = "LoginData")
	public String[][]getData() throws IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\inetBanking\\testData\\names.xlsx";
		int rownum = XLUtils.getRowCount(excelPath, "Sheet1");
		int cocount = XLUtils.getCellCount(excelPath, "Sheet1", 1);
		String loginData[][] = new String[rownum][cocount];
		for(int i = 1; i <= rownum; i++) {
			for(int j = 0; j < cocount; j++) {
				loginData[i-1][j] = XLUtils.getCellData(excelPath, "Sheet1", i, j);
			}
		}
		return loginData;
	}
}