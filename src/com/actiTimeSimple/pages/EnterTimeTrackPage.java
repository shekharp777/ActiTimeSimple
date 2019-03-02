package com.actiTimeSimple.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiTimeSimple.generic.BasePage;


public class EnterTimeTrackPage extends BasePage {

	//Declaration
	@FindBy(id="logoutLink")
	private WebElement logoutBTN;
	
	@FindBy(xpath="//div[@class='popup_menu_icon support_icon'][1]")
	private WebElement helpBTN;
	
	@FindBy(xpath="//a[.='About your actiTIME']")
	private WebElement aboutActiTime;
	
	@FindBy(xpath="//span[.='(build 39769)']")
	private WebElement buildNo;
	
	
	//Initialization
	public EnterTimeTrackPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
	}

	//Utilization
	
	public void verifyingTitle(String eTitle)
	{
		verifyTitle(eTitle);	
		
	}
	
		public void clickOnLogOut()
		{
			try
			{
			logoutBTN.click();
			}
			catch(Exception e)
			{
				
			}
		}
		
		//click on help
		public void clickOnHelp()
		{
			helpBTN.click();
			
		}
		
		//click on about actiTime
		public void clickOnAbout()
		{
			aboutActiTime.click();
		}
		
		//verify the build number
		public String verifyBuildNo()
		{
			verifyElement(buildNo);
			String aBuilNo = buildNo.getText();
			return aBuilNo;
			
		}					
		
}
