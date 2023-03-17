package com.portal.pages;

import com.microsoft.playwright.Page;

public class HomePage {
private Page page;
	
	//1.String locators - Object Repo
	
	
	private String username = "//input[@placeholder='Username']";
	private String password = "//input[@placeholder='Password']";
	private String login = "//input[@name='login']";
	private String logout = "(//a[@title='Log out'][normalize-space()='Logout'])[2]";
	

	//2. Page Constructor
	
	public HomePage(Page page)
	{
		this.page = page;
	}
	
	//3. Action Methods
	
	public String getHomePageTitle()
	{
	String title = page.title();
	 System.out.println("Title is "+title); 
	 return title;
	}
	
	public String getHomePageUrl()
	{
		return page.url();
	}
	
	public AdminPage login(String userName, String passWord)
	{
		page.fill(username, userName);
		page.fill(password, passWord);
		page.click(login);
		if(page.isVisible(logout))
		{
			System.out.println("user successfully logged into... ");
		}
		return new AdminPage(page);
	}
	
}
