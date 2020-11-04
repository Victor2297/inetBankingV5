package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WithdrawalPage {
	WebDriver driver;
	@FindBy(xpath = "//a[contains(text(), \"Withdrawal\")]")
	WebElement withdrawal;
	@FindBy(name = "accountno")
	WebElement accountNo;
	@FindBy(name = "ammount")
	WebElement amount;
	@FindBy(name = "desc")
	WebElement description;
	@FindBy(name = "AccSubmit")
	WebElement submitButton;
	@FindBy(xpath = "//*[@href=\"addcustomerpage.php\"]")
	WebElement newCustomer;
	@FindBy(id = "flow_close_btn_iframe")
	WebElement frameAds;
	@FindBy(css = "div[id=\"closeBtn\"]")
	WebElement closeAdsButton;
	
	public WithdrawalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openNewCustomer() {
		newCustomer.click();
	}
	public void closeAds() {
		driver.switchTo().frame(frameAds);
		closeAdsButton.click();
		driver.switchTo().defaultContent();
	}
	public void openWithdrawal() {
		withdrawal.click();
	}
	public void setAccountNo(String accNo) {
		accountNo.sendKeys(accNo);
	}
	public void setAmount(String am) {
		amount.sendKeys(am);
	}
	public void setDescription(String desc) {
		description.sendKeys(desc);
	}
	public void submitform() {
		submitButton.click();
	}
	
}