package com.mystore.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow rw;
	public static XSSFCell cl;
	
	public static int getRowCount(String filePath, String Sheet) throws IOException {
		fi = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(Sheet);
		int rowNum = sh.getLastRowNum();
		
		fi.close();
		wb.close();
		return rowNum;
		
	}
	
	public static int getCellCount(String filePath, String Sheet, int rownum) throws IOException {
		fi = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(Sheet);
		rw = sh.getRow(rownum);
		int cellNum = sh.getRow(rownum).getLastCellNum();
		
		fi.close();
		wb.close();
		return cellNum;
	}
	
	public static String getCellData(String filePath, String Sheet, int rownum, int cellnum) throws IOException {
		fi = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(Sheet);
		rw = sh.getRow(rownum);
		cl = rw.getCell(cellnum);
		String data;
		
		try {
			DataFormatter dt = new DataFormatter();
			String cellData=dt.formatCellValue(cl);
			return cellData;
			
		}catch(Exception e) {
		data=" ";
			
		}
		
		fi.close();
		wb.close();
		return data;
		
		
	}
	

}
