package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.mystore.utility.extentReportManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import om.mystore.actiondriver.Action;

public class BaseClass {
	public static Properties prp;
	// public static WebDriver driver;
	// declre thread local driver  When you have decided to run your selenium’s tests in parallel, your Webdriver object should be thread-safe i.e. a single object can be used with multiple threads at the same time without causing problems.
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	
	public static WebDriver getDriver() {
		// get driver from local driver
		return driver.get();
		
	}
	
	@BeforeSuite (groups = { "Smoke", "Sanity", "Regression" })
	public void beforeSuite() {
		extentReportManager.extentReportSetUp();
		DOMConfigurator.configure("log4j.xml");
	}
	@BeforeTest (groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() {
		
		try {
			prp = new Properties();
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\configuration\\config.properties");
			prp.load(fi);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	@Parameters("browserName")
	public static void launchBrowser(String browserName) {
		// WebDriverManager.chromedriver().setup();
	//	String browserName = prp.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			//System.setProperty ("webdriver.chrome.driver","F:\\selenium_update_12-10-2019\\chromedriver.exe");
			// driver=new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			// set browserr to threadLocalMap
			driver.set(new ChromeDriver());
			
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			//System.setProperty("webdriver.gecko.driver", "F:\\selenium_update_12-10-2019\\geckodriver.exe");
			
			// driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			
		}
		
		getDriver().get(prp.getProperty("url"));
		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(),10);
		Action.pageLoadTimeOut(getDriver(), 20);
		
	}
	@AfterSuite
	public void endSetup() {
		extentReportManager.endReport();
	}
	

}
