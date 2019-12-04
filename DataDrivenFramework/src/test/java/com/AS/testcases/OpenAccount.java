package com.AS.testcases;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.AS.baseclass.BaseClass;
import com.AS.utilities.CommonTestUtils;

public class OpenAccount extends BaseClass {
	static WebElement custdropdown;
	static WebElement currdropdown;

	
	@Test
	public void openAccount() throws InterruptedException
	{   driver.findElement(By.cssSelector(OR.getProperty("openaccount_CSS"))).click();
		custdropdown=driver.findElement(By.cssSelector(OR.getProperty("customer_CSS")));
		currdropdown=driver.findElement(By.cssSelector(OR.getProperty("customer_CSS")));
		Select select1=new Select(custdropdown);
		Select select2=new Select(currdropdown);
	    select1.selectByIndex(0);
	    select2.selectByIndex(0);
	    driver.findElement(By.cssSelector(OR.getProperty("process_CSS"))).click();
		Thread.sleep(2000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
   
		
	}

}
