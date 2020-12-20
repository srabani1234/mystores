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
public class paymentPage extends BaseClass {
	@FindBy(xpath="//a[@class='bankwire']")
	WebElement payByBankWire;
	
	@FindBy(xpath="//a[@class='cheque']")
	WebElement payByChek;
	
	public paymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public orderSummaryPage clickPayByBankWire() {
		Action.click(getDriver(), payByBankWire);
		return new orderSummaryPage();
	}
	
	public orderSummaryPage clickPayByCheck() {
		Action.click(getDriver(), payByChek);
		return new orderSummaryPage();
	}

}
