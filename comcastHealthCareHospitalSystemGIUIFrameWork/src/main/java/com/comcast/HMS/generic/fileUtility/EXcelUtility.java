package com.comcast.HMS.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class EXcelUtility {

public String getDataFromExcel(String sheetNname , int rowNum , int cellNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream efis = new FileInputStream("./TestData/AllData.xlsx");
		Workbook wb = WorkbookFactory.create(efis);
		String data = wb.getSheet(sheetNname).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream efis = new FileInputStream("./TestData/AllData.xlsx");
		Workbook wb = WorkbookFactory.create(efis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	public void setDataIntoExcel(String sheetName , int rowNum , int cellNum , String data) throws EncryptedDocumentException, IOException {
		FileInputStream efis = new FileInputStream("./TestData/AllData.xlsx");
		Workbook wb = WorkbookFactory.create(efis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		
		FileOutputStream fos = new FileOutputStream("./TestData/TestingDa.xlsx");
		wb.write(fos);
		wb.close();
	}
}
