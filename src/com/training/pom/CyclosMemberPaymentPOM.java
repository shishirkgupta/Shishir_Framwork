package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CyclosMemberPaymentPOM {
	
	private WebDriver driver; 
	
	public CyclosMemberPaymentPOM(WebDriver driver)  {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="submenu2.4")
	private WebElement memberPayment; 
	
	@FindBy(id="submitButton")
	private WebElement submitButton; 
	


	public void clickOnMamberPayment() {
		this.memberPayment.click();
	}
	
	public void clickOnSubmitButton() {
		this.submitButton.click();
	}
	
	public int getPaymentToMember() {
		return driver.findElements(By.xpath("//*[@id=\"tdContents\"]/form/table/tbody")).size();
	}
	
	public void sendRecepientLogin(String login) {
		WebElement loginRecipient = driver.findElement(By.id("memberUsername"));
		loginRecipient.clear();
		loginRecipient.sendKeys(login);
	}
	
	public void selectFirstSuggestion() {
		driver.findElement(By.xpath("//*[@id=\"membersByUsername\"]/ul/li[1]")).click();
	}
	
	public String getRecepientLogin() {
		WebElement loginRecipient = driver.findElement(By.id("memberUsername"));
		return loginRecipient.getAttribute("value");
	}

	public void sendRecepientAmount(String amount) {
		WebElement loginRecipientAmount = driver.findElement(By.id("amount"));
		loginRecipientAmount.clear();
		loginRecipientAmount.sendKeys(amount);
	}
	
	public String getRecepientAmount() {
		WebElement loginRecipientAmount = driver.findElement(By.id("amount"));
		return loginRecipientAmount.getAttribute("value");
	}

	public void sendPaymentToMemberDescription(String description) {
		WebElement loginRecipientDescription = driver.findElement(By.id("description"));
		loginRecipientDescription.clear();
		loginRecipientDescription.sendKeys(description);
	}
	
	public String getPaymentToMemberDescription() {
		WebElement loginRecipientDescription = driver.findElement(By.id("description"));
		return loginRecipientDescription.getAttribute("value");
	}

	public int getConfirmationGridSize() {
		return driver.findElements(By.xpath("//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody")).size();
	}

	public void performPayment() {
		WebElement performPayment = driver.findElement(
				By.xpath("//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[6]/td/input"));
		performPayment.click();
	}

	public int getPaymentResultGridSize() {
		return driver.findElements(By.xpath("//*[@id=\"tdContents\"]/table/tbody")).size();
	}

	public String getPaymentResultMessage() {
		return driver.findElement(By.xpath("//*[@id=\"tdContents\"]/table/tbody/tr[2]/td/table/tbody/tr[1]/td")).getText();
	}
}
