package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

import om.mystore.actiondriver.Action;

public class orderPage extends BaseClass {
	
	@FindBy(xpath="//td[@class='cart_total']/span")
	WebElement unitPrice;
	
	@FindBy(id="total_price")
	WebElement totalPrice;
	
	@FindBy(xpath ="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	public orderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice() {
		String unitPrices= unitPrice.getText();
		String replaceSpecial = unitPrices.replaceAll("[^a-zA-z0-9]", "");
		double finalUnitPrice= Double.parseDouble(replaceSpecial);
		return finalUnitPrice/100;
		
	}
	public double getTotalPrice() {
		String totalPrices= totalPrice.getText();
		String replaceSpecial = totalPrices.replaceAll("[^a-zA-z0-9]", "");
		double finalTotalPrice= Double.parseDouble(replaceSpecial);
		return finalTotalPrice/100;
		
	}
	public loginPage clickOnCheckout() {
		Action.click(getDriver(), proceedToCheckOut);
		return new loginPage();
	}

}
