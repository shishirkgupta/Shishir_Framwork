package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CyclosAccountPOM {

	private WebDriver driver;

	public CyclosAccountPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "menu3")
	private WebElement accountAdmin;

	@FindBy(id = "menu2")
	private WebElement accountMember;
	
	@FindBy(id = "memberUsername")
	private WebElement memberUsername;
	

	public String[] getAdminAccountMenuItems() {
		List<WebElement> linkElements = driver.findElements(By.id("menu3"));
		WebElement element = linkElements.get(0);
		return element.getText().split("\\r?\\n");
	}

	public void clickOnAdminAccounts() {
		driver.findElement(By.id("menu3")).click();
	}

	public String[] getMemberAccountMenuItems() throws Exception {
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); implicit Wait
		// is not working
		Thread.sleep(5000);
		List<WebElement> linkElements = driver.findElements(By.id("menu2"));
		WebElement element = linkElements.get(0);
		return element.getText().split("\\n");
	}

	public void clickOnMemberAccounts() {
		driver.findElement(By.id("menu2")).click();
	}

	public void clickOnAccountInformation() {
		driver.findElement(By.id("submenu2.0")).click();
	}

	public int getSearchResultSize() {
		return driver.findElements(By.xpath("//*[@id=\"tdContents\"]/table[1]/tbody/tr[3]/td/table/tbody")).size();
	}

	public void selectFilter(String filterName) {
		WebElement selectFilter = driver.findElement(By.id("filterSelect"));
		selectFilter.click();
		Select se = new Select(selectFilter);
		se.selectByVisibleText(filterName);
	}

	public void clickBackButton() {
		driver.findElement(By.id("backButton")).click();
	}

	public void clickOnTransactionDetailIcon() {
		driver.findElement(By.xpath("//*[@id=\"tdContents\"]/table[1]/tbody/tr[3]/td/table/tbody/tr[2]/td[5]/img"))
				.click();
	}

	public int getDetailsGridSize() {
		return driver.findElements(By.xpath("//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody")).size();
	}

	public void clickOnAvanceBtn() {
		driver.findElement(By.id("modeButton")).click();
	}

	public void clickOnSearchBtn() {
		driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/input")).click();
	}

	public void sendMemAccountFromDate(String selectFromDateFromSheet) {
		WebElement fromDate = driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input"));
		fromDate.clear();
		fromDate.sendKeys(selectFromDateFromSheet);
	}

	public String getMemAccountFromDate() {
		return driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[4]/input")).getAttribute("value");
	}

	public String getMemAccountToDate() {
		return driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[4]/input")).getAttribute("value");
	}

	public void sendMemAccountToDate(String selectToDateToSheet) {
		WebElement toDate = driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[4]/input"));
		toDate.clear();
		toDate.sendKeys(selectToDateToSheet);
	}

	public void sendMemAccountSearchDescription(String selectDescFromSheet) {
		WebElement desc = driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/input"));
		desc.clear();
		desc.sendKeys(selectDescFromSheet);
	}

	public String getMemAccountSearchDescription() {
		return driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/input")).getAttribute("value");
	}
	
	public void sendMemAccountName(String memberAccountName)
	{
		this.memberUsername.sendKeys(memberAccountName);
		
	}

}
