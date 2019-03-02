package com.actiTimeSimple.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements AutoConstant
{
	public static WebDriver driver;
	
	@BeforeMethod
	public void preCondition() 
	{
		
		System.setProperty(chrome_key,chrome_value);
		System.setProperty(gecko_key,gecko_value);
		
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost/login.do");
		
		
	}
	
	@AfterMethod
	public void postCondition(ITestResult res)
	{
		int status=res.getStatus();
		if(status==2)
		{
			String name=res.getName();
			GenericUtils.getScreenShot(driver,name);
			
		}
		
		driver.close();
	}

}
