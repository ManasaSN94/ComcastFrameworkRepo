package com.comcast.crm.campaigntest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class CreateCampaignTest {
	
	public static void main(String[] args) throws Throwable {
		
		//Create Object
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		
		
		//Read the data from PropertiesFile
		String URL=fLib.getDataFromPropertiesFile("url");
		String BROWSER=fLib.getDataFromPropertiesFile("browser");
		String USERNAME=fLib.getDataFromPropertiesFile("username");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
		
		//Generate the random Number
		Random random=new Random();
		int randomNum = random.nextInt(1000);
		
		//read the data from ExcelFile
		String campName = eLib.getDataFromExcel("campaign", 1, 2) + randomNum;
		System.out.println(campName);
		
		WebDriver driver=null;
		if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		
		//Login to application
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to campaigns module
		driver.findElement(By.linkText("More")).click();
		Actions act=new Actions(driver);
		WebElement campaign=driver.findElement(By.linkText("Campaigns"));
		act.moveToElement(campaign).click().perform();
		
		
		//click on "Create Campaigns" button
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//enter all the details and create new Campaigns
		driver.findElement(By.name("campaignname")).sendKeys(campName);
		driver.findElement(By.name("button")).click();
		
		//Verify Headermsg expected result
		 String headermsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 if (headermsg.contains(campName)) {
			 System.out.println(campName + "is created===pass");
		 }
		 else {
			 System.out.println(campName + "is not created===FAIL");
		 }
		 
		 //verify header campaignName info expected result
		 String actOrgName=driver.findElement(By.id("dtlview_Campaign Name")).getText();
		 if(actOrgName.equals(campName)) {
		 	System.out.println(campName + "is created===PASS");
		 }else {
		 	System.out.println(campName + "is not created===FAIL");
		 }

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
