package com.magento.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.magento.testdata.Constant;

public class Utilities {

	public static String getPropFileData(String key) {
		FileInputStream file=null;
		Properties prop=null;
		try {
			file=new FileInputStream(System.getProperty("user.dir").concat(Constant.propertiesFilePath));
			prop=new Properties();
			prop.load(file);
		} catch (FileNotFoundException e1) {e1.printStackTrace();} catch (IOException e) {e.printStackTrace();
		}
		return prop.getProperty(key).toString();
	}
	
	public static String getExcelData(String sheetName, int rowNum, int columnNum) {
		FileInputStream file;
		XSSFWorkbook wb = null;
		try {
			file = new FileInputStream(System.getProperty("user.dir").concat(Constant.excelFilePath));
			wb=new XSSFWorkbook(file);
		} catch (IOException e) {e.printStackTrace();
		}
		XSSFSheet ws=wb.getSheet(sheetName);
		String data=ws.getRow(rowNum).getCell(columnNum).getStringCellValue();
		return data;
	}
	
	public static String getRandomEmail() {
		String myCharacters = "abcdefghijklmnop";
        StringBuilder str = new StringBuilder();
        Random rnd = new Random();
        while (str.length() < 18) {
            int index = (int) (rnd.nextFloat() * myCharacters.length());
            str.append(myCharacters.charAt(index));
        }
        String email = str.toString().concat("@gmail.com");
        return email;
	}
}
