package com.voyager.qa.testcases;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {

 WebDriver driver;

public static void Setup()
  {

	 WebDriverManager.firefoxdriver().setup();
}

@Test

public void f() 

{

   driver.get("https://www.google.com/");
   System.out.println(driver.getTitle());
}

}