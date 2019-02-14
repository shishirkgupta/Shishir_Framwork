package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CyclosUserAndGroupPOM {
	
	private WebDriver driver;

	public CyclosUserAndGroupPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "menu5")
	private WebElement usersGroups;

	@FindBy(xpath = "//*[@id=\"submenu5.9\"]/span[2]")
	private WebElement loanGroup;
	
	public void clickOnLoanGroup() {
		this.loanGroup.click();
	}
	
	public void clickOnUsersGroup() {
		this.usersGroups.click();
	}

	public int getSearchResultTableSize() {
		return driver.findElements(By.xpath("//*[@id=\"tdContents\"]/form/table[2]/tbody/tr[2]/td/table/tbody")).size();
	}
	
	public String[] usersGroupsMenuItems() {
		List<WebElement> linkElements = driver.findElements(By.id("menu5"));
		WebElement element = linkElements.get(0);
		return element.getText().split("\\r?\\n");
	}

	public void sendSearchLoanGroupName(String name) {
		driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/input")).sendKeys(name);
		
	}
}
