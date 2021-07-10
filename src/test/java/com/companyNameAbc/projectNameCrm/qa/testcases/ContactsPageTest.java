package com.companyNameAbc.projectNameCrm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.companyNameAbc.projectNameCrm.qa.base.TestBase;
import com.companyNameAbc.projectNameCrm.qa.pages.ContactsPage;
import com.companyNameAbc.projectNameCrm.qa.pages.HomePage;
import com.companyNameAbc.projectNameCrm.qa.pages.LoginPage;
import com.companyNameAbc.projectNameCrm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";

	public ContactsPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		// contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");

	}

	@Test(priority = 2)
	public void selectSingleContactsTest() {
		homePage.clickOnContactsLink();
		contactsPage.selectContactsByName("test testing");

	}

	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		homePage.clickOnContactsLink();
		contactsPage.selectContactsByName("test testing");
		contactsPage.selectContactsByName("testqa sant");

	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	/*
	 * @Test(priority = 4) public void validateCreateNewContact(){
	 * homePage.clickOnNewbContactLink(); contactsPage.createNewContact("Mr.",
	 * "Tom", "Peter", "Google"); //contactsPage.createNewContact(title, firstName,
	 * lastName, company);
	 * 
	 * }
	 */

	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) {
		homePage.clickOnNewbContactLink();
		// contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);

	}

	@AfterMethod
	public void tearDown() {
		try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
