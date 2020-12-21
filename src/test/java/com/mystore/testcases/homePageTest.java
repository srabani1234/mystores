package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.homePage;
import com.mystore.pageobjects.indexPage;
import com.mystore.pageobjects.loginPage;

public class homePageTest extends BaseClass {
	
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
	
	@Test(priority=1)
	public void verifyWishList() {
		IndexPage = new indexPage();
		LoginPage= IndexPage.clicSignInBtn();
		HomePage =LoginPage.login(prp.getProperty("username"), prp.getProperty("password"),HomePage);
		boolean verifyPresentOfWishList = HomePage.validateMyWishList();
		Assert.assertTrue(verifyPresentOfWishList);
	}
	@Test(priority=2)
	public void verifyOrderHistory() {
		IndexPage = new indexPage();
		LoginPage= IndexPage.clicSignInBtn();
		HomePage =LoginPage.login(prp.getProperty("username"), prp.getProperty("password"), HomePage);
		boolean orderHistory= HomePage.validateOrderHistory();
		Assert.assertTrue(orderHistory);
	}

}
