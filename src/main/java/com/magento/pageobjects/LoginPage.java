package com.magento.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.core.CoreMethods;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="email")
	public WebElement emailField;
	
	@FindBy(id="pass")
	public WebElement pwdField;
	
	@FindBy(id="send2")
	public WebElement loginBth;
	
	public void login(String email, String Pwd) {
		CoreMethods.setText(emailField, email); 
		CoreMethods.setText(pwdField, Pwd); 
		CoreMethods.click(loginBth, "Login Button");
	}
}
