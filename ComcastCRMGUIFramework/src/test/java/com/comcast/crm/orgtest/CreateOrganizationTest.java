package com.comcast.crm.orgtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listenerutility.ListenerImpClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups="smokeTest")
	
	public void createOrganizationTest() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		
		//read testscript data from excel file
    	String orgName=eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
      
        //navigate to organization module
    	UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
        HomePage hp=new HomePage(driver);
        hp.getOrgLink().click();
    
        //click on "create organization" button
        UtilityClassObject.getTest().log(Status.INFO, "navigate to createorg page");
       OrganizationsPage op=new OrganizationsPage(driver);
       op.getCreateNewOrgBtn().click();
    
       //Step4: enter all the details & create new organization
       UtilityClassObject.getTest().log(Status.INFO, "create new org");
       CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver) ;
      // cno.getOrgNameTxtBox().sendKeys("");
     //  cno.getSaveBtn().click();
       cno.createOrg(orgName);
       UtilityClassObject.getTest().log(Status.INFO, orgName +"===>create a new Org");
        
        //verify the header msg expected result
       OrganizationInformationPage oip=new OrganizationInformationPage(driver);
      String actOrgname = oip.getHeaderMsg().getText();
     boolean status=actOrgname.contains(orgName);
     Assert.assertTrue(status);
    // Assert.assertEquals(actOrgname, orgName);
}
	
	@Test(groups="regressionTest") 
	public void createOrganizationWithIndustriesTest() throws Throwable {
		
		//read testscript data from excel file
		UtilityClassObject.getTest().log(Status.INFO, "read the data from excel");
				String orgName=eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
				String industry=eLib.getDataFromExcel("org", 4, 3);
				String type=eLib.getDataFromExcel("org", 4, 4);
				
				 //step2:navigate to organization module
				UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
				  HomePage hp=new HomePage(driver);
				  hp.getOrgLink().click();

				  //step3:click on "create organization" button
				  UtilityClassObject.getTest().log(Status.INFO, "navigate to Createorg page");
				  OrganizationsPage op=new OrganizationsPage(driver);
				  op.getCreateNewOrgBtn().click();

				  //Step4: enter all the details & create new organization
				  UtilityClassObject.getTest().log(Status.INFO, "create new org");
				  CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
				  cnop.createOrg(orgName, industry, type);
				 
				    //verify the industries type info
				  OrganizationInformationPage  oip=new OrganizationInformationPage(driver);
				  String actIndustry=oip.getIndustry().getText();
				  SoftAssert soft=new SoftAssert();
				  soft.assertEquals(actIndustry, industry);
				 soft.assertAll();
			}
	
	
	@Test(groups="regressionTest")
	public void createOrganizationWithPhoneNumberTest() throws Throwable {
		
		//read testscript data from excel file
		UtilityClassObject.getTest().log(Status.INFO, "read the data from excel");
    	String orgName=eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
    	String phnnumber=eLib.getDataFromExcel("org", 7, 3);
      
		
        //step2:navigate to organization module
    	UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
         HomePage hp=new HomePage(driver);
         hp.getOrgLink().click();

         //step3:click on "create organization" button
         UtilityClassObject.getTest().log(Status.INFO, "navigate to create new org page");
         OrganizationsPage op=new OrganizationsPage(driver);
         op.getCreateNewOrgBtn().click();

         //Step4: enter all the details & create new organization
         UtilityClassObject.getTest().log(Status.INFO, "create new org ");
         CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
         cnop.getOrgNameTxtBox().sendKeys(orgName);
         cnop.getPhnNumrEdit().sendKeys(phnnumber);
         cnop.getSaveBtn().click();

          //verify the phone number
         OrganizationInformationPage oip=new OrganizationInformationPage(driver);
         String actphnnumber=oip.getPhnNumber().getText();
         SoftAssert soft=new SoftAssert();
         soft.assertEquals(actphnnumber, phnnumber);
         soft.assertAll();
  }

     }
		
		
		
		
	

	


