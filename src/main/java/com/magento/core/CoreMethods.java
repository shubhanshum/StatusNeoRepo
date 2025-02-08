package com.magento.core;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.magento.utilities.Log;
import com.magento.utilities.Reporter;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CoreMethods extends BaseClass{

	public static void click(WebElement ele, String name) {
		try {
			Log.info("Clicking on "+name);
			waitTillElementIsClickable(ele);
			ele.click();
			Log.info("Clicked on "+name);
			Reporter.setMethodMessage("Clicked on "+name);
		}catch (Exception e) {
			Log.error("Couldn't click on "+name +"Error:"+e);
			Reporter.setMethodMessage("Couldn't click on "+name +"Error:"+e);
		}
	}
	
	public static void setText(WebElement ele, String text) {
		try {
			Log.info("Entering "+text);
			waitTillElementIsVisible(ele);
			ele.clear();
			ele.sendKeys(text);
			Log.info("Text Entered is: "+text);
			Reporter.setMethodMessage("Text Entered is: "+text);
		}catch (Exception e) {
			Log.error("Couldn't entered text: "+text +"Error:"+e);
			Reporter.setMethodMessage("Couldn't entered text: "+text +"Error:"+e);
		}
	}
	
	public static void waitTillElementIsClickable(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(getDriver(), 
				Duration.ofSeconds(Integer.valueOf(Utilities.getPropFileData("Timeout"))));
				wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void waitTillElementIsVisible(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(getDriver(), 
				Duration.ofSeconds(Integer.valueOf(Utilities.getPropFileData("Timeout"))));
				wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static Response hitGETRequest(String uri, String basePath, String fragement) {
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri(uri);
		builder.setBasePath(basePath);
		RequestSpecification request=builder.build();
		Log.info("Request is:"+request.log().uri());
		Reporter.setMethodMessage("Request is:"+request.log().uri());
		Response response=RestAssured.given(request).contentType(ContentType.JSON).get(fragement);
		Log.info(response.asPrettyString());
		Reporter.setMethodMessage("Response is:"+response.asPrettyString());
		return response;
	}
	
	public static String getDataFromResponse(Response response, String data) {
		Log.info("Getting data:"+data);
		Reporter.setMethodMessage("Getting data:"+data);
		return response.jsonPath().getString(data);
	}
}
