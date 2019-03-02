package com.actiTimeSimple.generic;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils {

	public static void getScreenShot(WebDriver driver,String name)
	{
		try
		{
			TakesScreenshot t=(TakesScreenshot)driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./screenshots/"+name+".png"));
			
		}
		catch(Exception e)
		{
			
		}
	}
	public static void selectByIndex(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement element, String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	public static void SelectByVisibleText(WebElement element, String Text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(Text);
	}
}
