package com.voyager.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.voyager.qa.base.TestBase;


public class ContactsPage extends TestBase {
	
	
	@FindBy(id ="first_name")
	WebElement firstname;
	
	@FindBy(id ="surname")
	WebElement surname;
	
	@FindBy(name ="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type = 'submit' and @value = 'Save']")
	WebElement savBtn;
	
	@FindBy(name ="company_position")
	WebElement position;
	
	@FindBy(xpath = "//a [contains(text(),'Kenny Kent')]")
	WebElement usercontact;

	// Initializing the page object
		public ContactsPage() {
			PageFactory.initElements(driver, this); // this means pointing to current class object (LoginPage.class)
			
		}

 
   public void createNewContact(String titles,String ftname, String ltname ,String cmp, String pos) {
	   
	   Select select = new Select(driver.findElement(By.name("title")));
	   select.selectByVisibleText(titles);
	   
	   firstname.sendKeys(ftname);
	   surname.sendKeys(ltname);
	   company.sendKeys(cmp);
	   position.sendKeys(pos);
	   savBtn.click();
   }
   
   public boolean VerifyCorrectContactslist() {
		return usercontact.isDisplayed();
	}
}