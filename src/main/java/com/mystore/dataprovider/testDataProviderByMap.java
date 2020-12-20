package com.mystore.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class testDataProviderByMap {
	
	public static Object[][] getDataFromExcell(String path, String sheet) throws IOException{
		Object[][] excelData = null;
		
		FileInputStream fi = new FileInputStream(path);
		
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		
		XSSFSheet sh = wb.getSheet(sheet);
		
		int rowNum = sh.getLastRowNum();
		int cellNum = sh.getRow(0).getLastCellNum();
		excelData = new Object[rowNum][1];
		
		for(int i=0; i<rowNum;i++) {
			Map<Object, Object> hm = new HashMap<Object, Object>();
			for(int j=0;j<cellNum;j++) {
				hm.put(sh.getRow(0).getCell(j).toString(),sh.getRow(i+1).getCell(j).toString());
			}
			excelData[i][0]=hm;
			System.out.println(hm);
			
		}
		return excelData;
		
	}
	
	String path = System.getProperty("user.dir")+"\\src\\main\\resources\\testdata\\testData.xlsx";
	@DataProvider(name="getTestDataFromExcel")
	public Object[][] getTestDataFromExcel() throws IOException{
		Object[][] data = getDataFromExcell(path, "Sheet4");
		return data;
	}

}
