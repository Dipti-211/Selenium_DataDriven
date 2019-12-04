package com.AS.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AS.baseclass.BaseClass;
import com.AS.utilities.CommonTestUtils;
import com.AS.utilities.ExcelReader;

import junit.framework.Assert;

public class AddCustomer extends BaseClass{
	
	
	@Test(dataProviderClass=CommonTestUtils.class,dataProvider="dp")
	public void addNewCustomer(String firstname, String lastname, String postcode)
	{   
		
		try
		{System.setProperty("org.uncommons.reportng.escape-output","false");
		driver.findElement(By.cssSelector(OR.getProperty("btnAddCust1"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("txtFirstName"))).sendKeys(firstname);
		driver.findElement(By.cssSelector(OR.getProperty("txtLastName"))).sendKeys(lastname);
		driver.findElement(By.cssSelector(OR.getProperty("txtPostCode"))).sendKeys(postcode);
		driver.findElement(By.cssSelector(OR.getProperty("btnAddCust2"))).click();
		Reporter.log("Add Customer button clicked");
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    String alertText=driver.switchTo().alert().getText();
	    System.out.println(alertText);
	    driver.switchTo().alert().accept();
	    Assert.assertEquals(true, alertText.contains("customer"));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	

}
