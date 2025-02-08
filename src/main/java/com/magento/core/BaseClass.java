package com.magento.core;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	protected static ThreadLocal<WebDriver> threadlocal = new ThreadLocal<>();
	protected static ExtentSparkReporter sparkReporter;
	protected static ExtentReports extent;
	protected static ExtentTest test;

	public static WebDriver getDriver() {
		return threadlocal.get();
	}
}
