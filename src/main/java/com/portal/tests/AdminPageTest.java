package com.portal.tests;

import org.testng.annotations.Test;

import com.portal.base.BaseTest;

public class AdminPageTest extends BaseTest{
	
		String agreementNo = "000050580";
	
	@Test
	public void adminPageSearchTest()
	{
	
		
		adminPage = homepage.login(prop.getProperty("userName").trim(),prop.getProperty("passWord").trim());
		adminPage.getAdminPageTitle();
		adminPage.doAgreementSearch(agreementNo);
		adminPage.searchSuccess(agreementNo);
	}
	
	@Test
	public void quickQuote()
	{
	
		
		adminPage = homepage.login(prop.getProperty("userName").trim(),prop.getProperty("passWord").trim());
		adminPage.getAdminPageTitle();
		
	}
	
	
	
}
