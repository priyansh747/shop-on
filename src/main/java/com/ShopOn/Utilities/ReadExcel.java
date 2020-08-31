package com.ShopOn.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	private String fileLocation ;
	private String sheetName;
	private Sheet excelSheet;
	public ReadExcel() {
		super();
	}
	public ReadExcel(String fileLocation, String sheetName) throws IOException {
		super();
		this.fileLocation = fileLocation;
		this.sheetName = sheetName;
	}
	
	public void ReadSheet(Sheet Sheet) {
		int rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();
		//Create a loop over all the rows of excel file to read it
		for (int i = 1; i < rowCount+1; i++) {
			Row row = Sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.print(row.getCell(j).getStringCellValue()+"\t\t");
			}
			System.out.println();
		} 
	}
	
	public Sheet setExcelSheet() throws IOException {
		File file = new File(fileLocation);
		//File file = new File("C:\\Users\\randy\\Downloads\\Git Projects\\Excel Read\\example1.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook example1 = null;
		example1 = new XSSFWorkbook(inputStream);
		Sheet exampleSheet = example1.getSheet(sheetName);
		//Sheet exampleSheet = example1.getSheet("Sheet1");
		return exampleSheet;
	}
	

}
