package com.training.functional.test;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Author 					: Shishir Gupta
 * Test Case ID 			: CYTC_022
 * Test Case Description 	: To verify whether application allows member to repay partial Loan amount
 * Precondition				: 1. user should launch the application by entering valid URL
 *							  2. user should have logged in as member & present in home page
 *							  3. Admin should have granted the loan
 */

public class CYTC_022RepayPartialLoanTest extends BaseFunctionalTest {
	
	String pendingLoanAmount;
	String expectedRemaningLoanAmount;
	private static int pendingAmt;
	private static int remaningAmt;
	
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
	public void clickLoanTest() {
		cyclosLoan.clickLoanMenuForMember();
		List<WebElement> loanTranscations =  cyclosLoan.getMemberLoanTransactions();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_clickLoanTest_" + System.currentTimeMillis());
		Assert.assertTrue(loanTranscations.size() > 0);
	}

	@Test(priority = 3)
	public void validLoanViewTest() {
		cyclosLoan.clickViewMemberLoan();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validLoanViewTest_" + System.currentTimeMillis());
		WebElement viewLoan = cyclosLoan.viewMemberLoan();
		Assert.assertTrue(viewLoan.equals(viewLoan));
	}
	
	@Test(priority = 4)
	public void enterAmountTest() {
		
		WebElement pendingLoan = cyclosLoan.pendingLoan();
		pendingAmt = cyclosLoan.getElementIntValue(pendingLoan);
		cyclosLoan.enterAmount("10000");
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_enterAmountTest_" + System.currentTimeMillis());
		WebElement viewAmount = cyclosLoan.viewAmountLoan();
		String expectedEnterAmount="100,00";
		String actualEnterAmount = cyclosLoan.getElementStrValue(viewAmount);
		Assert.assertTrue(expectedEnterAmount.equals(actualEnterAmount));
	}
	
	@Test(priority = 5)
	public void clickRepayTest() {
		cyclosLoan.clickRepay();
		String expectedMessage = "Are you sure to repay 100,00 units?\n" + 
				"\n" + 
				"Please, click OK to proceed";
		String actualMessage = cyclosLoan.getAlertMessage();
		cyclosLoan.acceptAlert();
		//screen-shot will not work, as immediately after accepting the alert redirection is happening.
		//screenShot.captureScreenShot(this.getClass().getSimpleName() + "_clickRepayTest_" + System.currentTimeMillis());
		Assert.assertTrue(actualMessage.equals(expectedMessage));
	}

	@Test(priority = 6)
	public void confirmRepayTest() {
		String expectedMessage = "The repayment was succesfully processed";
		String actualMessage = cyclosLoan.getAlertMessage();
		//screen-shot will not work, as immediately after accepting the alert redirection is happening.
		//screenShot.captureScreenShot(this.getClass().getSimpleName() + "_confirmRepayTest_" + System.currentTimeMillis());
		cyclosLoan.acceptAlert();
		Assert.assertTrue(actualMessage.equals(expectedMessage));
	}

	@Test(priority = 7)
	public void confirmRepayResponseTest() {
		WebElement remaingLoan = cyclosLoan.getRemaingLoan();
		remaningAmt = cyclosLoan.getElementIntValue(remaingLoan);
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_confirmRepayResponseTest_" + System.currentTimeMillis());
		Assert.assertTrue(remaningAmt == (pendingAmt-10000));
	}
}