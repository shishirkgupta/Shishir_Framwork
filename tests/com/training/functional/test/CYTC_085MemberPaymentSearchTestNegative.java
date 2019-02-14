package com.training.functional.test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.training.dataproviders.CyclosDataProvidersExlNegative;
import com.training.dataproviders.CyclosDataProvidersExlPostive;

/*
 * Author 					: Shishir Gupta
 * Test Case ID 			: CYTC_085
 * Test Case Description 	: To verify whether application displays error message upon entering invalid details in message modules
 * Precondition				: 1. user should launch the application by entering valid URL
 *							  2. user should have logged in as admin & present in home page
 */
public class CYTC_085MemberPaymentSearchTestNegative extends BaseFunctionalTest {
	
	
	@Test(priority = 0)
	public void validAdminLoginTest() {
		cyclosLogin.sendUserName("admin");
		cyclosLogin.sendPassword("12345");
		cyclosLogin.clickLoginBtn();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_LoginHomePageTest_" + System.currentTimeMillis());
	}

	@Test(priority = 1)
	public void validMessageTest() throws Exception {
		String[] linkTextsExpected = { "Messages", "Messages", "Message Categories", "SMS mailings"};
		cyclosMessage.clickAdminMessageMenu();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String linkTextsActual[] = cyclosMessage.getMeassgeItems();
		Assert.assertTrue(Arrays.equals(linkTextsExpected, linkTextsActual));
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validPersonalTest_" + System.currentTimeMillis());
	}

	@Test(priority = 2)
	public void validMessageLinkTest() {
		cyclosMessage.clickAdminMessagelink();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validMessageListTest_" + System.currentTimeMillis());
		Assert.assertTrue(cyclosMessage.getCyclosAdminMessagedisplay());
	}
	
	@Test(priority = 3)
	public void validMessagedroupdownselectionTest() throws InterruptedException {
		String selectedVal = cyclosMessage.getMessageBox();
		Thread.sleep(2000);
	//	String selectedVa2 = cyclosMessage.getCategory();
	//	Thread.sleep(2000);
		Assert.assertTrue(selectedVal.equals("Inbox"));
		//Assert.assertTrue(selectedVa2.equals("All Categories"));
	}

	@Test(priority = 4)
	public void validNewMessageTest() {
		cyclosMessage.clickMessageSubmitBtn();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validViewMessageTest_" + System.currentTimeMillis());	
	}
	
	@Test(priority = 5, dataProvider = "excel-inputs" , dataProviderClass= CyclosDataProvidersExlNegative.class)
	public void validSendMessageTest(String Username,String subjectText) {
		cyclosMessage.sendmemberUsername(Username);
		cyclosMessage.sendsubjectText(subjectText);
		//cyclosMessage.sendmemberUsername("shishirgupta");
		//cyclosMessage.sendsubjectText("welcome");
		//cyclosAdvertisement.sendNewAdDescription("new offer for member");
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validViewMessageTest_" + System.currentTimeMillis());	
	}
	
	
}
