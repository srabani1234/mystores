package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

import om.mystore.actiondriver.Action;

public class orderSummaryPage extends BaseClass{
	
	@FindBy(xpath="//button/span[text()='I confirm my order']")
	WebElement iConfirmMyOrderBtn;
	
	public orderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public orderConfirmPage clickonOrderConfirm() {
		Action.click(getDriver(), iConfirmMyOrderBtn);
		return new orderConfirmPage();
	}

}
