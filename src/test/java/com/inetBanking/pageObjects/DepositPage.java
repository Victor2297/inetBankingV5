package com.inetBanking.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DepositPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@href=\"DepositInput.php\"]")
	WebElement deposit;
	@FindBy(id = "flow_close_btn_iframe")
	WebElement closeButtonFrame;
	@FindBy(id = "closeBtn")
	WebElement adsCloseButton;
	@FindBy(name = "accountno")
	WebElement accountNo;
	@FindBy(name = "ammount")
	WebElement amount;
	@FindBy(css = "input[name=\"desc\"]")
	WebElement description;
	@FindBy(name ="AccSubmit")
	WebElement submitButton;
	@FindBy(xpath = "//*[@href=\"addcustomerpage.php\"]")
	WebElement newCustomer;
	@FindBy(id = "transparentInner")
	WebElement ads;
	WebDriverWait wait;
	JavascriptExecutor jse;
	
	public DepositPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void closeAds() {
		newCustomer.click();
		driver.switchTo().frame(closeButtonFrame);
		adsCloseButton.click();
		driver.switchTo().defaultContent();
	}
	public void openDepositPage() {
		deposit.click();
	}
	public void setAccountNo(String accNo) {
		accountNo.sendKeys(accNo);
	}
	public void setAmount(String am) {
		amount.sendKeys(am);
	}
	public void addDescription(String depositDescription) {
		description.sendKeys(depositDescription);
	}
	public void submitAmountDepositForm() {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", submitButton);
	}
}