package com.training.functional.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import com.training.generics.ScreenShot;
import com.training.pom.CyclosAccountPOM;
import com.training.pom.CyclosAdvertisementPOM;
import com.training.pom.CyclosHomePOM;
import com.training.pom.CyclosLoanPOM;
import com.training.pom.CyclosLoginPOM;
import com.training.pom.CyclosMemberContactPaymentPOM;
import com.training.pom.CyclosMemberPaymentPOM;
import com.training.pom.CyclosMessagePOM;
import com.training.pom.CyclosPersonalPOM;
import com.training.pom.CyclosUserAndGroupPOM;
import com.training.pom.CyclosUserLoanAccessPOM;
import com.training.pom.CyclosUserRegisterAccessPOM;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class BaseFunctionalTest {

	WebDriver driver;
	ApachePOIExcelRead xlsReader;
	String baseUrl;
	String xlsLocation;
	CyclosLoginPOM cyclosLogin;
	CyclosAccountPOM cyclosAccount;
	CyclosMemberPaymentPOM cyclosMemberPayment;
	CyclosMessagePOM cyclosMessage;
	CyclosPersonalPOM cyclosPersonal;
	CyclosLoanPOM cyclosLoan;
	CyclosAdvertisementPOM cyclosAdvertisement;
	CyclosMemberContactPaymentPOM cyclosMemberContactPayment;
	CyclosUserRegisterAccessPOM cyclosUserRegisterAccess;
	CyclosUserLoanAccessPOM cyclosUserLoanAccess;
	CyclosUserAndGroupPOM cyclosUserAndGroup;
	CyclosHomePOM cycloseHome;
	JavascriptExecutor js;
	static Properties properties;
	ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		cyclosLogin = new CyclosLoginPOM(driver); 
		cyclosAccount =new CyclosAccountPOM(driver);
		cyclosMemberPayment = new CyclosMemberPaymentPOM(driver);
		cyclosMessage = new CyclosMessagePOM(driver);
		cyclosPersonal = new CyclosPersonalPOM(driver);
		cyclosLoan =new CyclosLoanPOM(driver);
		cyclosAdvertisement = new CyclosAdvertisementPOM(driver);
		cyclosMemberContactPayment = new CyclosMemberContactPaymentPOM(driver);
		cyclosUserRegisterAccess = new CyclosUserRegisterAccessPOM(driver);
		cyclosUserLoanAccess = new CyclosUserLoanAccessPOM(driver);
		cyclosUserAndGroup = new CyclosUserAndGroupPOM(driver);
		cycloseHome = new CyclosHomePOM(driver);
		js = (JavascriptExecutor) driver;
		baseUrl = properties.getProperty("baseURL");
		xlsLocation = properties.getProperty("xls.path");
		screenShot = new ScreenShot(driver); 
		xlsReader = new ApachePOIExcelRead();
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException {
		Thread.sleep(5000);
		if (result.getStatus() == ITestResult.FAILURE) {
		      //your screenshooting code goes here
		}
		
		//cyclosLoginout.clickLogout();
		//driver.switchTo().alert().accept();
		//driver.close();
	}
}
