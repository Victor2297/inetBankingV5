package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage{
	WebDriver driver;
	@FindBy(xpath = "//*[@href=\"deleteAccountInput.php\"]")
	WebElement deleteAccount;
	@FindBy(css = "input[name=\"accountno\"]")
	WebElement accountNo;
	@FindBy(name = "AccSubmit")
	WebElement submitButton;
	@FindBy(id = "flow_close_btn_iframe")
	WebElement closeButtonFrame;
	@FindBy(id = "closeBtn")
	WebElement adsCloseButton;
	
	public DeleteAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void openDeleteAccountPage() {
		deleteAccount.click();
	}
	public void setAccountNo(String accNo) {
		accountNo.sendKeys(accNo);
	}
	public void submitAccounNo() {
		submitButton.click();
	}
	public void closeAds() {
		driver.switchTo().frame(closeButtonFrame);
		adsCloseButton.click();
		driver.switchTo().defaultContent();
	}
}