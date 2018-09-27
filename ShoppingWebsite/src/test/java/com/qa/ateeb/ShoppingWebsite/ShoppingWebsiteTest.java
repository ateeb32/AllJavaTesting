package com.qa.ateeb.ShoppingWebsite;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class ShoppingWebsiteTest {
	
	WebDriver driver = null;
	
	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Testing/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void test() throws InterruptedException {
		
		driver.get("http://automationpractice.com/index.php");
		ShoppingHomePage homePage = PageFactory.initElements(driver, ShoppingHomePage.class);
//		ResultsPage resultPage = PageFactory.initElements(driver, ResultsPage.class);
		
		homePage.dropdownMenu(driver);
		Thread.sleep(2000);
		assertEquals("Navigated to incorrect page", "T-shirts - My Store", driver.getTitle());
		
		homePage.clickHome();
		Thread.sleep(2000);
		assertEquals("Navigated to incorrect page", "My Store", driver.getTitle());
		
//		homePage.writeSeachBar();
//		homePage.clickSearch();
//		
//		resultPage.checkForDress();
//		resultPage.checkForDressString();
//		
//		assertTrue("Dress Not Found! (assertTrue)", resultPage.checkForDress());
//		assertEquals("Dress Not Found! (assertEquals)", "Printed Chiffon Dress", resultPage.checkForDressString());
		
	}
	@Test
	public void test2() throws InterruptedException {
		
		driver.get("http://automationpractice.com/index.php");
		ShoppingHomePage homePage = PageFactory.initElements(driver, ShoppingHomePage.class);
		ResultsPage resultPage = PageFactory.initElements(driver, ResultsPage.class);
		
		homePage.writeSeachBar();
		homePage.clickSearch();
		
		resultPage.checkForDress();
		resultPage.checkForDressString();
		
		assertTrue("Dress Not Found! (assertTrue)", resultPage.checkForDress());
		assertEquals("Dress Not Found! (assertEquals)", "Printed Chiffon Dress", resultPage.checkForDressString());
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
