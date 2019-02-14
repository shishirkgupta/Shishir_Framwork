package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CyclosPersonalPOM {

	private WebDriver driver;

	public CyclosPersonalPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "menu1")
	private WebElement personalMenu;

	@FindBy(id = "submenu1.3")
	private WebElement contractMenu;

	@FindBy(id = "memberUsername")
	private WebElement memberUsername;

	public String[] getPersonalItems() throws Exception {

		Thread.sleep(5000);
		List<WebElement> linkElements = driver.findElements(By.id("menu1"));
		WebElement element = linkElements.get(0);
		return element.getText().split("\\r?\\n");

	}

	public void clickOnPersonal() {
		this.personalMenu.click();
	}

	public void clickOnContract() {
		this.contractMenu.click();
	}

	public void clickOnmemberUsername() {
		this.memberUsername.click();
	}

}
