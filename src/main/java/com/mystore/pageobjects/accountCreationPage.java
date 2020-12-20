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
public class accountCreationPage extends BaseClass{
	
	@FindBy(xpath="//h1[contains(text(),'Create an account')]")
	WebElement accountPageTitle;
	
public accountCreationPage() {
	PageFactory.initElements(getDriver(), this);
}

public boolean verifyAccountCreatePageName() throws Throwable {
	return Action.isDisplayed(getDriver(), accountPageTitle );
}
}
