package com.comcast.crm.objectrepositoryutility;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * @author manasa
 * 
 * Contains Login page elements & business lib like login()
 * 
 */

public class LoginPage  extends WebDriverUtility { //Rule-1 Create a seperate java class
	
	//Rule-2 Object creation
	WebDriver driver;                         //Rule-3 Object initialization
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	//Rule-3 Object initialization
	
	//Rule-4 object Encapsulation

	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	/**
	 * login to application based on username,password,url arguments
	 * @param URL
	 * @param USERNAME
	 * @param PASSWORD
	 */
	
	//Rule-5 provide Action
	public void loginToApp( String URL,String USERNAME, String PASSWORD) {
		waitForPageToLoad(driver);
		driver.get(URL);
		driver.manage().window().maximize();
		usernameEdit.sendKeys(USERNAME);
		passwordEdit.sendKeys(PASSWORD);
		loginButton.click();
	}
	
}
