package com.magento.core;

import org.openqa.selenium.WebDriver;

public class BaseClass {

	protected static ThreadLocal<WebDriver> threadlocal = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return threadlocal.get();
	}
}
