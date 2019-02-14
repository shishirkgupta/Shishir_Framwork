package com.training.functional.test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.training.dataproviders.CyclosDataProvidersExlNegative;

/*
 * Author 					: Shishir Gupta
 * Test Case ID 			: CYTC_081
 * Test Case Description 	: To Verify whether application stored details of payment made by member to member get displayed in database
 * Precondition				: 1. user should launch the application by entering valid URL
 *							  2. user should have logged in as member & present in home page
 *							  3. recipient member name should be known
 */

public class CYTC_081PaymentToMemberTest extends BaseFunctionalTest {
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

	@Test(priority = 3,dataProvider = "db-inputs",dataProviderClass = CyclosDataProvidersExlNegative.class)
	public void validCredentialsRecipientAmountDescriptionTest(String recipient,String amount,String description)  {	
		cyclosMemberPayment.sendRecepientLogin(recipient);
		cyclosMemberPayment.sendRecepientAmount(recipient);
		cyclosMemberPayment.sendPaymentToMemberDescription(description);
		
//	@Test(priority = 3)
//	public void validCredentialsRecipientAmountDescriptionTest(){
//		cyclosMemberPayment.sendRecepientLogin("shishirgupta");
//		cyclosMemberPayment.sendRecepientAmount("5000");
//		cyclosMemberPayment.sendPaymentToMemberDescription("birth day gift");
		
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_alidCredentialsLoginTest_" + System.currentTimeMillis());
		Assert.assertTrue(cyclosMemberPayment.getRecepientLogin().equals("shishirgupta"));
		Assert.assertTrue(cyclosMemberPayment.getRecepientAmount().equals("50,00"));
		Assert.assertTrue(cyclosMemberPayment.getPaymentToMemberDescription().equals("birth day gift"));
		
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
