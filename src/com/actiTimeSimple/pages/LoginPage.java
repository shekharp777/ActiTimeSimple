package com.actiTimeSimple.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.actiTimeSimple.generic.BasePage;


public class LoginPage extends BasePage {
	
	//Declaration
		@FindBy(id="username")
		private WebElement unTB;
		
		@FindBy(name="pwd")
		private WebElement pwTB;
		
		@FindBy(xpath = ".//*[@id='loginButton']/div")
		private WebElement loginBTN;
		
		@FindBy(xpath="//span[contains(.,'invalid')]")
		private WebElement errMsg;
		
		
		@FindBy(xpath="//nobr[contains(text(),'actiTIME ')]")
		private WebElement version;
		
		
	//Initialization
	public LoginPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		
	}

	

	//Utilization
	
	public void verifyingTitle(String eTitle)
	{
		verifyTitle(eTitle);	
		
	}
	
	public void enterUserName(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void enterPassword(String pw)
	{
		pwTB.sendKeys(pw);
	}
	
	public void clickOnLogin()
	{
		loginBTN.click();
	}
	
	
	public String verifyErrorMessage()
	{
		verifyElement(errMsg);
		String aErrMessage = errMsg.getText();
		return aErrMessage;
	}
	
	
	public void verifyVersion(String eVersion)
	{
		try
		{
			String aVersion=version.getText();
			Assert.assertEquals(aVersion, eVersion);
			Reporter.log("Actual version is   :"+aVersion,true);
			Reporter.log("Expected version is :"+eVersion,true);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	
}
