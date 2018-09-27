package com.qa.ateeb.TheDemoSiteReportingPOM;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestDemoSite {
	
	WebDriver driver = null;
	
	public static ExtentReports report; //REPORTING
	public ExtentTest test; //REPORTING
	
	@BeforeClass
	public static void initial() {
		
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\My Eclipse Workspace\\TheDemoSiteReportingPOM\\Reports\\Report.html", true); //REPORTING
		
	}
	
	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Testing/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void testDemoSite() throws InterruptedException {
		
		test = report.startTest("This is a login test"); //REPORTING
		
		driver.get("https://www.thedemosite.co.uk");
		
		test.log(LogStatus.INFO, "Demo Site Opened"); //REPORTING
		
		DemoSiteLandingPage landingPage = PageFactory.initElements(driver, DemoSiteLandingPage.class); // Call all elements from DemoSiteLandingPage class
		DemoSiteAddUser addUserPage = PageFactory.initElements(driver, DemoSiteAddUser.class);
		DemoSiteLoginUser loginUserPage = PageFactory.initElements(driver, DemoSiteLoginUser.class);
		
		landingPage.hypAddUser();
		
		addUserPage.writeUserFieldAddUser();
		addUserPage.writePassFieldAddUser();
		addUserPage.clickSaveAddUser();
		addUserPage.clickLoginPage();
		
		loginUserPage.writeUserFieldLogin();
		loginUserPage.writePassFieldLogin();
		loginUserPage.clickTestLogin();
		
//		assertTrue("Login Unsuccessful! (assertTrue)", loginUserPage.checkSuccessfulLogin());
//		assertEquals("Login Unsuccessful! (assertEquals)", "**Successful Login**", loginUserPage.checkSuccessfulLoginString());
		
		test.log(LogStatus.INFO, "Login Test Running ..."); //REPORTING
		if (loginUserPage.checkSuccessfulLoginString().equals("**Successful Login**")) { //REPORTING
			
			test.log(LogStatus.PASS, "Successful Login Text Was Found");
			System.out.println("true");
			
		}
		
		else { //REPORTING
			
			test.log(LogStatus.FAIL, "Successful Login Text Was NOT Found");
			System.out.println("false");
			
		}
		
		assertTrue("Login Unsuccessful! (assertTrue)", loginUserPage.checkSuccessfulLogin());
		assertEquals("Login Unsuccessful! (assertEquals)", "**Successful Login**", loginUserPage.checkSuccessfulLoginString());
		report.endTest(test); //REPORTING
		
		//Thread.sleep(1000);
		//WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));
		//assertEquals("Selenium", searchPage.heading.getText());

	}
	
	@After
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.close();
		
	}
	
	@AfterClass
	public static void end() { //REPORTING
		
		report.flush();
		
	}
}
