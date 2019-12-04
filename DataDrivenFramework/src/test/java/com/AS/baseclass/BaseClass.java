package com.AS.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.AS.utilities.ExcelReader;



public class BaseClass {
	
	public static WebDriver driver;
	public static Properties config= new Properties();
	public static Properties OR= new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoylogger");
    public static Alert alert;
    public static WebDriverWait wait;
	
	@BeforeSuite
	public void setUp()
	{
		if(driver==null) {
			try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.info("Config File Loaded");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(config.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\MyAutomation\\ChromeDriver\\chromedriver.exe");
            	driver = new ChromeDriver();
            	log.info("Chrome Launched");
            	            
            }else if(config.getProperty("browser").equalsIgnoreCase("Firefox")) 
	        {	          
	        	  System.setProperty("webdriver.gecko.driver", "C:\\MyAutomation\\Firefox\\geckodriver-v0.24.0-win64\\geckodriver.exe");
	  			  driver = new FirefoxDriver();
	  			  log.info("Config File Loaded");
	          	
	         }
			else        	
            { 
        	System.out.println("Some other browser"); 	
            }
			
			/*          else if(browser.equalsIgnoreCase("Firefox")) 
          {	          
        	  System.setProperty("webdriver.gecko.driver", "C:\\MyAutomation\\Firefox\\geckodriver-v0.24.0-win64\\geckodriver.exe");
  			  driver = new FirefoxDriver();
          	
          }*/
           driver.get(config.getProperty("testurl"));  
           log.debug("TestSite URL Loaded");
           driver.manage().deleteAllCookies();
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
			
		}
		
		
	}
	
	@AfterSuite
	public void tearDown()
	{
		if(driver!=null)
		{
		driver.quit();
		}
	}
	
	public boolean isElementPresent(By by)
	{
		try
		   {
			driver.findElement(by);
		
			return true;
	
		}
		catch(NoSuchElementException e) 
		{
			return false;
		}
		 
	}
	

	
	}


