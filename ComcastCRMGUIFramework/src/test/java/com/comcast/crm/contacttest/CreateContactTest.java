package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
/**
 * 
 * @author manasa
 */
@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class CreateContactTest extends BaseClass {
	WebDriverUtility wLib=new WebDriverUtility();

	@Test(groups="smokeTest")
	public void createContactTest() throws Throwable {
		/* read testscript data from excel file*/
		String lastname = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		/* navigate to contacts module*/
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// click on create contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		//  enter all the details & create new contacts
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContact(lastname);

		// Verify the header msg
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actHeader = cip.getHeadermsg().getText();
		boolean status=actHeader.contains(lastname);
		Assert.assertTrue(status);
		
		String actlastName=cip.getLastName().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actlastName, lastname);
		soft.assertAll();
	}


    @Test(groups="regressionTest")
    public void  createContactWithSupportDateTest() throws Throwable {
    	
    	   //read testscript data from excel file
    	
		  String lastname=eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();
	      
		//step2:navigate to contacts module
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();

     //step3:click on "create contacts" button
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();
		
		//Step4: enter all the details & create new contacts
		String startDate=jLib.getSystemDateYYYYDDMM();
		String endDate=jLib.getRequiredDateYYYYDDMM(30);
		System.out.println(endDate);
        CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createContactWithSupportdate(lastname, startDate, endDate);
		
		//verification for startDate and endDate
		ContactInformationPage cip=new ContactInformationPage(driver);
	String actstartdate= cip.getSupportStartDate().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actstartdate, startDate);
		soft.assertAll();
		
		String actenddate=cip.getSupportEndDate().getText();
		soft.assertEquals(actenddate, endDate);
		soft.assertAll();
		}

    @Test(groups="regressionTest") 
     public void createContactWithOrgTest() throws Throwable {
	
	//read testscript data from excel file
	  String orgName=eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
	  String contactlastname=eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
	  
	  //navigate to organization module
	  HomePage hp=new HomePage(driver);
	  hp.getOrgLink().click();

	//click on "create organization" button
	OrganizationsPage op=new OrganizationsPage(driver);
	op.getCreateNewOrgBtn().click();
	
	// enter all the details & create new organization
	CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
	cnop.createOrg(orgName);
	 
	//verify header orgname info expected result

	OrganizationInformationPage oip=new OrganizationInformationPage(driver);
	 String actheaderinfo=oip.getHeaderMsg().getText();
	 boolean status=actheaderinfo.contains(orgName);
	 Assert.assertTrue(status);
	 
	   //navigate to contact module
	 hp.getContactLink().click();
	
	//click on "create contacts" button
	ContactsPage cp=new ContactsPage(driver);
	cp.getCreateNewContactBtn().click();
	
	//Step8: enter all the details & create new contacts
	CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
	cncp.createContactwithOrgname(contactlastname, orgName);
	driver.findElement(By.name("search_text")).sendKeys(orgName);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	wLib.switchToTabOnTitle(driver, "Contacts");
	cncp.getSaveBtn().click();
	
	
	//verify the header msg expected result
	ContactInformationPage cip=new ContactInformationPage(driver);
	String actheaderinfo1=cip.getHeadermsg().getText();
	boolean status1=actheaderinfo1.contains(contactlastname);
	Assert.assertTrue(status1);
	
	//verify Header Orgname info Expected result
	String actOrgName=driver.findElement(By.id("mouseArea_Organization Name")).getText();
	boolean sta=actOrgName.contains(orgName);
	Assert.assertTrue(sta);
	

}
}
