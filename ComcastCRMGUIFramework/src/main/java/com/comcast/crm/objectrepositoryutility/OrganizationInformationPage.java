package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="dvHeaderText")
	 private WebElement headerMsg;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industry;
	
	@FindBy(id="dtlview_Type")
	private WebElement type;
	
	@FindBy(id="dtlview_Phone")
	private WebElement phnNumber;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getType() {
		return type;
	}

	public WebElement getPhnNumber() {
		return phnNumber;
	}
	
	
	
	
	
	
	
	
	
	
	}
	
	


