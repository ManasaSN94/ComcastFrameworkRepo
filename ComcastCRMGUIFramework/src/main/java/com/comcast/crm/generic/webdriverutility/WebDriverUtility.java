package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
	
	public void waitForElementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabOnTitle(WebDriver driver,String partialTitle) {
		Set<String> childWindows=driver.getWindowHandles();
		for(String window:childWindows) {
			driver.switchTo().window(window);
			if(driver.getTitle().contains(partialTitle)) {
				break;
			}	
			}
		}
		
/*	public void switchToTabOnTitle(WebDriver driver,String partialTitle){
	Set<String> set=driver.getWindowHandles();
	Iterator<String> it=set.iterator();
	
	while(it.hasNext()) {
		String WindowID=it.next();
		driver.switchTo().window(WindowID);
		String actUrl=driver.getTitle();
		if(actUrl.contains(partialTitle)) {
			Break;
		}
	}*/
		public void switchToTabOnURL(WebDriver driver,String partialURL) {
			Set<String> childWindows=driver.getWindowHandles();
			for(String window:childWindows) {
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains(partialURL)) {
					break;
				}
					
				}
			}
		/*	public void switchToTabOnURL(WebDriver driver,String partialURL){
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()) {
			String WindowID=it.next();
			driver.switchTo().window(WindowID);
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains(partialURL)) {
				Break;
			}
		}*/

		public void switchToFrame(WebDriver driver,int index) {
			driver.switchTo().frame(index);
		}
		
		public void switchToFrame(WebDriver driver,String NameId) {
			driver.switchTo().frame(NameId);
		}
		public void switchToFrame(WebDriver driver,WebElement element) {
			driver.switchTo().frame(element);
			
		}
		
		public void switchToAlertAndAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		
		public void switchToAlertAndCancel(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		
		public  void select(WebElement element,String vistext) {
			Select sel=new Select(element);
			sel.selectByVisibleText(vistext);
		}
		
		public void select(WebElement element,int index) {
			Select sel=new Select(element);
			sel.selectByIndex(index);
		}
		
		public void mouseMoveOnElement(WebDriver driver,WebElement element) {
			Actions act=new Actions(driver);
			act.moveToElement(element).perform();
		}
		
		public void doubleClick(WebDriver driver,WebElement element) {
			Actions act=new Actions(driver);
			act.doubleClick().perform();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}

