package com.magento.web.tests;
import java.time.Duration;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.magento.core.BaseClass;
import com.magento.core.Utilities;
import com.magento.utilities.Reporter;

public class BaseTest extends BaseClass{

	@BeforeClass
	public void launchBrowserAndNavigateToUrl() {
		BaseClass.extent=Reporter.getInstance();
		PropertyConfigurator.configure("log4j.properties");
		String browserName=Utilities.getPropFileData("Browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--ignore-ssl-errors=yes");
			options.addArguments("--ignore-certificate-errors");
			//options.addArguments("--headless");
			threadlocal.set(new ChromeDriver(options));
		}
		else if (browserName.equalsIgnoreCase("Firefox")){
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--ignore-ssl-errors=yes");
			options.addArguments("--ignore-certificate-errors");
			threadlocal.set(new FirefoxDriver(options));
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			EdgeOptions options =new EdgeOptions();
			options.addArguments("--ignore-ssl-errors=yes");
			options.addArguments("--ignore-certificate-errors");
			threadlocal.set(new EdgeDriver(options));
		}
		getDriver().manage().window().maximize();
		getDriver().get(Utilities.getPropFileData("URL"));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
	}
	
	@AfterMethod
	public void verifyResult(ITestResult result) {
		Reporter.getResult(result);
	}
	
	
	@AfterClass
	public void quitSession() {
		getDriver().quit();
		threadlocal.remove();
		Reporter.flush();
	}
}
