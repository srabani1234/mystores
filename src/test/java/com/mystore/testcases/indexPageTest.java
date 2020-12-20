package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.testDataProvider;
import com.mystore.pageobjects.indexPage;

public class indexPageTest extends BaseClass{
	indexPage IndexPage;
	@Parameters("browserName")
	@BeforeMethod (groups = {"Smoke","Sanity","Regression"})
	public void setup(String browserName) {
		launchBrowser(browserName);
	}
	@AfterMethod (groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().close();
	}

	
	@Test (priority=1, groups= {"Smoke"})
	public void verifyLogo() {
		IndexPage = new indexPage();
		boolean result = IndexPage.pageLogo();	
		Assert.assertTrue(result);
		
	}
	@Test(dataProvider ="getPageTitle",dataProviderClass = testDataProvider.class,priority=2,groups= {"Smoke"})
	public void verifyTitle(String indexpagetitle) {
	String Actualtitle=	IndexPage.getMyStoreTitle();
	// String expectedTtle = "My Store";
	Assert.assertEquals(Actualtitle, indexpagetitle);

	}
	
	

}
