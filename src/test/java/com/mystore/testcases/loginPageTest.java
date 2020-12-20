package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.testDataProvider;
import com.mystore.pageobjects.homePage;
import com.mystore.pageobjects.indexPage;
import com.mystore.pageobjects.loginPage;
import com.mystore.utility.Log;

public class loginPageTest extends BaseClass {
	indexPage IndexPage;
	loginPage LoginPage;
	homePage HomePage;
	@Parameters("browserName")
	@BeforeMethod (groups = {"Smoke","Sanity","Regression"})
	public void setup(String browserName) {
		launchBrowser(browserName);
	}
	@AfterMethod (groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().close();
	}
	
	@Test(dataProvider ="homePageUrl", dataProviderClass = testDataProvider.class, groups= {"Sanity","Smoke"})
	public void loginTest(String homepageurl) {
		Log.onTestCaseStart("Login test start");
		IndexPage = new indexPage();
		Log.info("user goin to click on sign in button");
		LoginPage =IndexPage.clicSignInBtn();
		Log.info("user enter username and password");
		HomePage =LoginPage.login(prp.getProperty("username"), prp.getProperty("password"));
		Log.info("user retriver current url");
		String currentURL = HomePage.getCurrentURL();
		// String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(currentURL, homepageurl);
		Log.onTestCaseEnd("Login in test end successfulli");
		
	}

}
