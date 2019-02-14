package com.training.functional.test;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Author 					: Shishir Gupta
 * Test Case ID 			: CYTC_053
 * Test Case Description 	: To verify whether application allows admin to create loan group & add users into group
 * Precondition				: 1. user should launch the application by entering valid URL
 * 							  2. user should have logged in as admin  & present in home page
 */

public class CYTC_053LoanAndAddUserGroup extends BaseFunctionalTest {
	
	@Test(priority = 0)
	public void validAdminLoginTest() {
		cyclosLogin.sendUserName("admin");
		cyclosLogin.sendPassword("12345");
		cyclosLogin.clickLoginBtn();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_LoginHomePageTest_" + System.currentTimeMillis());
	}
	
	
	@Test(priority = 1)
	public void validUsersAndGroupTest() {
		String[] linkTextsExpected = { "Users & Groups", "Manage Members", "Bulk actions", "Import members","Manage Admins","Connected users","Pending members",
				"Registration agreements","Permission Groups","Group filters","Loan groups","Member record types","Remarks"};
		cyclosUserAndGroup.clickOnUsersGroup();
		String linkTextsActual[] = cyclosUserAndGroup.usersGroupsMenuItems();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validUsersAndGroupTest_" + System.currentTimeMillis());
		Assert.assertEquals(linkTextsActual, linkTextsExpected);
	}
	@Test(priority = 2)
	public void validLoanGroupsTest() {
		cyclosUserAndGroup.clickOnLoanGroup();
		int searchResultSize = cyclosUserAndGroup.getSearchResultTableSize();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validLoanTransactionTest_" + System.currentTimeMillis());
		Assert.assertTrue(searchResultSize > 0);
	}
	@Test(priority = 3)
	public void validSubmitLoanGroupTest() {
		cyclosUserAndGroup.clickOnLoanGroup();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_validSubmitLoanGroupTest_" + System.currentTimeMillis());
	}
	@Test(priority = 4)
	public void validLoanGroupDetailsTest() {
		cyclosUserAndGroup.sendSearchLoanGroupName("selenium");
	}
	
}