package com.training.functional.test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Author 					: Shishir Gupta
 * Test Case ID 			: CYTC_082
 * Test Case Description 	: To verify whether application allows member to make payment to registered member & received member should able to view payment
 * Precondition				: 1. user should launch the application by entering valid URL
 *							  2. user should have logged in as member & present in home page
 *							  3. recipient member name should be known
 */

public class CYTC_082MemberPayment extends BaseFunctionalTest {

	@Test(priority = 0)
	public void validLoginTest() {
		cyclosLogin.sendUserName("shishirgupta");
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
		cyclosMemberPayment.sendRecepientLogin("selenium");
		cyclosMemberPayment.selectFirstSuggestion();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_alidCredentialsLoginTest_" + System.currentTimeMillis());
		Assert.assertTrue(cyclosMemberPayment.getRecepientLogin().equals("selenium"));
		
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
	
	@Test(priority = 8)
	public void logoutTest() {
		cyclosLogin.clickLogoutBtn();
		String expectedLogoutMsg = "Please confirm to logout";
		String actualLogoutMsg = cyclosLogin.getAlertMessage();
		cyclosLogin.acceptAlert();
		Assert.assertTrue(expectedLogoutMsg.equals(actualLogoutMsg));
	}
	
	@Test(priority = 9)
	public void sendUserNameTest() {
		cyclosLogin.sendUserName("selenium");
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_sendUserNameTest_" + System.currentTimeMillis());
		Assert.assertTrue(cyclosLogin.getUsername().equals("selenium"));
	}
	
	@Test(priority = 10)
	public void sendPasswordTest() {
		cyclosLogin.sendPassword("shishir@123");
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_sendPasswordTest_" + System.currentTimeMillis());
		Assert.assertTrue(cyclosLogin.getPassword().equals("shishir@123"));
	}
	
	@Test(priority = 11)
	public void clickLoginTest() {
		cyclosLogin.clickLoginBtn();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_clickLoginTest_" + System.currentTimeMillis());
	}
	
	@Test(priority = 12)
	public void otherMemberAccountMenuTest() throws Exception  {
		String[] linkTextsExpected = { "Account", "Account Information", "Scheduled payments", "Invoices", "Loans",
				"Member Payment", "System Payment", "Member Invoice" };
		cyclosAccount.clickOnMemberAccounts();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String linkTextsActual[] = cyclosAccount.getMemberAccountMenuItems();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validMemberAccountMenuTest_" + System.currentTimeMillis());		
		Assert.assertTrue(Arrays.equals(linkTextsExpected,linkTextsActual));
	}
	
	@Test(priority = 13)
	public void clickAccountInformationTest() throws Exception  {
		cyclosAccount.clickOnAccountInformation();
		int size = cyclosAccount.getSearchResultSize();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_clickAccountInformationTest_" + System.currentTimeMillis());
		Assert.assertTrue(size > 0);
	}
	
	@Test(priority = 14)
	public void selectPaymentFilterTest() throws Exception  {
		cyclosAccount.selectFilter("Member payments");
		int size = cyclosAccount.getSearchResultSize();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_selectPaymentFilterTest_" + System.currentTimeMillis());		
		Assert.assertTrue(size > 0);
	}
	
	@Test(priority = 15)
	public void clickTransactionDetailIconTest() throws Exception  {
		cyclosAccount.clickOnTransactionDetailIcon();
		int size = cyclosAccount.getDetailsGridSize();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validMemberAccountMenuTest_" + System.currentTimeMillis());		
		Assert.assertTrue(size > 0);
	}
	
	@Test(priority = 16)
	public void clickBackButtonTest() throws Exception  {
		cyclosAccount.clickBackButton();
		int size = cyclosAccount.getSearchResultSize();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_clickBackButtonTest_" + System.currentTimeMillis());		
		Assert.assertTrue(size > 0);
	}
	
}
