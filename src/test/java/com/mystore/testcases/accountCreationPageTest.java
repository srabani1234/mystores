package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.testDataProvider;
import com.mystore.pageobjects.accountCreationPage;
import com.mystore.pageobjects.indexPage;
import com.mystore.pageobjects.loginPage;

public class accountCreationPageTest extends BaseClass{
	
	indexPage IndexPage;
	loginPage LoginPage;
	accountCreationPage AccountCreationPage;
	@Parameters("browserName")
	@BeforeMethod (groups = {"Smoke","Sanity","Regression"})
	public void setup(String browserName) {
		launchBrowser(browserName);
	}
	@AfterMethod (groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().close();
	}
	
	@Test(dataProviderClass = testDataProvider.class, dataProvider="createAccEmail", priority=1)
	public void createAnAccount(String createnewaccountemail) {
		IndexPage = new indexPage();
		LoginPage=IndexPage.clicSignInBtn();
		AccountCreationPage=LoginPage.createNewAccount(createnewaccountemail);
	}
	
	@Test(priority=2,dataProviderClass = testDataProvider.class, dataProvider="createAccEmail")
	public void verifyCreateAccountPageTitle(String createnewaccountemail) throws Throwable {
		IndexPage = new indexPage();
		LoginPage=IndexPage.clicSignInBtn();
		AccountCreationPage=LoginPage.createNewAccount(createnewaccountemail);
		boolean accountPageName = AccountCreationPage.verifyAccountCreatePageName();
		Assert.assertTrue(accountPageName);
	}

}
