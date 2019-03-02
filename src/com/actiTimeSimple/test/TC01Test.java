package com.actiTimeSimple.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.actiTimeSimple.generic.BaseTest;
import com.actiTimeSimple.generic.ExcelData;
import com.actiTimeSimple.pages.EnterTimeTrackPage;
import com.actiTimeSimple.pages.LoginPage;


public class TC01Test extends BaseTest {

	@Test(priority=1)
	public void testTC01()
	{
				//user name
				String un = ExcelData.getData(File_Path, "Sheet1", 1, 0);
				
				//password
				String pwd = ExcelData.getData(File_Path, "Sheet1", 1, 1);
				
				//login page title
				String loginTitle = ExcelData.getData(File_Path, "Sheet1", 1, 2);
						
				
				//EnterTimeTrackPage title
				String enterTimeTitle = ExcelData.getData(File_Path, "Sheet1", 1, 4);
				
				
				LoginPage lp=new LoginPage(driver);
				//verify login page title
				lp.verifyingTitle(loginTitle);
				
				//enter valid user name
				lp.enterUserName(un);
				

				//enter valid password
				lp.enterPassword(pwd);
				
				//click on login
				lp.clickOnLogin();
				System.out.println("click on login");
				
				
				EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
				//verify enter time track page title
				ep.verifyingTitle(enterTimeTitle);
				
				//click on logout
				ep.clickOnLogOut();
				System.out.println("click on logout");
				
				
	}

}
