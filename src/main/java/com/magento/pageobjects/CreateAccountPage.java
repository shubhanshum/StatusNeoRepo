package com.magento.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.core.CoreMethods;
import com.magento.core.Utilities;

public class CreateAccountPage {

	WebDriver driver;
	
	public CreateAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="firstname")
	public WebElement firstNameField;
	
	@FindBy(id="lastname")
	public WebElement lastNameField;
	
	@FindBy(id="email_address")
	public WebElement emailField;
	
	@FindBy(id="password")
	public WebElement pwdField;
	
	@FindBy(id="password-confirmation")
	public WebElement cnfPwdeField;
	
	@FindBy(xpath="//button[contains(@class,'submit primary')]")
	public WebElement createAccountBtn;
	
	public void fillRegistrationForm() {
		String firstName=Utilities.getExcelData("registration", 1, 0);
		String lastName=Utilities.getExcelData("registration", 1, 1);
		String email=Utilities.getRandomEmail();
		String pwd=Utilities.getExcelData("registration", 1, 2);
		String cnfPwd=Utilities.getExcelData("registration", 1, 3);
		CoreMethods.setText(firstNameField, firstName);
		CoreMethods.setText(lastNameField, lastName);
		CoreMethods.setText(emailField, email);
		CoreMethods.setText(pwdField, pwd);
		CoreMethods.setText(cnfPwdeField, cnfPwd);
		CoreMethods.click(createAccountBtn, "Create Account Submit Button");
	}
}
