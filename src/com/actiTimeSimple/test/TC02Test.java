package com.actiTimeSimple.test;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actiTimeSimple.generic.BaseTest;
import com.actiTimeSimple.generic.ExcelData;
import com.actiTimeSimple.pages.LoginPage;

public class TC02Test extends BaseTest { //test class
	
	@Test(priority=2)
	public void testTC02() throws InterruptedException //test method
	{
		//to error message
		String eErrorMessage= ExcelData.getData(File_Path, "sheet2", 1, 2);
		
		LoginPage lp=new LoginPage(driver);
		
		int rc=ExcelData.getRowCount(File_Path, "sheet2");
		
		for(int i=1;i<=rc;i++)
		{
			String un=ExcelData.getData(File_Path, "sheet2", i, 0);
			String pwd=ExcelData.getData(File_Path, "sheet2", i, 1);
			

			Reporter.log("user name :"+un,true);
			Reporter.log("password :"+pwd,true);
			
			//enter user name
			lp.enterUserName(un);
			
			//enter password
			lp.enterPassword(pwd);
			
			
			//click on login
			lp.clickOnLogin();
			
			Thread.sleep(2000);
			//verify error message
			String aErrorMessage = lp.verifyErrorMessage();
			Reporter.log("Actual Error message is   :"+aErrorMessage, true);
			Reporter.log("Expected Error message is :"+eErrorMessage, true);
			
			SoftAssert sa=new SoftAssert();
			AssertJUnit.assertEquals(aErrorMessage, eErrorMessage);
			sa.assertAll();
		
		}
		
			
		
	}

}
