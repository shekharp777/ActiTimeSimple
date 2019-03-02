package com.actiTimeSimple.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.actiTimeSimple.generic.BaseTest;
import com.actiTimeSimple.generic.ExcelData;
import com.actiTimeSimple.pages.LoginPage;

public class TC03Test extends BaseTest {
	
	@Test(priority=3)
	public void testTC03()
	{
		//version data
		String eVersion=ExcelData.getData(File_Path, "sheet3", 1, 0);
		
		LoginPage lp=new LoginPage(driver);
		
		lp.verifyVersion(eVersion);
		
		
	}
	

}
