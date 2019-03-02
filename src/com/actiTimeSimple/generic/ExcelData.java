package com.actiTimeSimple.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {

	public static String getData(String filepath,String sheetName, int rn, int cn)
	{
		try {
			//1.Create file and read file
			FileInputStream fis=new FileInputStream(filepath);
			
			//2.get the workbook(groups of sheet)
			Workbook wb = WorkbookFactory.create(fis);
			
			//get the sheet
			Sheet sheet = wb.getSheet(sheetName);
			
			//get the row
			Row r = sheet.getRow(rn);
			
			//get the cell
			Cell c = r.getCell(cn);
			
			//get the data
			String data = c.getStringCellValue();
			
			return data;
			
		} 
		catch (Exception e) {
			return " ";
		}
		
	}
	
	
	//To get the row count
		public static int getRowCount(String path, String sheet)
		{
			try 
			{
				FileInputStream fis=new FileInputStream(path);
				new WorkbookFactory();
				Workbook wb=WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet(sheet);
				int rc = sh.getLastRowNum();
				
					return rc;
			}
			catch(Exception e)
			{
				return 0;
			}
		}
		
		
		//To get the cell count
		public static short getCellCount(String path, String sheet,int rn)
		{
			try
			{
				FileInputStream fis=new FileInputStream(path);
				Workbook wb=new WorkbookFactory().create(fis);
				Sheet sh = wb.getSheet(sheet);
				Row r = sh.getRow(rn);
				short cn = r.getLastCellNum();
				
				return cn;
				
			}
			catch(Exception e)
			{
				return 0;
			}
		}

}
