package com.actiTimeSimple.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {
	
	public WebDriver driver;

	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//To verify the title
	public String verifyTitle(String eTitle)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		try
		{
			wait.until(ExpectedConditions.titleContains(eTitle));
			Reporter.log("Title is matching: \nExpected title is :"+eTitle ,true);
			Reporter.log("Actual Title is   :"+driver.getTitle(),true);
			return eTitle;
		
		}
		catch(Exception e)
		{
			
			Reporter.log("Title is not matching: \nExptect title is :"+eTitle,true);
			Reporter.log("Actual Title is       :"+driver.getTitle(),true);
			Assert.fail();
			return " ";
		}
		
		
	}
	
		//To verify the element
		public void verifyElement(WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver,10);
			
			
			try 
			{
				wait.until(ExpectedConditions.visibilityOf(element));
				Reporter.log("Element is present: ",true);
			}
			
			catch(Exception e)
			{
				Reporter.log("Element is not present",true);
				Assert.fail();
				
			}
		
			
		}
	
}
