package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

import om.mystore.actiondriver.Action;

public class addressPage extends BaseClass {
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToChekout;
	
	
	public addressPage() {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public shippingPage clickOnProccedBtn() {
		Action.click(getDriver(), proceedToChekout );
		return new shippingPage();
	}

}
