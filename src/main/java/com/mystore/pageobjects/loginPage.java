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
public class loginPage extends BaseClass{
	@FindBy(name="email")
	WebElement emailAddress;
	
	@FindBy(id="passwd")
	WebElement passWord;
	
	@FindBy(id ="SubmitLogin")
	WebElement logInBtn;
	
	@FindBy(name="email_create")
	WebElement emailForNewAccount;
	
	@FindBy(id="SubmitCreate")
	WebElement createAccountButton;
	
	public loginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public homePage login(String userName, String passWords, homePage homePage) {
		Action.type(emailAddress, userName);
		Action.type(passWord,passWords );
		Action.click(getDriver(), logInBtn);
		homePage = new homePage();
		return new homePage();
		
	}
	public addressPage login1(String userName, String passWords) {
		Action.type(emailAddress, userName);
		Action.type(passWord,passWords );
		Action.click(getDriver(), logInBtn);
		return new addressPage();
		
	}
	
	public accountCreationPage createNewAccount(String newEmail) {
		Action.type(emailForNewAccount, newEmail);
		Action.click(getDriver(), createAccountButton);
		
		return new accountCreationPage();
	}

}
