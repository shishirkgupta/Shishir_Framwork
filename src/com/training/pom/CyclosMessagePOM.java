package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CyclosMessagePOM {

	private WebDriver driver;

	public CyclosMessagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "submenu1.1")
	private WebElement message;
	
	@FindBy(id = "menu8")
	private WebElement adminMeassage;
	
		
	@FindBy(id = "newButton")
	private WebElement messageSubmitBtn;
	
	@FindBy(id = "submenu8.0")
	private WebElement messageLink;
	
	@FindBy(id = "memberUsername")
	private WebElement memberUsername;
	
	@FindBy(id = "subjectText")
	private WebElement subjectText;
		
public void sendsubjectText(String str) {
		
		this.subjectText.sendKeys(str);
	}
	
public void sendmemberUsername(String str) {
		
		this.memberUsername.sendKeys(str);
	}

public void clickMessageSubmitBtn() {
	
	this.messageSubmitBtn.click();
}
	

	public void clickMessageMenu() {
		
		this.message.click();
	}
	
	public void clickAdminMessageMenu() {
		this.adminMeassage.click();
		
	}
	
	public void clickAdminMessagelink() {
		this.messageLink.click();	
	}
	
	public String[] getMeassgeItems() throws Exception {

		Thread.sleep(5000);
		List<WebElement> linkElements = driver.findElements(By.id("menu8"));
		WebElement element = linkElements.get(0);
		return element.getText().split("\\r?\\n");

	}
	

	public int getCyclosMessageListSize() {
		return driver.findElements(By.xpath("//*[@id=\"tdContents\"]/form[2]/table[1]/tbody")).size();

	}

	public void clickOnMessage() {
		WebElement viewMessage = driver.findElement(By.xpath(
				"//*[@id=\"tdContents\"]/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/table/tbody/tr/td[2]/a"));
		viewMessage.click();
	}

	public int checkMessageDetailGridSize() {
		return driver.findElements(By.xpath("//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody")).size();
	}

	public int getCyclosMessageCount() {
		WebElement countElement = driver
				.findElement(By.xpath("//*[@id=\"tdContents\"]/form[2]/table[2]/tbody/tr/td[2]/span"));
		if (countElement == null) {
			return 0;
		} else {
			String totalCount = countElement.getText();
			totalCount = totalCount.replace(" result(s)", "");
			return Integer.parseInt(totalCount);
		}
	}

	public Boolean getCyclosAdminMessagedisplay() {
		
		return driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form[2]/table[1]/tbody/tr[1]/td[1]")).isDisplayed();
		
	}
	
	public String getMessageBox() {
		WebElement selectCat = driver.findElement(By.id("messageBoxSelect"));
		selectCat.click();
		Select se = new Select(selectCat);
		se.selectByVisibleText("Inbox");
		return se.getFirstSelectedOption().getText();
	}
	
	public String getCategory() {
		WebElement selectCat = driver.findElement(By.xpath("//*[@id=\"categoriesSelect\"]"));
		selectCat.click();
		Select se = new Select(selectCat);
		se.deselectByIndex(0);
		//se.selectByVisibleText("All Categories");
		return se.getFirstSelectedOption().getText();
	}
	
	
	
	public void clickMoveToTrash() {
		WebElement moveToTrashIcon = driver.findElement(
				By.xpath("//*[@id=\"tdContents\"]/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[5]/img"));
		moveToTrashIcon.click();
	}

	public String getAlertMessage() {
		return driver.switchTo().alert().getText();
	}

	public void acceptAlertMessage() {
		driver.switchTo().alert().accept();
	}

}
