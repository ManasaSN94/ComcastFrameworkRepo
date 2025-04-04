package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

	
	
	public class CreatingNewContactPage  {
		
		
		WebDriver driver;
		WebDriverUtility wLib=new WebDriverUtility();
		public CreatingNewContactPage(WebDriver driver) {
			
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastnameEdit;
	
	@FindBy(name="support_end_date")
	private WebElement supportEndDateEdit;
	
	@FindBy(name="support_start_date")
	private WebElement supportStartdateEdit;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgNameBtn;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(name="search_text")
	private WebElement searchEdit;
	
	@FindBy(name="search_field")
	private WebElement searchDpDn;
	
	@FindBy(name="submit")
	private WebElement searchBtn;

	
	
	public WebElement getSearchEdit() {
		return searchEdit;
	}

	public WebElement getSearchDpDn() {
		return searchDpDn;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getLastnameEdit() {
		return lastnameEdit;
	}

	public WebElement getSupportEndDateEdit() {
		return supportEndDateEdit;
	}

	public WebElement getSupportStartdateEdit() {
		return supportStartdateEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgNameBtn() {
		return orgNameBtn;
	}
	
	public void createContact(String lastname) {
		lastnameEdit.sendKeys(lastname);
		saveBtn.click();
		
	}
	
	public void createContactwithOrgname(String lastname,String orgName) {
		lastnameEdit.sendKeys(lastname);
		orgNameBtn.click();
		wLib.switchToTabOnTitle(driver, "Organization")	;
		
	}
	
	public void createContactWithSupportdate(String lastname,String startDate, String endDate) {
		lastnameEdit.sendKeys(lastname);
		supportStartdateEdit.sendKeys(startDate);
		supportEndDateEdit.clear();
		supportEndDateEdit.sendKeys(endDate);
		saveBtn.click();
		
	}
	
	

}
