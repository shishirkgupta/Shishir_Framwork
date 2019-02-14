              package com.training.functional.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Author 					: Shishir Gupta
 * Test Case ID 			: CYTC_021
 * Test Case Description 	: To verify whether application displays Loans information of member
 * Precondition				: 1. user should launch the application by entering valid URL
 *							  2. user should have logged in as admin & present in home page
 *							  3. Admin should have granted the loan
 */

public class CYTC_021DisplayLoanInformationTest extends BaseFunctionalTest {

	@Test(priority = 0)
	public void validAdminLoginTest() {
		cyclosLogin.sendUserName("admin");
		cyclosLogin.sendPassword("12345");
		cyclosLogin.clickLoginBtn();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_LoginHomePageTest_" + System.currentTimeMillis());
	}

	@Test(priority = 1)
	public void accountMenuLinkTest() {
		String[] linkTextsExpected = { "Accounts", "Manage Currencies", "Manage Accounts", "System Accounts",
				"Manage Invoices", "Scheduled payments", "System Payment", "Member Payment", "Member Invoice",
				"Account Fees", "Manage Loans", "Loan Payments" };
		cyclosAccount.clickOnAdminAccounts();
		String linkTextsActual[] = cyclosAccount.getAdminAccountMenuItems();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_LoginHomePageTest_" + System.currentTimeMillis());
		Assert.assertEquals(linkTextsActual, linkTextsExpected);
	}

	@Test(priority = 2)
	public void validLoanTransactionTest() {
		cyclosLoan.manageLoanAdminClick();
		cyclosLoan.searchButtonClick();
		List<WebElement> searchResults = cyclosLoan.getSearchResultTable();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validLoanTransactionTest_" + System.currentTimeMillis());
		Assert.assertTrue(searchResults.size() > 0);
	}

	@Test(priority = 3)
	public void clickViewLoanIconTest() {
		cyclosLoan.clickViewLoanIcon();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_clickViewLoanIconTest_" + System.currentTimeMillis());
	}

	@Test(priority = 4)
	public void validBackButtonTest() {
		cyclosLoan.clickBackButton();
		List<WebElement> searchResults = cyclosLoan.getSearchResultTable();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validBackButtonTest_" + System.currentTimeMillis());
		Assert.assertTrue(searchResults.size() > 0);
	}

}
