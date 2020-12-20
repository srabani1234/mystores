package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

import om.mystore.actiondriver.Action;

public class homePage extends BaseClass {

	@FindBy (xpath ="//span[contains(text(),'My wishlists')]")
	WebElement myWishListBtn;
	
	@FindBy (xpath = "//span[contains(text(),'Order history and details')]")
	WebElement orderHistoryBtn;
	
	public homePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getCurrentURL() {
		String currentURL= getDriver().getCurrentUrl();
		return currentURL;
	}
	
	public boolean validateMyWishList() {
	
		return Action.isDisplayed(getDriver(), myWishListBtn );
	}
	
	public boolean validateOrderHistory() {
		
		Action.explicitWait(getDriver(), orderHistoryBtn, 10);
		return Action.isDisplayed(getDriver(), orderHistoryBtn );
	}
	
	
}
