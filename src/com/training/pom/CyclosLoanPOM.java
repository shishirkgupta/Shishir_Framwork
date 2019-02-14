package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CyclosLoanPOM {

	private WebDriver driver;

	public CyclosLoanPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "submenu3.10")
	private WebElement manageLoan;

	@FindBy(xpath = "//td/input[@class='button']")
	private WebElement searchbutton;

//	@FindBy(xpath="//th[contains(text(),'Member')]")
//	private WebElement member; 

	@FindBy(id = "submenu2.3")
	private WebElement loan;

	@FindBy(id = "amountText")
	private WebElement remaingloan;

	public void manageLoanAdminClick() {
		driver.findElement(By.id("submenu3.9")).click();
	}

	public void searchButtonClick() {
		driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table/tbody/tr[2]/td/table/tbody/tr[8]/td/input"))
				.click();
	}

	public List<WebElement> getSearchResultTable() {
		return driver.findElements(By.xpath("//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table"));
	}

	public void clickViewLoanIcon() {
		driver.findElement(By.xpath("//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[5]/img"))
				.click();
	}

	public void clickBackButton() {
		driver.findElement(By.id("backButton")).click();
	}

	public void clickLoanMenuForMember() {
		driver.findElement(By.id("submenu2.3")).click();
	}

	public List<WebElement> getMemberLoanTransactions() {
		return driver.findElements(By.xpath("//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table"));
	}

	public void clickViewMemberLoan() {
		driver.findElement(By.xpath("//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/img"))
				.click();
	}

	public WebElement viewMemberLoan() {

		return driver.findElement(By.xpath("//*[@id=\"tdContents\"]/table[1]/tbody/tr[1]/td[1]"));
	}

	public WebElement viewAmountLoan() {

		return driver.findElement(By.xpath("//*[@id=\"amountText\"]"));
	}

	public void enterAmount(String value) {
		WebElement loanAmount = driver.findElement(By.id("amountText"));
		loanAmount.clear();
		loanAmount.sendKeys(value);
	}

	public void clickRepay() {
		WebElement rePay = driver.findElement(By.xpath("//*[@id=\"repayForm\"]/table/tbody/tr[3]/td/input"));
		rePay.click();
	}

	public String getAlertMessage() {
		return driver.switchTo().alert().getText();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public WebElement getRemaingLoan() {
		return remaingloan;
	}
	
	public WebElement pendingLoan() {
		return driver.findElement(By.xpath("//*[@id=\"amountText\"]"));
	}

	public int getElementIntValue(WebElement pendingLoan) {
		String attrVal = pendingLoan.getAttribute("value");
		attrVal = attrVal.replaceAll("[\\-\\+\\.\\^:,]","");
		return Integer.parseInt(attrVal);
	}
	
	public String getElementStrValue(WebElement pendingLoan) {
		return pendingLoan.getAttribute("value");
	}

}
