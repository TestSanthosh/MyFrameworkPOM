package com.companyNameAbc.projectNameCrm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.companyNameAbc.projectNameCrm.qa.base.TestBase;
import com.companyNameAbc.projectNameCrm.qa.pages.ContactsPage;
import com.companyNameAbc.projectNameCrm.qa.pages.HomePage;
import com.companyNameAbc.projectNameCrm.qa.pages.LoginPage;
import com.companyNameAbc.projectNameCrm.qa.util.TestUtil;

public class Testt  extends TestBase {

		LoginPage loginPage;
		HomePage homePage;
		TestUtil testUtil;
		ContactsPage contactsPage;

		String sheetName = "contacts";

		public Testt() {
			super();

		}

		@BeforeMethod
		public void setUp() throws InterruptedException {

			initialization();
			testUtil = new TestUtil();
			contactsPage = new ContactsPage();
			loginPage = new LoginPage();
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			driver.switchTo().frame("mainpanel");

			driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		}

		@Test
		public void validateCreateNewContact(){
			//homePage.clickOnNewContactLink();
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
			//snewContactLink.click();
			//driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
			//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
					
		}

		@AfterMethod
		public void tearDown() {
			//driver.quit();
		}

}
