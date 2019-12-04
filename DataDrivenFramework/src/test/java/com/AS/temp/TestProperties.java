package com.AS.temp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		Properties config= new Properties();
		Properties OR= new Properties();
		FileInputStream configfis = new FileInputStream("C:\\Users\\Dipti\\AutomationStudy\\DataDrivenFramework\\src\\test\\resources\\properties\\Config.properties");
		FileInputStream ORfis = new FileInputStream("C:\\Users\\Dipti\\AutomationStudy\\DataDrivenFramework\\src\\test\\resources\\properties\\OR.properties");
		config.load(configfis);
		OR.load(ORfis);
		System.out.println(config.getProperty("browser"));
		System.out.println(OR.getProperty("btnCutomerLogin"));
		
		

	}

}
