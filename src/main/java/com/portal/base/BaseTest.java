package com.portal.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.portal.factory.PlaywrightFactory;
import com.portal.pages.AdminPage;
import com.portal.pages.HomePage;
import com.portal.pages.QuickQuotePage;

public class BaseTest {
	
	PlaywrightFactory pf;
	Page page;
	protected Properties prop;
	protected HomePage homepage;
	protected AdminPage adminPage;
	protected QuickQuotePage quickQuotepage;

	@BeforeTest
	public void setup()
	{
	pf = new PlaywrightFactory();
	prop = pf.init_prop();
	page = pf.initBrowser(prop);
	homepage = new HomePage(page); 
	adminPage = new AdminPage(page);
	}
	
	
	@AfterTest
	public void teardown()
	
	{
		page.context().browser().close();
		
	}
}
