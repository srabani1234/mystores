package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

import om.mystore.actiondriver.Action;

public class addToCart extends BaseClass {
	@FindBy(id="quantity_wanted")
	WebElement productQuantity;
	
	@FindBy(id="group_1")
	WebElement Size;
	
	@FindBy(xpath="//button[@name='Submit']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	WebElement verifyAddToCartMessage;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckBtn;
	
	public addToCart() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String quantity) {
		Action.type(productQuantity, quantity);
	}
	
	public void enterSize(String size) {
		Action.selectByVisibleText(size, Size);
		
	}
	public void clickAddToCart() {
		Action.click(getDriver(), addToCartBtn);
		
	}
	
	public boolean validateProductAddToCart() {
		Action.explicitWait(getDriver(), verifyAddToCartMessage, 10);
		return Action.isDisplayed(getDriver(), verifyAddToCartMessage);
		
	}
	public orderPage clickProceedToCheckBtn() throws Throwable  {
		Action.explicitWait(getDriver(),  proceedToCheckBtn, 10);
		Action.JSClick(getDriver(), proceedToCheckBtn);
		return new orderPage();
	}

}
