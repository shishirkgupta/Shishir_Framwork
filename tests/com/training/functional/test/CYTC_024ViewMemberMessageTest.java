package com.training.functional.test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Author 					: Shishir Gupta
 * Test Case ID 			: CYTC_024
 * Test Case Description 	: To Verify whether application allows member to view the messages
 * Precondition				: 1. user should launch the application by entering valid URL
 *							  2. user should have logged in as member & present in home page
 */

public class CYTC_024ViewMemberMessageTest extends BaseFunctionalTest {

	private static int totalMessageCount;
	
	@Test(priority = 0)
	public void validLoginTest() {
		cyclosLogin.sendUserName("shishirgupta");
		cyclosLogin.sendPassword("shishir@123");
		cyclosLogin.clickLoginBtn();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_LoginHomePageTest_" + System.currentTimeMillis());
	}
	
	@Test(priority = 1)
	public void validPersonalMenuTest() throws Exception {		
		String[] linkTextsExpected= 
        	{"Personal","Profile","Messages","Advertisements","Contacts", "References","Feedback transactions","Reports","Change password","External access"};
		cyclosPersonal.clickOnPersonal();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String linkTextsActual[] = cyclosPersonal.getPersonalItems();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validPersonalMenuTest_" + System.currentTimeMillis());
		Assert.assertTrue(Arrays.equals(linkTextsExpected,linkTextsActual));
	}

	@Test(priority = 2)
	public void validMessageListTest() {
		cyclosMessage.clickMessageMenu();
		totalMessageCount = cyclosMessage.getCyclosMessageCount();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validMessageListTest_" + System.currentTimeMillis());
		Assert.assertTrue(totalMessageCount > 0);
	}

	@Test(priority = 3)
	public void validViewMessageTest() {
		cyclosMessage.clickOnMessage();
		int messageDetailGridSize = cyclosMessage.checkMessageDetailGridSize();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validViewMessageTest_" + System.currentTimeMillis());
		Assert.assertTrue(messageDetailGridSize > 0);
	}
}
