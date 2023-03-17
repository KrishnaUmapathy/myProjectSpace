package com.portal.pages;

import org.testng.Assert;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class AdminPage {
	
		Page page;
	
	private String searchAgreement = "//input[@name='agreementNumber']";
	private String searchAgreementHeader = "//td[normalize-space()='Agreement Reference:']";
	private String searchIcon = "//input[@name='search']";
	private String agrReference = "(//td[contains(text(),'Agr Reference')])[1]";
	private String searchAgrResult = "a[name='resultLink']";
	private String clickQuickQuote = "(//a[@title='Create a new agreement'][normalize-space()='Quick Quote'])[2]";
    private String clickQuote = "//input[@name='quote']";
	
	public AdminPage(Page page) {
		this.page = page;
		// TODO Auto-generated constructor stub
	}
	
	public String getAdminPageTitle()
	{
	String title = page.title();
	 System.out.println("Title is "+title); 
	 return title;
	}

	
	public String doAgreementSearch(String AgreementNo) {
		String agrSearchheader =  page.textContent(searchAgreementHeader);
		System.out.println("search agrSearchheader: " + agrSearchheader);
		page.fill(searchAgreement, AgreementNo);
		page.click(searchIcon);
		String agrAgrResultheader =  page.textContent(agrReference);
		System.out.println("search agrAgrResultheader: " + agrAgrResultheader);
		return agrAgrResultheader;
	}
	
	public boolean searchSuccess(String AgreementNo)
	{
		ElementHandle elementHandle = page.querySelector(searchAgrResult);
	    String agrtext = elementHandle.textContent();
	    System.out.println(agrtext);
		Assert.assertEquals(agrtext, AgreementNo);
		return false;
		
	}
	
	public QuickQuotePage clickQuickQuote()
	{
		page.click(clickQuickQuote);
		if(page.isVisible(clickQuote))
		{
			System.out.println("user is in Quote page ");
		}
		return new QuickQuotePage(page);
	}
	
}
