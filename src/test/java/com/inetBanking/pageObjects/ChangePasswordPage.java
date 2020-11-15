package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangePasswordPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@href=\"addcustomerpage.php\"]")
	WebElement newCustomer;
	@FindBy(xpath = "//*[@href=\"PasswordInput.php\"]")
	WebElement changePassword;
	@FindBy(name = "oldpassword")
	WebElement oldPassword;
	@FindBy(name = "newpassword")
	WebElement newPassword;
	@FindBy(name = "confirmpassword")
	WebElement confirmPassword;
	//@FindBy(css = "input[name=\"sub\"]")
	WebElement submitButton;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openNewCustomerPage() {
		newCustomer.click();
		this.scrollPage();
	}
	public void scrollPage() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
	}
	public void openChangePasswordPage() {
		changePassword.click();
	}
	public void setOldPassword(String oPass) {
		oldPassword.sendKeys(oPass);
	}
	public void setNewPassword(String nPass) {
		newPassword.sendKeys(nPass);
	}
	public void setConfirmPassword(String cPass) {
		confirmPassword.sendKeys(cPass);
	}
	public void submitForm() {
		wait = new WebDriverWait(driver, 10);
		js = (JavascriptExecutor) driver;
		submitButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name=\"sub\"]")));
		submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name=\"sub\"]")));
		js.executeScript("arguments[0].click();", submitButton);
	}
	
	
}