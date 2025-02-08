package com.magento.api.tests;

import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.magento.core.BaseClass;
import com.magento.utilities.Reporter;

public class BaseApiTest extends BaseClass{

	@BeforeClass
	public void launchBrowserAndNavigateToUrl() {
		BaseClass.extent=Reporter.getInstance();
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterMethod
	public void verifyResult(ITestResult result) {
		Reporter.getResult(result);
	}
	
	@AfterClass
	public void quitSession() {
		threadlocal.remove();
		Reporter.flush();
	}
}
