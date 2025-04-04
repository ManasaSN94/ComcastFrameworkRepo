package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameTxtBox;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industryDpDn;
	
	@FindBy(name="accounttype")
	private WebElement typeDpDn;
	
	@FindBy(id="phone")
	private WebElement phnNumrEdit;

	
	public WebElement getOrgNameTxtBox() {
		return orgNameTxtBox;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	public WebElement getIndustryDpDn() {
		return industryDpDn;
	}

	public WebElement getTypeDpDn() {
		return typeDpDn;
	}

	public WebElement getPhnNumrEdit() {
		return phnNumrEdit;
	}

	public void createOrg(String orgName) {
		orgNameTxtBox.sendKeys(orgName);
		saveBtn.click();
		}
	
	public void createOrg(String orgName,String industry,String type) {
		orgNameTxtBox.sendKeys(orgName);
		Select sel=new Select(industryDpDn);
		sel.selectByVisibleText(industry);
		Select sel1=new Select(typeDpDn);
		sel1.selectByVisibleText(type);
		
		saveBtn.click();
		}
	
	
	
	
	

}
