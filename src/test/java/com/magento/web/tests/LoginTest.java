package com.magento.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magento.core.RetryAnalyzer;
import com.magento.core.Utilities;
import com.magento.pageobjects.HomePage;
import com.magento.pageobjects.LandingPage;
import com.magento.pageobjects.LoginPage;
import com.magento.utilities.Reporter;

public class LoginTest extends BaseTest{

	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void loginTest() {
		Reporter.setTestName(this.getClass().getSimpleName());
		landingPage=new LandingPage(getDriver());
		loginPage =new LoginPage(getDriver());
		homePage=new HomePage(getDriver());
		String email=Utilities.getExcelData("credentials", 1, 0);
		String password=Utilities.getExcelData("credentials", 1, 1);
		landingPage.clickOnSignInLink();
		loginPage.login(email, password);
		Assert.assertTrue(homePage.isWelcomeTextDisplayed(), "Welcome text is not displayed");
	}
}
