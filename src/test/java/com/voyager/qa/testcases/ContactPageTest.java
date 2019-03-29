package com.voyager.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.voyager.qa.base.TestBase;
import com.voyager.qa.pages.ContactsPage;
import com.voyager.qa.pages.HomePage;
import com.voyager.qa.pages.LoginPage;
import com.voyager.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	

	public ContactPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		intialization(); // call initialization method
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginpage = new LoginPage();// create object of an homepage class
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); //login method return the homepage
		//testUtil = new TestUtil();
		//contactsPage = homePage.clickOnContactsLinks();
		 

	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data [][]= TestUtil.getTestData(sheetName);
		return data;
	}
		
     @Test(priority=1 , dataProvider ="getCRMTestData")
     public void validateCreateNewContactTest(String title,String firstname, String lastname,String company,String position) throws InterruptedException {
    	 
    	 testUtil.switchtoFrame();
    	 homePage.ClickOnNewContactlink();
         //contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
    	 Thread.sleep(3000);
         contactsPage.createNewContact(title, firstname, lastname, company, position);
         homePage.clickOnContactsLinks();
         Assert.assertTrue(contactsPage.VerifyCorrectContactslist());
    	
     }
 
	@Test(priority =2)
	public void validateContactlistTest() {
		 testUtil.switchtoFrame();
		 homePage.clickOnContactsLinks();
         Assert.assertTrue(contactsPage.VerifyCorrectContactslist());
	}
}


