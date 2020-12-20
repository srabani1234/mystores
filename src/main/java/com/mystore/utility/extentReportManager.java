package com.mystore.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentReportManager {

	public static ExtentHtmlReporter extentHtmlReport;
	public static ExtentReports extentReport;
	public static ExtentTest test;
	
	public static void extentReportSetUp() {
		extentHtmlReport = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
		extentHtmlReport.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(extentHtmlReport);
		
		
		extentReport.setSystemInfo("hostname", "My host");
		extentReport.setSystemInfo("OS", "win-10");
		extentReport.setSystemInfo("browser", "chrome");
		extentReport.setSystemInfo("tester", "Srabani");
		extentReport.setSystemInfo("project", "My project");
	}
	
	public static void endReport() {
		extentReport.flush();
	}
}
