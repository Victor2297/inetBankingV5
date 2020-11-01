package com.inetBanking.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@href=\"EditCustomer.php\"]")
	WebElement editCustomer;
	@FindBy(name = "cusid")
	WebElement customerID;
	@FindBy(name = "AccSubmit")
	WebElement submitButton;
	@FindBy(name = "addr")
	WebElement address;
	@FindBy(name = "city")
	WebElement city;
	@FindBy(name = "state")
	WebElement state; 
	@FindBy(name = "pinno")
	WebElement pin;
	@FindBy(name = "telephoneno")
	WebElement mobileNumber;
	@FindBy(name = "sub")
	WebElement submitB;
	JavascriptExecutor js;
	
	public EditCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openEditCustomerPage() {
		editCustomer.click();
	}
	public void setCustomerID(String cID) {
		customerID.sendKeys(cID);
	}
	public void submitCustomerID() {
		submitButton.click();
	}
	public void setAddress(String cAddress) {
		address.sendKeys(cAddress);
	}
	public void setCity(String cCity) {
		city.sendKeys(cCity);
	}
	public void setState(String cState) {
		state.sendKeys(cState);
	}
	public void setPin(String cPin) {
		pin.sendKeys(cPin);
	}
	public void setMobileNumber(String cMobileNumber) {
		mobileNumber.sendKeys(cMobileNumber);
	}
	public void sendChanges() {
		submitB.click();
	}
	public void scrollPage() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300)");
	}
}