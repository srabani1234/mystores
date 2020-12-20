package com.mystore.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.testDataProviderByMap;
import com.mystore.pageobjects.addToCart;
import com.mystore.pageobjects.homePage;
import com.mystore.pageobjects.indexPage;
import com.mystore.pageobjects.loginPage;
import com.mystore.pageobjects.searchResultPage;

public class addToCartPageTest extends BaseClass {
	
	indexPage IndexPage;
	searchResultPage SearchResultPage;
	addToCart AddToCart;
	@Parameters("browserName")
	@BeforeMethod (groups = {"Smoke","Sanity","Regression"})
	public void setup(String browserName) {
		launchBrowser(browserName);
	}
	@AfterMethod (groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().close();
	}
	@Test(dataProviderClass=testDataProviderByMap.class, dataProvider = "getTestDataFromExcel", groups="Regression")
	public void addProductToCart(Map<String, String> map) {
		 IndexPage = new indexPage();
		 SearchResultPage= IndexPage.searchProduct(map.get("searchproduct"));
		 AddToCart = SearchResultPage.clickOnSearchProduct();
		 AddToCart.enterQuantity(map.get("quantity"));
		 AddToCart.enterSize(map.get("size"));
		 AddToCart.clickAddToCart();
		boolean productAddedToCart= AddToCart.validateProductAddToCart();
		Assert.assertTrue(productAddedToCart);
	}
}
