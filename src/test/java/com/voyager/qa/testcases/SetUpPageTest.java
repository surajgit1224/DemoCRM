package com.voyager.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.voyager.qa.base.TestBase;
import com.voyager.qa.pages.ContactsPage;
import com.voyager.qa.pages.HomePage;
import com.voyager.qa.pages.LoginPage;
import com.voyager.qa.pages.ProfileSettingPage;
import com.voyager.qa.pages.SetUpPage;
import com.voyager.qa.util.TestUtil;

public class SetUpPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	SetUpPage SetUplinkss;
	ProfileSettingPage profileSettingPage ;
	
	public SetUpPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		
		intialization(); // call initialization method
	   	testUtil = new TestUtil();
		//contactsPage = new ContactsPage();
		loginpage = new LoginPage();// create object of an homepage class
		//homePage  = new HomePage();
		SetUplinkss = new SetUpPage();
	    homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); //login method return the homepage
	    homePage  = new HomePage();
	    profileSettingPage = new ProfileSettingPage();
		}
		
	@Test(priority =1)
	public void setUpGlobaltextTest() throws InterruptedException {

		testUtil.switchtoFrame();
		homePage.setUpLinks();
        Assert.assertTrue(SetUplinkss.verifycorrectglobalname());
		
	}
	
	
 @Test(priority =2)
  public void billingtextest() throws InterruptedException {

	testUtil.switchtoFrame();
	homePage.setUpLinks();
	Assert.assertTrue(SetUplinkss.verifyBillingText());
    
}
 @Test(priority =1)
	public void  profilesettingTest() throws InterruptedException {

		testUtil.switchtoFrame();
		homePage.setUpLinks();
        profileSettingPage= SetUplinkss.verifyProfileSettingLink();
		
		
 }
	
	    @AfterMethod
        public void TearDown() {
		driver.quit();

		}
		
}
