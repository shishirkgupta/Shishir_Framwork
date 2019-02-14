package com.training.functional.test;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Author 					: Shishir Gupta
 * Test Case ID 			: CYTC_054
 * Test Case Description 	: To verify whether application allows user to get register & admin to provide access to registered user
 * Precondition				: 1. user should launch the application by entering valid URL
 * 							  2. click on Submit button
 */

public class CYTC_054UserRegisterAccess extends BaseFunctionalTest {

	@Test(priority=0)
    public void validLoginTest() throws InterruptedException, AWTException {
    	  cyclosUserRegisterAccess.registerBtn();
    	  Thread.sleep(3000); 
    	  cyclosUserRegisterAccess.enterUserName("aarushgupta");
    	  cyclosUserRegisterAccess.enterFullName("aarushgupta");
    	  cyclosUserRegisterAccess.enterEmail("aarushgupta@gmail.com");
    	  cyclosUserRegisterAccess.enterDOB("21/08/2014");
    	  cyclosUserRegisterAccess.genderSelect("Male");
    	  cyclosUserRegisterAccess.enterAddress("Gachibowli", "500032", "Hyderabad", "Example Area");
    	  cyclosUserRegisterAccess.enterPhone("9711080169", "9811080169", "9868077593");
    	  cyclosUserRegisterAccess.enterUrl("www.google.com");
    	  cyclosUserRegisterAccess.enterPasswords("pass12345", "pass12345");
    	  //Enter captcha manually
    	  Thread.sleep(15000);
    	  cyclosUserRegisterAccess.submitButton();
    	  Thread.sleep(2000);
    	  String confText = cyclosUserRegisterAccess.confirmtext();
    	  cyclosUserRegisterAccess.confirmation();
    	  boolean Actual = (confText.contains("Thanks for registering!"));
    	  boolean Expected = true;
    	  Assert.assertEquals(Actual, Expected);
    }    

	@Test(priority = 1)
	public void validAdminLoginTest() {
		cyclosLogin.sendUserName("admin");
		cyclosLogin.sendPassword("12345");
		cyclosLogin.clickLoginBtn();
		screenShot.captureScreenShot(
				this.getClass().getSimpleName() + "_LoginHomePageTest_" + System.currentTimeMillis());
	}

	@Test(priority = 2)
	public void validAdminToProvideAccessToRegisteredUserTest() throws Exception {
		cyclosUserRegisterAccess.memberLogin("aashitagupta");
		cyclosUserRegisterAccess.clickOnChangePermissionGroup();
		cyclosUserRegisterAccess.clickOnNewgroup();
		cyclosUserRegisterAccess.selectNewMembers();
		cyclosUserRegisterAccess.putComment("full access to the member");
		cyclosUserRegisterAccess.clickOnMemberSubmit();
		String expectedMessage = "The member's group was changed";
		String actualMessage = cyclosUserRegisterAccess.getAlertMessage();
		cyclosUserRegisterAccess.acceptAlert();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validAdminToProvideAccessToRegisteredUserTest_"
				+ System.currentTimeMillis());
		Assert.assertTrue(expectedMessage.equals(actualMessage));
	}

}
