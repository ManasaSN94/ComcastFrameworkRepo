package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrgTest {
public static void main(String[] args) throws Throwable {
		
		//create Object
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		//Read the data from properties file
		
		String URL=fLib.getDataFromPropertiesFile("url");
		String BROWSER=fLib.getDataFromPropertiesFile("browser");
		String USERNAME=fLib.getDataFromPropertiesFile("username");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
		
		//read testscript data from excel file
    	String orgName=eLib.getDataFromExcel("org", 10, 2) + jLib.getRandomNumber();
    	String searchdpdn=eLib.getDataFromExcel("org", 10, 3);
      
           WebDriver driver=null;
          if(BROWSER.equals("edge")) {
	       driver=new EdgeDriver();
	}
        else if(BROWSER.equals("chrome")) {
	   driver=new ChromeDriver();
  }    else if(BROWSER.equals("firefox")) {
	   driver=new FirefoxDriver();
}
       else {
	   driver=new ChromeDriver();
}

       //step 1: login to app
       
       LoginPage lp=new LoginPage(driver);
       lp.loginToApp(URL, USERNAME, PASSWORD);
       
    
        //step2:navigate to organization module
        HomePage hp=new HomePage(driver);
        hp.getOrgLink().click();
    
        //step3:click on "create organization" button
       OrganizationsPage op=new OrganizationsPage(driver);
       op.getCreateNewOrgBtn().click();
    
       //Step4: enter all the details & create new organization
       CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver) ;
      // cno.getOrgNameTxtBox().sendKeys("");
     //  cno.getSaveBtn().click();
       cno.createOrg(orgName);
        
        //verify the header msg expected result
       OrganizationInformationPage oip=new OrganizationInformationPage(driver);
      String actOrgname = oip.getHeaderMsg().getText();
      if(actOrgname.contains(orgName)) {
    	  System.out.println(orgName + " is verified===PASS");
      }else {
    	  System.out.println(orgName + " is not verified===FAIL");
      }
      
      //go back to organization page
      hp.getOrgLink().click();
    		  
      //search for organization
      op.getSearchEdit().sendKeys(orgName);
      wLib.select(op.getSearchDpDn(), searchdpdn);
      op.getSearchBtn().click();
      
      //in dyanamic webtable select & delete org
      driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
      wLib.switchToAlertAndAccept(driver);

         //step 5:logout
         hp.logout();


         driver.quit();

}

}	



