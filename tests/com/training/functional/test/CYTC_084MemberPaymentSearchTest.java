package com.training.functional.test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.training.dataproviders.CyclosDataProvidersExlPostive;
import com.training.readexcel.ApachePOIExcelRead;

public class CYTC_084MemberPaymentSearchTest extends BaseFunctionalTest{

	/*
	 * Author 					: Shishir Gupta
	 * Test Case ID 			: CYTC_084
	 * Test Case Description 	: To verify whether application displays payment details based on the search criteria in member login page
	 * Precondition				: 1. user should launch the application by entering valid URL
	 *							  2. user should have logged in as member & present in home page
	 *							  3. recipient member name should be known
	 */
	
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
	public void clickAccountInformationTest() throws Exception  {
		cyclosAccount.clickOnAccountInformation();
		int size = cyclosAccount.getSearchResultSize();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_clickAccountInformationTest_" + System.currentTimeMillis());
		Assert.assertTrue(size > 0);
	}
	
	@Test(priority = 3)
	public void selectPaymentFilterTest() throws Exception  {
		cyclosAccount.selectFilter("All");
		int size = cyclosAccount.getSearchResultSize();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_selectPaymentFilterTest_" + System.currentTimeMillis());		
		Assert.assertTrue(size > 0);
	}
	
	@Test(priority = 4)
	public void clickAdvanceBtnTest() throws Exception  {
		cyclosAccount.clickOnAvanceBtn();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_clickAdvanceBtnTest_" + System.currentTimeMillis());
	}
	
	@Test(priority = 5,dataProvider = "excel-inputs" , dataProviderClass= CyclosDataProvidersExlPostive.class)  	
	public void memberAccountTest(String memberLogin,String description) throws Exception  {
		cyclosAccount.sendMemAccountName(memberLogin);
		
		cyclosAccount.sendMemAccountFromDate("01-01-2019");
		cyclosAccount.sendMemAccountToDate("31-03-2019");
		
		
		cyclosAccount.sendMemAccountSearchDescription(description);	
		//screenShot.captureScreenShot(this.getClass().getSimpleName() + "_memberLoginTest_" + System.currentTimeMillis());
		//Assert.assertTrue(cyclosMemberPayment.getRecepientLogin().equals(userNameFromSheet));
	}
	
	@Test(priority = 6)
	public void clickSearchBtnTest() throws Exception  {
		cyclosAccount.clickOnSearchBtn();
		screenShot.captureScreenShot(this.getClass().getSimpleName() + "_clickSearchBtnTest_" + System.currentTimeMillis());
		int size = cyclosAccount.getSearchResultSize();
		Assert.assertTrue(size > 0);
	}
	
}
