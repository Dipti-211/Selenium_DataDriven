package com.AS.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.AS.baseclass.BaseClass;

public class BankManagerLogin extends BaseClass{
	
	
	@Test
	public void Login() throws InterruptedException
	{ 
		//Click Bank Manager Login Button
		System.setProperty("org.uncommons.reportng.escape-output","false");
		driver.findElement(By.xpath(OR.getProperty("btnBankMgrLogin"))).click();
		
		log.info("Bank Manager Login Button Clicked");
		
		//Verify Add Customer button is present
		
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("btnAddCust1"))), "Login not Sucessful");
		Reporter.log("Bank Manager Login Successfully");
		
		
		//Assert.fail("Fail");
		
		//Thread.sleep(3000);
		
		
		
	}

}
