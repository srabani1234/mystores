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
public class indexPage extends BaseClass {
	@FindBy (xpath= "//a[@class='login']")
	WebElement signInBtn;
	@FindBy(xpath ="//img[@class='logo img-responsive']")
	WebElement pageLogo;
	
	@FindBy(name="search_query")
	WebElement searchTextBox;
	
	@FindBy(name="submit_search")
	WebElement searchBtn;
	
	public indexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public loginPage clicSignInBtn() {
		Action.explicitWait(getDriver(), signInBtn, 10);
		Action.click(getDriver(), signInBtn);
		return new loginPage();
	}
	
	public boolean pageLogo() {
		return Action.isDisplayed(getDriver(), pageLogo);
			
	}
	
	public String getMyStoreTitle() {
		String pageTitle = getDriver().getTitle();
		return pageTitle;
	}
	
	public searchResultPage searchProduct(String searchProduct) {
		Action.type(searchTextBox, searchProduct);
		Action.click(getDriver(), searchBtn);
		return new searchResultPage();
	}

}
