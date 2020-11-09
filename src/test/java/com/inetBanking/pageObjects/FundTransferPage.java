package com.inetBanking.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@href=\"FundTransInput.php\"]")
	WebElement fundTransfer;
	@FindBy(name = "payersaccount")
	WebElement persAccNo;
	@FindBy(name = "payeeaccount")
	WebElement peesAccNo;
	@FindBy(name = "ammount")
	WebElement ammount;
	@FindBy(css = "input[name=\"desc\"]")
	WebElement description;
	@FindBy(name = "AccSubmit")
	WebElement submitButton;
	@FindBy(xpath = "//*[text() = \"New Customer\"]")
	WebElement newCustomer;
	JavascriptExecutor js;
	
	public FundTransferPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openFundTransferPage() {
		newCustomer.click();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
		fundTransfer.click();
	}
	public void setPersAccNo(String accN1) {
		persAccNo.sendKeys(accN1);
	}
	public void setPeesAccNo(String accN2) {
		peesAccNo.sendKeys(accN2);
	}
	public void setAmmount(String amm) {
		ammount.sendKeys(amm);
	}
	public void setDescription(String desc) {
		description.sendKeys(desc);
	}
	public void submitForm() {
		submitButton.click();
	}
}