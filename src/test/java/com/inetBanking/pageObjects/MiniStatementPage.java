package com.inetBanking.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MiniStatementPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@href=\"MiniStatementInput.php\"]")
	WebElement miniStatement;
	@FindBy(name = "accountno")
	WebElement accountNo;
	@FindBy(name = "AccSubmit")
	WebElement submitButton;
	JavascriptExecutor js;
	
	public MiniStatementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openMiniStatementPage() {
		miniStatement.click();
	}
	public void setAccount(String accNo) {
		accountNo.click();
		accountNo.sendKeys(accNo);
	}
	public void submitForm() {
		submitButton.click();
	}
	public void scrollPage() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
	}
}