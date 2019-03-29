package com.voyager.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.voyager.qa.base.TestBase;

public class SetUpPage extends TestBase {
	
	
	@FindBy(xpath ="//td[contains(text(),'Global Account Administration')]")
	WebElement setupgobalsectionname;
	
	@FindBy(xpath = "//td[contains(text(),'Billing')]")
	WebElement BillingText;
	
	@FindBy(xpath ="//a[contains(text(),'Profile Settings')]")
	WebElement ProfileSettingLink;
	
	// Initializing the page object
	public SetUpPage() {
		
		PageFactory.initElements(driver, this); // this means pointing to current class object (SetUp.class)
		
	}
	
	public boolean verifycorrectglobalname() 
	{
		
	 return setupgobalsectionname.isDisplayed();
	}

	
	public boolean verifyBillingText() {
		
		return BillingText.isDisplayed();
	}
	
	public ProfileSettingPage verifyProfileSettingLink() {
		
	  ProfileSettingLink.click();
	  return new ProfileSettingPage();
	}
	
}
