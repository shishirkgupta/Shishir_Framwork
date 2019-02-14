package com.training.functional.test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Author 					: Shishir Gupta
 * Test Case ID 			: CYTC_023
 * Test Case Description 	: To Verify whether application allows member to perform payment to other registered member
 * Precondition				: 1. user should launch the application by entering valid URL
 *							  2. user should have logged in as member & present in home page
 *							  3. recipient member name should be known
 */

public class CYTC_023PaymentToMemberTest extends BaseFunctionalTest {

	@Test(priority = 0)
	public void validLoginTest() {
		cyclosLogin.sendUserName("selenium");
		cyclosLogin.sendPassword("shishir@123");
		cyclosLogin.clickLoginBtn();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_LoginHomePageTest_" + System.currentTimeMillis());
	}

	@Test(priority = 1)
	public void validMemberAccountMenuTest() throws Exception  {
		String[] linkTextsExpected = { "Account", "Account Information", "Scheduled payments", "Invoices", "Loans",
				"Member Payment", "System Payment", "Member Invoice" };
		cyclosAccount.clickOnMemberAccounts();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String linkTextsActual[] = cyclosAccount.getMemberAccountMenuItems();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validMemberAccountMenuTest_" + System.currentTimeMillis());		
		Assert.assertTrue(Arrays.equals(linkTextsExpected,linkTextsActual));
	}

	@Test(priority = 2)
	public void validMemberPaymentTest() {
		cyclosMemberPayment.clickOnMamberPayment();
		int paymentToMember = cyclosMemberPayment.getPaymentToMember();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validMemberPaymentTest_" + System.currentTimeMillis());
		Assert.assertTrue(paymentToMember > 0);
		
	}

	@Test(priority = 3)
	public void validCredentialsLoginTest()  {
		cyclosMemberPayment.sendRecepientLogin("shishirgupta");
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_alidCredentialsLoginTest_" + System.currentTimeMillis());
		Assert.assertTrue(cyclosMemberPayment.getRecepientLogin().equals("shishirgupta"));
		
	}
	
	@Test(priority = 4)
	public void validCredentialsAmountTest() {
		cyclosMemberPayment.sendRecepientAmount("5000");
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validCredentialsAmountTest_" + System.currentTimeMillis());
		Assert.assertTrue(cyclosMemberPayment.getRecepientAmount().equals("50,00"));
	}

	@Test(priority = 5)
	public void validCredentialsDescriptionTest() {
		cyclosMemberPayment.sendPaymentToMemberDescription("birth day gift");
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validCredentialsDescriptionTest_" + System.currentTimeMillis());
		Assert.assertTrue(cyclosMemberPayment.getPaymentToMemberDescription().equals("birth day gift"));
	}

	@Test(priority = 6)
	public void confirmPaymentToMemberTest() {
		cyclosMemberPayment.clickOnSubmitButton();
		int confirmationGridSize = cyclosMemberPayment.getConfirmationGridSize();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_confirmPaymentToMemberTest_" + System.currentTimeMillis());
		Assert.assertTrue(confirmationGridSize > 0);
	}

	@Test(priority = 7)
	public void successfulPaymentTest() {
		cyclosMemberPayment.performPayment();
		String expectedPaymentSuccessMessage = "The payment has been performed";
		String actualPaymentResultMessage = cyclosMemberPayment.getPaymentResultMessage();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_confirmPaymenToMemberTest_" + System.currentTimeMillis());
		Assert.assertTrue(expectedPaymentSuccessMessage.equals(actualPaymentResultMessage));
	}
}
