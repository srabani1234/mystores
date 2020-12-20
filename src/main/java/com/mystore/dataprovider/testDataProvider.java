package com.mystore.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class testDataProvider {
	
	public static Object[][] getTestData(String path, String sheet) throws IOException{
		Object[][] dataFromExcel = null;
		
		int rowCount = XLUtils.getRowCount(path, sheet);
		int cellCount = XLUtils.getCellCount(path, sheet, 1);
		
		dataFromExcel = new Object[rowCount][cellCount];
		for(int i=1;i<=rowCount;i++) {
			for(int j=0; j<cellCount;j++) {
				 dataFromExcel[i-1][j] = XLUtils.getCellData(path, sheet, i, j);
			}
			
		}
		return dataFromExcel;
		
	}
	
	String path = System.getProperty("user.dir")+"\\src\\main\\resources\\testdata\\testData.xlsx";
	String sheet = "Sheet1";
	@DataProvider(name="getPageTitle")
	public Object[][] getPageTitle() throws IOException{
		Object[][] data = testDataProvider.getTestData(path, sheet);
		return data;
	}
	
	@DataProvider(name="homePageUrl")
	public Object[][] getHomePageUrl() throws IOException{
		Object[][] data = testDataProvider.getTestData(path, "Sheet2");
		return data;
	}
	
	@DataProvider(name="createAccEmail")
	public Object[][] getCreateAccountEmail() throws IOException{
		Object[][] data = testDataProvider.getTestData(path, "Sheet3");
		return data;
	}
	

}
