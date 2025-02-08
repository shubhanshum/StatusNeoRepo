package com.magento.testdata;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface Constant {
	
	String timestamp=new SimpleDateFormat("dd.MM.yyyy.ss").format(new Date());

	String propertiesFilePath="\\src\\main\\java\\com\\magento\\testdata\\config.properties";
	String excelFilePath="\\src\\main\\java\\com\\magento\\testdata\\testdata.xlsx";
	String reportsPath="\\TestReports\\"+"TestReport"+timestamp+".html";
}
