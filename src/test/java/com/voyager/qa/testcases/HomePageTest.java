package com.voyager.qa.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.voyager.qa.base.TestBase;
import com.voyager.qa.pages.ContactsPage;
import com.voyager.qa.pages.HomePage;
import com.voyager.qa.pages.LoginPage;
import com.voyager.qa.pages.SetUpPage;
import com.voyager.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	SetUpPage SetUplinkss;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		intialization(); // call initialization method
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginpage = new LoginPage();// create object of an homepage class
		SetUplinkss = new SetUpPage();
		
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); //login method return the homepage
		}
		

	@Test(priority =1)
	public void verifyHomePageTitleTest() {
		
		String homePageTitle = homePage.verifyHomePageTitle();
	    Assert.assertEquals(homePageTitle, "CRMPRO", "Home page title is mismatch");
	
	}
	@Test(priority =2)
	public void verifyUsernameTest() {
		testUtil.switchtoFrame();
		Assert.assertTrue(homePage.VerifyCorrectUsername());
	}
	
	@Test(priority =3)
	public void verifyContactsLinkTest() {
		
		testUtil.switchtoFrame();
	    contactsPage = homePage.clickOnContactsLinks();
	}

	/*@Test(priority =1)
	public void verifyWebDroplist() {
		
		testUtil.switchtoFrame();
		boolean dropdown= homePage.selectWebfromDropDownlist();
		Assert.assertEquals(dropdown, true, "Selection drop down value is not match");
	}*/

/*	
	@Test(priority =2)
	public void VerifySetupLinkTest() throws InterruptedException  {
	testUtil.switchtoFrame();
	homePage.setUpLinks();
		
	}
	*/
	

	
	
	@AfterMethod
    public void TearDown() {
		
		driver.quit();

		}
		
}
