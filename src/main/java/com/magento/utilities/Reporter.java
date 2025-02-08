package com.magento.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.magento.core.BaseClass;
import com.magento.core.Utilities;
import com.magento.testdata.Constant;

public class Reporter extends BaseClass{
	
	static String timestamp=new SimpleDateFormat("dd.MM.yyyy.ss").format(new Date());
	
	public static void setReport() {
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir").concat(Constant.reportsPath));
		sparkReporter.config().setDocumentTitle("Magento Automation Report");
		sparkReporter.config().setReportName("Automation Tests");
		sparkReporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser", Utilities.getPropFileData("Browser"));
	}
	
	public static void getResult(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"Test case failed due to below issue",ExtentColor.RED));
			test.fail(result.getThrowable());
			File srcFile=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
			File destFile=new File (System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+timestamp+".png");
			String filePath=destFile.getAbsolutePath();
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {e.printStackTrace();}
			test.addScreenCaptureFromPath(filePath);
		}
		else if (result.getStatus()==ITestResult.SUCCESS){
			test.log(Status.PASS,MarkupHelper.createLabel(result.getName()+"Test case passed",ExtentColor.GREEN));
		}
		else{
			test.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"Test case skipped",ExtentColor.YELLOW));
			test.skip(result.getThrowable());
		}
	}
	
	public static void flush() {
		extent.flush();
	}
	
	public static void setTestName(String name) {
		test=extent.createTest(name);
	}
	
	public static void setMethodMessage(String Message) {
		test.log(Status.INFO,Message);
	}
	
	public static ExtentReports getInstance() {
        if(extent == null) {
            setReport();
        }   
        return extent;
    }
	
	
}
