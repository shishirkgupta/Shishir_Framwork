package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CyclosUserLoanAccessPOM {
	
private WebDriver driver; 
	
	public CyclosUserLoanAccessPOM(WebDriver driver)  {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@id='loginRegistrationDiv']/child::input")
	private WebElement loginRegister;
	
	@FindBy(name="member(user).username")
	private WebElement userName;
	
	@FindBy(id="memberUsername")
	private WebElement memberUsername;
	
	
	@FindBy(name="member(name)")
	private WebElement fullName;
	
	@FindBy(name="member(email)")
	private WebElement eMail;
	
	@FindBy(id="calendarTrigger0")
	private WebElement calendarBtn;
	
	@FindBy(xpath="//img[@id='calendarTrigger0']/preceding-sibling::input[@fieldname='birthday']")
	private WebElement dateField;
	
	@FindBy(id="_radio_2_0")
	private WebElement femaleRadioBtn;
	
	@FindBy(id="_radio_2_1")
	private WebElement maleRadioBtn;
	
	@FindBy(xpath="//input[@id='hidden_3']/following-sibling::input[2][@fieldname='address']")
	private WebElement addressField;
	
	@FindBy(xpath="//input[@id='hidden_4']/following-sibling::input[2][@fieldname='postalCode']")
	private WebElement postalCode;
	
	@FindBy(xpath="//input[@id='hidden_5']/following-sibling::input[2][@fieldname='city']")
	private WebElement cityName;
	
	@FindBy(id="custom_field_select_6")
	private WebElement areaDropDown;
	//selectByValue("Example Area")
	
	@FindBy(xpath="//input[@id='hidden_7']/following-sibling::input[2][@fieldname='phone']")
	private WebElement phoneNumber;
	
	@FindBy(xpath="//input[@id='hidden_8']/following-sibling::input[2][@fieldname='mobilePhone']")
	private WebElement mobileNumber;
	
	@FindBy(xpath="//input[@id='hidden_9']/following-sibling::input[2][@fieldname='fax']")
	private WebElement faxNumber;
	
	@FindBy(xpath="//input[@id='hidden_10']/following-sibling::input[2][@fieldname='url']")
	private WebElement url;
	
	@FindBy(name="member(user).password")
	private WebElement password;
	
	@FindBy(name="confirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(id="saveButton")
	private WebElement submitForm;
	
	@FindBy(id="btn")
	private WebElement confirmBtn;
	
	@FindBy(xpath="//table[@class='defaultTable']//td[@align='center']")
	private WebElement confirmText;
	
	@FindBy(xpath="//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td/fieldset/table/tbody/tr[1]/td[4]/input")
	private WebElement changepermissiongroup;
	
	@FindBy(xpath="//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/select")
	private WebElement newGroup;
	
	@FindBy(id="comments")
	private WebElement putComments;
	
	@FindBy(xpath="//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td/input")
	private WebElement memberSubmit;
	
	@FindBy(xpath="//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr[8]/td/fieldset/table/tbody/tr[1]/td[4]/input")
	private WebElement loanGrant;
	
	@FindBy(id="amount")
	private WebElement amount;
	
	@FindBy(id="description")
	private WebElement desc;
	
	@FindBy(xpath="//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[17]/td/input")
	private WebElement loanSubmit;
	
	@FindBy(xpath="//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[7]/td/input")
	private WebElement confirmLoanSubmit;
	
	
	
	public void registerBtn() {
		this.loginRegister.click();
	}
	
	public void enterUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void enterFullName(String fullName) {
		this.fullName.clear();
		this.fullName.sendKeys(fullName);
	}
	
	public void enterEmail(String eMail) {
		this.eMail.clear();
		this.eMail.sendKeys(eMail);
	}
	
	public void enterDOB(String dobValue) {
//		this.calendarBtn.click();
		this.dateField.clear();
		this.dateField.sendKeys(dobValue);
	}
	
	public void genderSelect(String gender) {
		switch(gender)
		{
		case "Male":
			this.maleRadioBtn.click();
			break;
		case "Female":
			this.femaleRadioBtn.click();
			break;
		default:
			System.out.println("Invaid Gender input");
		}
	}
	
	public void enterAddress(String address, String postal, String city, String area) {
		this.addressField.clear();
		this.addressField.sendKeys(address);
		this.postalCode.clear();
		this.postalCode.sendKeys(postal);
		this.cityName.clear();
		this.cityName.sendKeys(city);
		Select s = new Select(this.areaDropDown);
		s.selectByIndex(1);
	}
	
	public void enterPhone(String phone, String mobile, String fax) {
		this.phoneNumber.clear();
		this.phoneNumber.sendKeys(phone);
		this.mobileNumber.clear();
		this.mobileNumber.sendKeys(mobile);
		this.faxNumber.clear();
		this.faxNumber.sendKeys(fax);
	}
	
	public void enterUrl(String urlName) {
		this.url.clear();
		this.url.sendKeys(urlName);
	}
	
	public void enterPasswords(String passWord, String confirmPassWord) {
		this.password.clear();
		this.password.sendKeys(passWord);
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmPassWord);
	}
	
	public void submitButton() {
		this.submitForm.click();
	}
	
	public void confirmation() {
		this.confirmBtn.click();
	}
	
	public String confirmtext() {
		return this.confirmText.getText();
	}
	
	public void memberLogin(String user) throws InterruptedException  {
		this.memberUsername.sendKeys(user);
		this.memberUsername.click();
		
	}
	
	public void clickonchangepermissiongroup()  {
		this.changepermissiongroup.click();
		
	}
	
	public void clickOnLoanGrant() 
	{
		
		this.loanGrant.click();
	}
	
	public void pageDown() throws AWTException {	
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		    robot.keyRelease(KeyEvent.VK_PAGE_DOWN);	
		}
	
	public void clickOnNewgroup() {
		this.newGroup.click();
	}
	
	public void selectNewMembers() {
		Select se=new Select(newGroup);
		se.selectByVisibleText("Full members");
		this.newGroup.click();
		
	}
	
	public void putComment(String str) {
		
		this.putComments.sendKeys(str);
		this.putComments.click();
	}
	
	public void putAmount(String str) {
		this.amount.sendKeys(str);
		this.amount.click();
	}
	
	public void putDesc(String str) {
		this.desc.sendKeys(str);
		this.desc.click();
	}
	
	public void clickOnmemberSubmit() {
		this.memberSubmit.click();
	}
	
	public void clickOnLoanSubmit() {
		this.loanSubmit.click();
	}
	
	public void clickConfirmOnLoanSubmit() {
		this.confirmLoanSubmit.click();
	}
	
	public String getAlertMessage() {
		return driver.switchTo().alert().getText();
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
}
