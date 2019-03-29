package com.voyager.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.voyager.qa.base.TestBase;
import com.voyager.qa.pages.HomePage;
import com.voyager.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp() {
		
		intialization(); // call initialization method
		loginpage = new LoginPage(); // create object of an loginpage class
		}
		
	@Test(priority =1)
	public void LoginPageTitleTest() {
	
		String title = loginpage.ValidateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - 1CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority =2)
	public void crmLogoImageTest()
	{
		Boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	

	@Test
	public void loginTest() throws InterruptedException
	{

		   Thread.sleep(8000);
		   homePage =loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
    public void TearDown() {
		
		driver.quit();

		}
		
}
