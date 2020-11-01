package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@href=\"addcustomerpage.php\"]")
	WebElement newCustomer;
	@FindBy(name = "name")
	WebElement customerName;
	@FindBy(id = "dob")
	WebElement dateBirth;
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
	@FindBy(name = "emailid")
	WebElement email;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(name = "sub")
	WebElement submitButton;
	
	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openNewCustomer() {
		newCustomer.click();
	}
	public void setCustomerName(String cName) {
		customerName.sendKeys(cName);
	}
	public void setDateB(String date) {
		dateBirth.sendKeys(date);
	}
	public void setAddress(String addr) {
		address.sendKeys(addr);
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
	public void setMNumber(String mobileN) {
		mobileNumber.sendKeys(mobileN);
	}
	public void setEmail(String cEmail) {
		email.sendKeys(cEmail);
	}
	public void setPassword(String cPassword) {
		password.sendKeys(cPassword);
	}
	public void submitForm() {
		submitButton.click();
	}
	
	
}