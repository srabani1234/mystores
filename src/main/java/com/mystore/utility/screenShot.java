package com.mystore.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenShot {
	
	public static String takeScreenShotOfFailTC(WebDriver driver, String methodName) {
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\ScreenShot\\"+methodName+"_"+dateName+".png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		// This new path for jenkins
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + methodName + "_"
				+ dateName + ".png";
		return newImageString;
	}

}
