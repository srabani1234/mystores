package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

import om.mystore.actiondriver.Action;

public class shippingPage extends BaseClass {
	
	@FindBy(id="cgv")
	WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckBtn;
	
	public shippingPage() {
		PageFactory.initElements(getDriver(), proceedToCheckBtn);
	}
	
	public void clickOnTerms() {
		Action.click(getDriver(), terms);
	}
	
	public paymentPage clickOnProccedBtn() {
		Action.click(getDriver(), proceedToCheckBtn );
		return new paymentPage();
	}

}
