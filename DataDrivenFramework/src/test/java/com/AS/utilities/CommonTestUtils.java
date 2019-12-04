package com.AS.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.AS.baseclass.BaseClass;

public class CommonTestUtils extends BaseClass{
	//Common Screenshot Method
	public static String screenshotpath;
	public static String screenshotname;
	
	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotname = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\screenshots\\html\\" + screenshotname));

	}
	
	
	//Common Data Provider 	
	@DataProvider(name="dp")
	public static Object[][] getData(Method m) throws Exception{
		
		String Sheet=m.getName();
		
        Object[][] testObjArray = ExcelReader.getTableArray("C:\\Users\\Dipti\\AutomationStudy\\DataDrivenFramework\\AddCustomer.xlsx",Sheet);
		 
        return (testObjArray);
        
        
		
	}

}
