package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	//create object
	
	public DatabaseUtility dbLib=new DatabaseUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	
	@BeforeSuite(groups= {"smokeTest","regression"})
	public void configBS() {
		System.out.println("====connect to DB, Report config=====");
		dbLib.getDbconnection();
	}
		
	     //@Parameters("BROWSER")
	@BeforeClass(groups={"smokeTest","regression"})
	//public void configBC(String browser)
	  public void configBC() throws Throwable {
	  System.out.println("===Launch the BROWSER===");
	 // String BROWSER=fLib.getDataFromPropertiesFile("browser");
	  String BROWSER=System.getProperty("browser", fLib.getDataFromPropertiesFile("browser"));
			  //browser;
	  if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
			}
		else if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
	  sdriver=driver;
	  UtilityClassObject.setDriver(driver);
	
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
	System.out.println("===Login===");	
   // String URL=fLib.getDataFromPropertiesFile("url");
   // String USERNAME=fLib.getDataFromPropertiesFile("username");
   // String PASSWORD=fLib.getDataFromPropertiesFile("password");
	String URL=System.getProperty("url",fLib.getDataFromPropertiesFile("url"));
	String USERNAME=System.getProperty("username",fLib.getDataFromPropertiesFile("username"));
	String PASSWORD=System.getProperty("password",fLib.getDataFromPropertiesFile("password"));
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(URL, USERNAME, PASSWORD);
	
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void comfigAM() {
		System.out.println("===Logout===");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("====Close the Browser=====");
		driver.quit();
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAS() throws SQLException {
		System.out.println("====close DB, Report backup====");
		dbLib.closeDbconnection();

	}
	

}
