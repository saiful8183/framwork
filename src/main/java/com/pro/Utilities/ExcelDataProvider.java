package com.pro.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook workbook;

	public ExcelDataProvider() {

		File src = new File("./TestData/Data.xlsx");

		try {
			FileInputStream fis = new FileInputStream(src);

			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read excell"+e.getMessage());
		}

	}

	
	public String getStringData(int sheetnum,int row,int column) {
		return  workbook.getSheetAt(sheetnum).getRow(row).getCell(column).getStringCellValue();
		
		
	}
	
	
	
	public String getStringData(String sheet,int row,int column) {
		return  workbook.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
		
		
	}
	
	
	
	public int getNumericData(String sheet,int row,int column) {
		return (int)(workbook.getSheet(sheet).getRow(row).getCell(column).getNumericCellValue());
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
