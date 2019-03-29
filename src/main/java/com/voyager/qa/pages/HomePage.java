package com.voyager.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.voyager.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath ="//td[contains(text(),'User: SURAJ Umbarkar')]")
	WebElement usernamelabel;
	
	@FindBy(xpath ="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath ="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath ="//a[contains(text(),'Tasks')]")
	WebElement tasklink;
	
	@FindBy(name ="search_target")
	WebElement crmSearch;
	
	@FindBy(xpath = "//a [contains(text(),'Setup')]")
	WebElement setUpLink;
	
	@FindBy(xpath ="//a[contains(text(),'New Contact')]")
	WebElement NewContactlink;
	
	
	// Initializing the page object
	public HomePage() {
		PageFactory.initElements(driver, this); // this means pointing to current class object (LoginPage.class)
		
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean VerifyCorrectUsername() {
		return usernamelabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLinks()
	{
		contactslink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLinks()
	{
		dealslink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLinks()
	{
		tasklink.click();
		return new TasksPage();
	}
	
	public boolean selectWebfromDropDownlist() {
		Select crmSearch = new Select(driver.findElement(By.name("search_target")));
		crmSearch.selectByIndex(1);
		 //return new HomePage();
		  return true;
	}
	
	public SetUpPage setUpLinks() throws InterruptedException {
		
		Thread.sleep(5000);
		setUpLink.click();
		return new SetUpPage();
	}
	
	public void ClickOnNewContactlink() throws InterruptedException {
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(contactslink).build().perform();
		NewContactlink.click();
	
		
	}
	
}

