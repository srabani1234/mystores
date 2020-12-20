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
public class orderConfirmPage extends BaseClass{

	@FindBy(xpath="//p[text()='Your order on My Store is complete.']")
	WebElement OrderConfirmMsg;
	
	public orderConfirmPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String verifyOrderConfirn() {
		Action.isDisplayed(getDriver(), OrderConfirmMsg);
		String confirmMsg = OrderConfirmMsg.getText();
		return confirmMsg;
	}
	
}
