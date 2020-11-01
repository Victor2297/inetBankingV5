package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@href=\"addAccount.php\"]")
	WebElement newAccount; 
	@FindBy(name = "cusid")
	WebElement customerID;
	@FindBy(name = "inideposit")
	WebElement deposit;
	@FindBy(name = "button2")
	WebElement submitButton;
	@FindBy(name = "selaccount")
	WebElement selectType;
	
	Select oSelect;
	
	@FindBy(css = "div#playBtn")
	WebElement playButton;
	@FindBy(id = "flow_close_btn_iframe")
	WebElement frame;
	@FindBy(css = "div#closeBtn")
	WebElement closeAds;
	
	public NewAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,  this);
	}
	public void closeAds() {
		driver.switchTo().frame(frame);
		closeAds.click();
		driver.switchTo().defaultContent();
	}
	public void clickNewAccount() {
		newAccount.click();
	}
	public void setCustomerID(String cID) {
		customerID.sendKeys(cID);
	}
	public void selectTypeA() {
		oSelect = new Select(selectType);
		oSelect.selectByVisibleText("Current");
	}
	public void setDeposit(String cDeposit) {
		deposit.sendKeys(cDeposit);
	}
	public void clickSubmitButton() {
		submitButton.click();
	}
	
}