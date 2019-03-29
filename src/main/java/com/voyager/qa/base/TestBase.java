package com.voyager.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.voyager.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	// inside constructor
	public TestBase(){
		
		// E:\\WorkSpaceAutomations\\VOYAGERCRM\\src\\main\\java\\com\\voyager\\qa\\testdata\\FreeCrmTestData.xlsx
		//E:\\Java Practice\\eclipse-workspace\\VoyagerTest\\src\\main\\java\\com\\voyager\\qa\\configuration\\config.properties
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("E:\\WorkSpaceAutomations\\VOYAGERCRM\\src\\main\\java\\com\\voyager\\qa\\configuration\\config.properties");
			prop.load(ip);
		}catch (FileNotFoundException e) {
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}


   public static void intialization() {
	   
	 String browserName= prop.getProperty("browser");
	 
	 if(browserName.equals("FireFox")){
		 System.setProperty("webdriver.gecko.driver","C:\\Users\\suraj.umbarkar\\Desktop\\CORE JAVA\\geckodriver.exe");
		 driver = new  FirefoxDriver();
	 }
	 
	 else if(browserName.equals("chrome"))
	 {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\suraj.umbarkar\\Desktop\\CORE JAVA\\chromedriver.exe");
		 driver = new  ChromeDriver();
	   
     }
	 
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	 
	 driver.get(prop.getProperty("url"));
}
}   
