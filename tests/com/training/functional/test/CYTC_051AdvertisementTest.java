package com.training.functional.test;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Author 					: Shishir Gupta
 * Test Case ID 			: CYTC_051
 * Test Case Description 	: To verify whether application allows admin to create new category in advertisement & add advertisement based on created category
 * Precondition				: 1. user should launch the application by entering valid URL
 * 							  2. user should have logged in as admin & present in home page
 */

public class CYTC_051AdvertisementTest extends BaseFunctionalTest {

	@Test(priority = 0)
	public void validAdminLoginTest() {
		cyclosLogin.sendUserName("admin");
		cyclosLogin.sendPassword("12345");
		cyclosLogin.clickLoginBtn();
		screenShot.captureScreenShot(
				this.getClass().getSimpleName() + "_LoginHomePageTest_" + System.currentTimeMillis());
	}

	@Test(priority = 1)
	public void validAvertisementMenuTest() {
		String[] linkTextsExpected = { "Advertisements", "Products & Services", "Manage Categories",
				"Import advertisements", "Import / export categories" };
		cyclosAdvertisement.clickOnAdvertisement();
		String linkTextsActual[] = cyclosAdvertisement.advertisementMenuItems();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_advertisementTabTest_" + System.currentTimeMillis());
		Assert.assertEquals(linkTextsActual, linkTextsExpected);
	}

	@Test(priority = 2)
	public void validManageCategoriesTest() {
		cyclosAdvertisement.clickOnManageCat();
		int advertisementCatSize = cyclosAdvertisement.getAdvertisementCatSize();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validLoanTransactionTest_" + System.currentTimeMillis());
		Assert.assertTrue(advertisementCatSize > 0);
	}

	@Test(priority = 3)
	public void validSubmitNewcategoryTest() throws AWTException {
		cyclosAdvertisement.pageDown();
		cyclosAdvertisement.clickInsertNewCategoryBtn();
        screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validSubmitNewcategoryTest_" + System.currentTimeMillis());

	}

	@Test(priority = 4)
	public void validCategoryDetailsTest() {
		cyclosAdvertisement.sendNewCategoryName("selenium");
		String adCat = cyclosAdvertisement.getNewCatName();
		screenShot.captureScreenShot(
				this.getClass().getSimpleName() + "_validCategoryDetailsTest_" + System.currentTimeMillis());
		Assert.assertTrue(adCat.equals("selenium"));
	}

	@Test(priority = 5)
	public void validCategorySubmitTest() {
		cyclosAdvertisement.clickOnSubmitBtn();
		String expectedMessage = "The category was inserted";
		String actualMessage = cyclosAdvertisement.getAlertMessage();
		cyclosAdvertisement.acceptAlert();
		screenShot.captureScreenShot(
				this.getClass().getSimpleName() + "_validCategorySubmitTest_" + System.currentTimeMillis());
		Assert.assertTrue(actualMessage.equals(expectedMessage));
	}

	@Test(priority = 6)
	public void validCategorySubmitSaveTest() {
		cyclosAdvertisement.clickOnSubmitBtn();
		String expectedMessage = "The category was modified";
		String actualMessage = cyclosAdvertisement.getAlertMessage();
		cyclosAdvertisement.acceptAlert();
		screenShot.captureScreenShot(
				this.getClass().getSimpleName() + "_validCategorySubmitSaveTest_" + System.currentTimeMillis());
		Assert.assertTrue(actualMessage.equals(expectedMessage));
	}

	@Test(priority = 7)
	public void validHomePageTest() {
		cyclosAdvertisement.clickOnHome();
		screenShot.captureScreenShot(
				this.getClass().getSimpleName() + "_validHomePageTest_" + System.currentTimeMillis());
	}

	@Test(priority = 8)
	public void validCredentialsMemberTest() {
		cycloseHome.sendMemberUserName("shishirgupta");
		screenShot.captureScreenShot(
				this.getClass().getSimpleName() + "_validCredentialsMemberTest_" + System.currentTimeMillis());
		int userProfileElementsSize = cycloseHome.getUserProfileElementsSize();
		Assert.assertTrue(userProfileElementsSize > 0);
		int userActionsElementsSize = cycloseHome.getUserActionsElementsSize();
		Assert.assertTrue(userActionsElementsSize > 0);
	}

	@Test(priority = 9)
	public void validUserAdvertiesmentTest() throws AWTException {
		cycloseHome.clickOnUserActionManageAdvertiesment();
		cyclosAdvertisement.pageDown();
		int userAdvertiesmentSize = cyclosAdvertisement.getUserAdvertiesmentSize();
		screenShot.captureScreenShot(
				this.getClass().getSimpleName() + "_validUserAdvertiesmentTest_" + System.currentTimeMillis());
		Assert.assertTrue(userAdvertiesmentSize > 0);
	}

	@Test(priority = 10)
	public void validInsertNewAdvertisementTest() {
		cyclosAdvertisement.clickInsertNewCategoryBtn();
		int newAdElementSize = cyclosAdvertisement.getNewAdElementSize();
		screenShot.captureScreenShot(
				this.getClass().getSimpleName() + "_validInsertNewAdvertisementTest_" + System.currentTimeMillis());
		Assert.assertTrue(newAdElementSize > 0);
	}

	@Test(priority = 11)
	public void validTitleTextboxTest() {
		cyclosAdvertisement.sendAdTitle("new offer");
		String adCat = cyclosAdvertisement.getAdTitle();
		Assert.assertTrue(adCat.equals("new offer"));
	}

	@Test(priority = 12)
	public void validSelectCategoryTest() throws InterruptedException {
		String selectedVal = cyclosAdvertisement.getAdCategory();
		Thread.sleep(2000);
		Assert.assertTrue(selectedVal.equals("selenium"));
	}

	@Test(priority = 13)
	public void validPriceTextBoxTest() {
		cyclosAdvertisement.sendNewCatPrice("7");
		String newCatPrice = cyclosAdvertisement.getNewCatPrice();
		Assert.assertTrue(newCatPrice.equals("0,07"));
	}

	@Test(priority = 14)
	public void validNotExpirableCheckBoxTest() {
		cyclosAdvertisement.sendNotEpirable();
		Boolean notEpirableCheck = cyclosAdvertisement.getNotExpirableCheck();
		Assert.assertTrue(notEpirableCheck);
	}

	@Test(priority = 15)
	public void validDescriptionTextTest() throws InterruptedException {
		cyclosAdvertisement.sendNewAdDescription("new offer for member");
	}

	@Test(priority = 16)
	public void validDescriptionTextBoxTest() {
		cyclosAdvertisement.clickOnSubmitBtn();
		String expectedMessage = "Advertisement inserted";
		String actualMessage = cyclosAdvertisement.getAlertMessage();
		Assert.assertTrue(actualMessage.equals(expectedMessage));
	}

	@Test(priority = 17)
	public void validOKTest() {
		cyclosAdvertisement.acceptAlert();
	}

	@Test(priority = 18)
	public void validBackBtnTest() {
		cyclosAdvertisement.clickOnbackBtn();
	}

}
