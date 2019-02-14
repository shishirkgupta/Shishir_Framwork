package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CyclosHomePOM {

	private WebDriver driver;

	public CyclosHomePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void sendMemberUserName(String userName) {
		WebElement memberUsername = driver.findElement(By.id("memberUsername"));
		memberUsername.clear();
		memberUsername.sendKeys(userName);
		memberUsername.click();
	}

	public int getUserProfileElementsSize() {
		return driver.findElements(By.xpath("//*[@id=\"tdContents\"]/form/table/tbody")).size();
	}

	public int getUserActionsElementsSize() {
		return driver.findElements(By.xpath("//*[@id=\"tdContents\"]/table[1]/tbody")).size();
	}

	public void clickOnUserActionManageAdvertiesment() {
		WebElement manageAdvertiesment = driver.findElement(By.xpath(
				"//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td/fieldset/table/tbody/tr/td[2]/input"));
		manageAdvertiesment.click();
	}

}
