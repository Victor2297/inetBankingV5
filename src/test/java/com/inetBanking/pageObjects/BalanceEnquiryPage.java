package com.inetBanking.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BalanceEnquiryPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@href=\"addcustomerpage.php\"]")
	WebElement newCustomer;
	@FindBy(xpath = "//*[@href=\"BalEnqInput.php\"]")
	WebElement balanceEnquiry;
	@FindBy(name = "accountno")
	WebElement accountNo;
	@FindBy(name = "AccSubmit")
	WebElement submitButton;
	JavascriptExecutor js;
	
	public BalanceEnquiryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openNewCustomerPage() {
		newCustomer.click();
	}
	public void scrollPage() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
	}
	public void openBalanceEnquiryPage() {
		balanceEnquiry.click();
	}
	public void setAccountNo(String accNo) {
		accountNo.sendKeys(accNo);
	}
	public void submitForm() {
		submitButton.click();
	}
	
}