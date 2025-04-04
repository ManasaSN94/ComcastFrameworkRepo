package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	WebDriver driver;
	public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath=("//img[@title='Create Organization...']"))
	private WebElement createNewOrgBtn;
	
	@FindBy(name="search_text")
	private WebElement searchEdit;
	
	@FindBy(name="search_field")
	private WebElement searchDpDn;
	
	@FindBy(name="submit")
	private WebElement searchBtn;
	
	

	public WebDriver getDriver() {
		return driver;
	}



	public WebElement getSearchEdit() {
		return searchEdit;
	}



	public WebElement getSearchDpDn() {
		return searchDpDn;
	}



	public WebElement getSearchBtn() {
		return searchBtn;
	}



	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	

	
	
	
	}

