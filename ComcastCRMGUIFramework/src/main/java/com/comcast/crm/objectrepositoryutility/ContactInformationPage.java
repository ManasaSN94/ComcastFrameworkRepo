package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	WebDriver driver;
	public ContactInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement headermsg;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastName;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement supportEndDate;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement supportStartDate;
	
	public WebElement getHeadermsg() {
		return headermsg;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}

	public WebElement getSupportStartDate() {
		return supportStartDate;
	}
	
	

}
