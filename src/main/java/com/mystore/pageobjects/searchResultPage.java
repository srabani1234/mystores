/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

import om.mystore.actiondriver.Action;

/**
 * @author Admin
 *
 */
public class searchResultPage extends BaseClass {
	
	@FindBy(xpath="//img[@alt='Faded Short Sleeve T-shirts']")
	WebElement searchProduct;
	
	public searchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public boolean productAvailbility() {
		return Action.isDisplayed(getDriver(), searchProduct);
	}
	public addToCart clickOnSearchProduct() {
		
		Action.click(getDriver(), searchProduct);
		
		return new addToCart();
	}

}
