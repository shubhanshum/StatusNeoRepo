package com.magento.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magento.core.CoreMethods;
import com.magento.core.RetryAnalyzer;
import com.magento.utilities.Reporter;

import io.restassured.response.Response;

public class GetCovidDataTest extends BaseApiTest{

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void getCovidSummaryTest() {
		Reporter.setTestName(this.getClass().getSimpleName());
		Response response=CoreMethods.hitGETRequest("https://api.rootnet.in/", "covid19-in", "stats/latest");
		Assert.assertEquals(response.getStatusCode(), 200);
		String stateName=CoreMethods.getDataFromResponse(response, "data.regional[3].loc");
		Assert.assertEquals(stateName, "Assam");
	}
}
