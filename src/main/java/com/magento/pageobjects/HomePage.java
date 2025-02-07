package com.magento.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[contains(text(),'Welcome')]")
	public WebElement welcomeTxt;
	
	public boolean isWelcomeTextDisplayed() {
		return welcomeTxt.isDisplayed();
	}
}
