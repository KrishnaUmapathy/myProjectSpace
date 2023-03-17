package com.portal.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.portal.base.BaseTest;
import com.portal.constants.AppConstants;

public class HomePageTest extends BaseTest	 {
	

		
	@Test
	public void homePageTitleTest()
	{
		String actualTitle = homepage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}
	
	@Test
	public void homePageUrlTest()
	{
		String actualUrl = homepage.getHomePageUrl();
		Assert.assertEquals(actualUrl, prop.getProperty("url").trim());
	}
	

	
	@Test
	public void login()
	{
	  homepage.login(prop.getProperty("userName").trim(),prop.getProperty("passWord").trim());
	}
	

	@DataProvider
	public Object[][] getAgreementData()
	{
		return new Object[][]
				{
				{"000050580"}
				};
	}
	
	@Test(dataProvider = "getAgreementData")
	public void searchAgreement(String AgreementNo)
	{
	 adminPage.doAgreementSearch(AgreementNo);
	}
	
	

	

}
