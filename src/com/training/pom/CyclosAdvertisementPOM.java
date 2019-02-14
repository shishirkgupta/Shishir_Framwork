package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CyclosAdvertisementPOM {

	private WebDriver driver;

	public CyclosAdvertisementPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "menu6")
	private WebElement advertisement;

	@FindBy(id = "submenu6.1")
	private WebElement manageCat;

	@FindBy(id = "newButton")
	private WebElement newCategoryBtn;

	@FindBy(id = "saveButton")
	private WebElement saveBtn;

	@FindBy(id = "backButton")
	private WebElement backBtn;

	@FindBy(id = "submitButton")
	private WebElement submitButton;

	@FindBy(id = "menu0")
	private WebElement homePage;

	

	public void clickOnAdvertisement() {

		this.advertisement.click();
	}


	public String[] advertisementMenuItems() {
		List<WebElement> linkElements = driver.findElements(By.id("menu6"));
		WebElement element = linkElements.get(0);
		return element.getText().split("\\r?\\n");
	}

	public void clickOnManageCat() {
		this.manageCat.click();

	}

	public int getAdvertisementCatSize() {
		return driver.findElements(By.xpath("//*[@id=\"tdContents\"]/table[1]/tbody")).size();
	}

	public void pageDown() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

	}

	public void clickInsertNewCategoryBtn() {
		this.newCategoryBtn.click();

	}

	public void clickOnSubmitBtn() {
		this.saveBtn.click();

	}

	public void clickOnbackBtn() {
		this.backBtn.click();

	}

	public void clickOnSubmitButton() {
		this.submitButton.click();
	}

	public int getNewAdvertisementCategorySize() {
		return driver.findElements(By.xpath("//*[@id=\"tdContents\"]/form/table[1]/tbody")).size();

	}

	public void clickOnHome() {
		this.homePage.click();
	}

	public String getAlertMessage() {
		return driver.switchTo().alert().getText();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}


	public void sendNewCategoryName(String categoryName) {
		WebElement advertisementCategory = driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/textarea"));
		advertisementCategory.clear();
		advertisementCategory.sendKeys(categoryName);
	}


	public String getNewCatName() {
		WebElement advertisementCategory = driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/textarea"));
		return advertisementCategory.getAttribute("value");
	}


	public int getUserAdvertiesmentSize() {
		return driver.findElements(By.xpath("//*[@id=\"tdContents\"]/table[1]/tbody")).size();
	}


	public int getNewAdElementSize() {
		return driver.findElements(By.xpath("//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody")).size();
	}


	public void sendAdTitle(String title) {
		WebElement advertisementTile = driver.findElement(
				By.xpath("//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input"));
		advertisementTile.clear();
		advertisementTile.sendKeys("new offer");
		advertisementTile.click();
	}


	public String getAdTitle() {
		WebElement advertisementTitle = driver.findElement(
				By.xpath("//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input"));
		return advertisementTitle.getAttribute("value");
	}


	public void sendNewCatPrice(String string) {
		WebElement advertisementCategory = driver.findElement(
				By.xpath("//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/input[1]"));
		advertisementCategory.clear();
		advertisementCategory.sendKeys("7");
		advertisementCategory.click();
	}


	public String getNewCatPrice() {
		WebElement advertisementCategory = driver.findElement(
				By.xpath("//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/input[1]"));
		return advertisementCategory.getAttribute("value");
	}


	public void sendNotEpirable() {
		driver.findElement(By.id("notExpirableCheck")).click();
	}


	public Boolean getNotExpirableCheck() {
		return driver.findElement(By.id("notExpirableCheck")).isSelected();
	}


	public void sendNewAdDescription(String description) {
		WebElement desc = driver.findElement(By.xpath("//iframe[@title='Rich text editor, descriptionText']"));
		desc.sendKeys(description);
		desc.click();
	}


	public String getAdCategory() {
		WebElement selectCat = driver.findElement(
				By.xpath("//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/select"));
		selectCat.click();
		Select se = new Select(selectCat);
		se.selectByVisibleText("selenium");
		return se.getFirstSelectedOption().getText();
	}

}
