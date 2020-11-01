package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditAccountPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@href=\"editAccount.php\"]")
	WebElement editAccount;
	@FindBy(css = "input[name = \"accountno\"]")
	WebElement accountNo;
	@FindBy(name = "AccSubmit")
	WebElement submitButton;
	@FindBy(id = "flow_close_btn_iframe")
	WebElement frame;
	@FindBy(id = "closeBtn")
	WebElement closeAdsButton;
	@FindBy(name = "a_type")
	WebElement selectTypeAccount;
	Select oSelect;
	
	public EditAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openEditAccountPage() {
		editAccount.click();
	}
	public void setAccountNo(String acc) {
		accountNo.sendKeys(acc);
	}
	public void submitAccountNo() {
		submitButton.click();
	}
	public void closeAds() {
		driver.switchTo().frame(frame);
		closeAdsButton.click();
		driver.switchTo().defaultContent();
	}
	public void selectTA() {
		oSelect = new Select(selectTypeAccount);
		oSelect.selectByVisibleText("Savings");
	}
	
}