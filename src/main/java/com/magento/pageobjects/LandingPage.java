package com.magento.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.core.CoreMethods;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(@href,'login')]")
	public WebElement signInLink;
	
	@FindBy(linkText ="Create an Account")
	public WebElement createAccountLink;
	
	public void clickOnSignInLink() {
		CoreMethods.click(signInLink, "SignIn Link");
	}
	
	public void clickCreateAccount() {
		CoreMethods.click(createAccountLink, "Create Account Link");
	}
}
