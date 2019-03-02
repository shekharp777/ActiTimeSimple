package com.actiTimeSimple.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actiTimeSimple.generic.BaseTest;
import com.actiTimeSimple.generic.ExcelData;
import com.actiTimeSimple.pages.EnterTimeTrackPage;
import com.actiTimeSimple.pages.LoginPage;

public class TC04Test extends BaseTest {
	
	@Test(priority=4)
	public void testTC04() throws InterruptedException
	{
		//user name
		String un = ExcelData.getData(File_Path, "sheet4", 1, 0);
		
		//password
		String pwd= ExcelData.getData(File_Path, "sheet4", 1, 1);
		
		//build no
		String eBuildNo= ExcelData.getData(File_Path, "sheet4", 1, 2);
		
		LoginPage lp=new LoginPage(driver);
		//enter user name
		lp.enterUserName(un);
		
		//enter password
		lp.enterPassword(pwd);
		
		Thread.sleep(2000);
		//click on login
		lp.clickOnLogin();
		
		EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
		
		
		Thread.sleep(3000);
		//click on help
		ep.clickOnHelp();
		
		Thread.sleep(2000);
		//click on about actitime
		ep.clickOnAbout();
		
		Thread.sleep(2000);
		//verify build no
		String aBuildNo = ep.verifyBuildNo();
		Reporter.log("Actual Build No is   :"+aBuildNo, true);
		Reporter.log("Expected build No is :"+eBuildNo, true);
		
		SoftAssert sa=new SoftAssert();
		AssertJUnit.assertEquals(aBuildNo, eBuildNo);
		sa.assertAll();
		
	}

}
