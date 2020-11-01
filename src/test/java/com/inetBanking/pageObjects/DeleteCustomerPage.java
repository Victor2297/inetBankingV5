package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@href=\"DeleteCustomerInput.php\"]")
	WebElement deleteCustomer;
	@FindBy(css = "input[name = 'cusid']")
	WebElement customerID;
	@FindBy(name = "AccSubmit")
	WebElement submitButton;
	
	public DeleteCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openDeleteCustomerPage() {
		deleteCustomer.click();
	}
	public void setCustomerID(String cID) {
		customerID.sendKeys(cID);
	}
	public void submitForm() {
		submitButton.click();
	}
}