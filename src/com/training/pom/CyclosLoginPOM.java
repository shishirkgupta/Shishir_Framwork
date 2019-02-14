package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CyclosLoginPOM {

	private WebDriver driver;

	public CyclosLoginPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "cyclosUsername")
	private WebElement userName;

	@FindBy(id = "cyclosPassword")
	private WebElement password;

	@FindBy(className = "button")
	private WebElement loginBtn;

	@FindBy(xpath = "//*[@id=\"menu6\"]/span[2]")
	private WebElement logout;

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String userName) {
		this.password.clear();
		this.password.sendKeys(userName);
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	public void clickLogoutBtn() {
		this.logout.click(); 
	}
	
	public String getUsername() {
		return this.userName.getAttribute("value");
	}
	public String getPassword() {
		return this.password.getAttribute("value");
	}

	public String getAlertMessage() {
		return driver.switchTo().alert().getText();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
}
