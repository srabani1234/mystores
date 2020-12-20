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
import com.mystore.pageobjects.indexPage;
import com.mystore.pageobjects.orderPage;
import com.mystore.pageobjects.searchResultPage;

public class orderPageTest extends BaseClass{
	
	indexPage IndexPage;
	searchResultPage SearchResultPage;
	addToCart AddToCart;
	orderPage OrderPage;
	
	
	@Parameters("browserName")
	@BeforeMethod (groups = {"Smoke","Sanity","Regression"})
	public void setup(String browserName) {
		launchBrowser(browserName);
	}
	@AfterMethod (groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().close();
	}
	@Test(dataProviderClass=testDataProviderByMap.class, dataProvider = "getTestDataFromExcel",groups="Regression")
	public void proceedToOrder(Map<String, String> map) throws Throwable {
		 IndexPage = new indexPage();
		 SearchResultPage= IndexPage.searchProduct(map.get("searchproduct"));
		 AddToCart = SearchResultPage.clickOnSearchProduct();
		 AddToCart.enterQuantity(map.get("quantity"));
		 AddToCart.enterSize(map.get("size"));
		 AddToCart.clickAddToCart();
		 OrderPage= AddToCart.clickProceedToCheckBtn();
		double unitPrice= OrderPage.getUnitPrice();
		double totalPrice = OrderPage.getTotalPrice();
		System.out.println(totalPrice);
		String quanity = map.get("quantity");
		double getQuan= Double.parseDouble(quanity);
		int qua = (int)getQuan;;
		//int quan =Integer.parseInt(quanity);
		System.out.println(qua);
		double actualTotalPrice = (unitPrice*qua)+2;
		
		Assert.assertEquals(actualTotalPrice, totalPrice);
		 
		 
	}

}
