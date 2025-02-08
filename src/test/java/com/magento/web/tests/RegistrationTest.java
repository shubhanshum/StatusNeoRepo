package com.magento.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magento.core.RetryAnalyzer;
import com.magento.pageobjects.CreateAccountPage;
import com.magento.pageobjects.HomePage;
import com.magento.pageobjects.LandingPage;
import com.magento.utilities.Reporter;

public class RegistrationTest extends BaseTest{

	LandingPage landingPage;
	CreateAccountPage createAccountPage;
	HomePage homePage;
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void registrationTest() {
		Reporter.setTestName(this.getClass().getSimpleName());
		landingPage=new LandingPage(getDriver());
		createAccountPage=new CreateAccountPage(getDriver());
		homePage=new HomePage(getDriver());
		landingPage.clickCreateAccount();
		createAccountPage.fillRegistrationForm();
		Assert.assertTrue(homePage.isWelcomeTextDisplayed(), "Welcome text is not displayed");
	}
}
