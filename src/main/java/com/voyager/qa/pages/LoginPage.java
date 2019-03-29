package com.voyager.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.voyager.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// page factory -Object Repository OR
	
	@FindBy(name ="username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath ="//input[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(linkText="Sign Up")
	WebElement SignUpbtn;
	
	@FindBy(xpath ="//img[@class = 'img-responsive' and @src = 'https://d3lh3kd7bj2evy.cloudfront.net/img/logo.png']")
	WebElement CrmLogo;
	
// Initializing the page object
	
	public LoginPage() {
		PageFactory.initElements(driver, this); // this means pointing to currect class object (LoginPage.class)
		
	}
	
	
	// Actions
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() 
	{
		return CrmLogo.isDisplayed();
		
	}
	
	public HomePage login(String un, String pwd ) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(3000);
	    loginbutton.click();
		
		 return new HomePage();
	}
	}
