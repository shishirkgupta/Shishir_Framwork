package com.training.functional.test;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CYTC_052MemberContactPaymentTest extends BaseFunctionalTest {

	/*
	 * Author : Shishir Gupta Test Case ID : CYTC_052 Test Case Description : To
	 * verify whether application allows member to add contact & make payment
	 * Precondition : 1. user should launch the application by entering valid URL 2.
	 * user should have logged in as member & present in home page
	 */

	@Test(priority = 0)
	public void validAdminLoginTest() {
		cyclosLogin.sendUserName("shishirgupta");
		cyclosLogin.sendPassword("shishir@123");
		cyclosLogin.clickLoginBtn();
		screenShot.captureScreenShot(
				this.getClass().getSimpleName() + "_LoginHomePageTest_" + System.currentTimeMillis());
	}

	@Test(priority = 1)
	public void validPersonalTest() throws Exception {
		String[] linkTextsExpected = { "Personal", "Profile", "Messages", "Advertisements", "Contacts", "References",
				"Feedback transactions", "Reports", "Change password", "External access" };
		cyclosPersonal.clickOnPersonal();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String linkTextsActual[] = cyclosPersonal.getPersonalItems();
		Assert.assertTrue(Arrays.equals(linkTextsExpected, linkTextsActual));
		screenShot.captureScreenShot(
				this.getClass().getSimpleName() + "_validPersonalTest_" + System.currentTimeMillis());
	}

	@Test(priority = 2)
	public void clickOnContract() {
		cyclosPersonal.clickOnContract();
		screenShot
				.captureScreenShot(this.getClass().getSimpleName() + "_clickOnContract_" + System.currentTimeMillis());
	}

	@Test(priority = 3)
	public void validCredentialMemberTest() throws InterruptedException {
		WebElement advertisementCategory = driver.findElement(By.id("memberUsername"));
		advertisementCategory.clear();
		advertisementCategory.sendKeys("selenium");
		Thread.sleep(3000);
		advertisementCategory.sendKeys(Keys.ENTER);
		screenShot.captureScreenShot(
				this.getClass().getSimpleName() + "_validCredentialMemberTest_" + System.currentTimeMillis());
	}

	@Test(priority = 4)
	public void validSubmitButtonTest() {
		driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td/input"))
				.click();
		String expectedMessage = "The contact was inserted";
		String actualMessage = cyclosAdvertisement.getAlertMessage();
		//Assert.assertTrue(actualMessage.equals(expectedMessage));
	}

	@Test(priority = 5)
	public void validOKButtonTest() {
		cyclosAdvertisement.acceptAlert();
		screenShot.captureScreenShot(
				this.getClass().getSimpleName() + "_validCredentialMemberTest_" + System.currentTimeMillis());
	}

	@Test(priority = 6)
	public void validContactAddTest() {
		driver.findElement(By.xpath("//*[@id=\"tdContents\"]/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td[1]/a"))
				.click();
		screenShot.captureScreenShot(
				this.getClass().getSimpleName() + "_validContactAddTest_" + System.currentTimeMillis());
	}

	@Test(priority = 7)
	public void validMakePaymentTest() {
		driver.findElement(By.xpath("//*[@id=\"tdContents\"]/table[2]/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/input"))
				.click();
		driver.findElement(By.id("amount")).sendKeys("500");
		driver.findElement(By.id("amount")).click();
	}

	@Test(priority = 8)
	public void validDescriptionTest() {
		driver.findElement(By.id("description")).sendKeys("welcome");
		driver.findElement(By.id("description")).click();
	}

	@Test(priority = 9)
	public void validSubmitPaymentTest() {

		cyclosAdvertisement.clickOnSubmitButton();
		screenShot.captureScreenShot(
				this.getClass().getSimpleName() + "_validSubmitPaymentTest_" + System.currentTimeMillis());
	}

	@Test(priority = 10)
	public void validSubmitsavePaymentTest() {
		driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[6]/td/input"))
				.click();
		screenShot.captureScreenShot(
				this.getClass().getSimpleName() + "_validSubmitsavePaymentTest_" + System.currentTimeMillis());
	}

	@Test(priority = 11)
	public void validLogoutTest() {
		cyclosLogin.clickLogoutBtn();
		cyclosAdvertisement.acceptAlert();
		screenShot
				.captureScreenShot(this.getClass().getSimpleName() + "_validLogoutTest_" + System.currentTimeMillis());
	}

}
