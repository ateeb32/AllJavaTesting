package com.qa.ateeb.TheDemoSitePOM;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class TestDemoSite {
	
	WebDriver driver = null;
	
	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Testing/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void testDemoSite() throws InterruptedException {
		
		driver.get("https://www.thedemosite.co.uk");
		DemoSiteLandingPage landingPage = PageFactory.initElements(driver, DemoSiteLandingPage.class); // Call all elements from DemoSiteLandingPage class
		TeaTestingHome addUserPage = PageFactory.initElements(driver, TeaTestingHome.class);
		DemoSiteLoginUser loginUserPage = PageFactory.initElements(driver, DemoSiteLoginUser.class);
		
		landingPage.hypAddUser();
		
		addUserPage.writeUserFieldAddUser();
		addUserPage.writePassFieldAddUser();
		addUserPage.clickSaveAddUser();
		addUserPage.clickLoginPage();
		
		loginUserPage.writeUserFieldLogin();
		loginUserPage.writePassFieldLogin();
		loginUserPage.clickTestLogin();
		
		assertTrue("Login Unsuccessful! (assertTrue)", loginUserPage.checkSuccessfulLogin());
		assertEquals("Login Unsuccessful! (assertEquals)", "**Successful Login**", loginUserPage.checkSuccessfulLoginString());
		
		//Thread.sleep(1000);
		//WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));
		//assertEquals("Selenium", searchPage.heading.getText());

	}
	
	@After
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.close();
		
	}
}
