package com.qa.ateeb.Reporting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BingPageTest {

	static WebDriver driver = null;
	
	public static ExtentReports report; //REPORTING
	public ExtentTest test; //REPORTING
	
	@BeforeClass
	public static void initial() {
		
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\My Eclipse Workspace\\Reporting\\Reports\\Report.html", true); //REPORTING
		
	}
	
	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Testing/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void bingSearchBox() throws InterruptedException {
		
		test = report.startTest("Search Text"); //REPORTING
		
		driver.get("https://www.bing.com/");
		
		test.log(LogStatus.INFO, "Bing Opened"); //REPORTING
		
		BingPage page = PageFactory.initElements(driver, BingPage.class); // Call all elements from BingPage class
		BingSearchPage searchPage = PageFactory.initElements(driver, BingSearchPage.class);
		page.searchFor("Selenium");
		
		//Thread.sleep(1000);
		//WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));
		
		test.log(LogStatus.INFO, "Search RUN"); //REPORTING
		if (searchPage.getHeading().getText().equals("Selenium")) { //REPORTING
			
			test.log(LogStatus.PASS, "Search Text Was Found");
			System.out.println("true");
			
		}
		
		else { //REPORTING
			
			test.log(LogStatus.FAIL, "Search Text Was NOT Found");
			System.out.println("false");
			
		}
		
		assertEquals("Selenium", searchPage.getHeading().getText());
		report.endTest(test); //REPORTING
		
		//assertEquals("Selenium");
		
	}
	
	@Test
	public void bingSearchBoxKittens() throws InterruptedException {
		test = report.startTest("Search Text");
		driver.get("https://www.bing.com/");
		
		test.log(LogStatus.INFO, "Bing Opened");
		
		BingPage page = PageFactory.initElements(driver, BingPage.class); // Call all elements from BingPage class
		BingSearchPage searchPage = PageFactory.initElements(driver, BingSearchPage.class);
		page.searchFor("Selenium");
		
		//Thread.sleep(1000);
		//WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));
		
		test.log(LogStatus.INFO, "Search RUN");
		if (searchPage.getHeading().getText().equals("Kittens")) {
			
			test.log(LogStatus.PASS, "Search Text Was Found");
			System.out.println("true");
			
		}
		
		else {
			
			test.log(LogStatus.FAIL, "Search Text Was NOT Found");
			System.out.println("false");
			
		}
		
		report.endTest(test);
		assertEquals("Kittens", searchPage.getHeading().getText());
		//assertEquals("Selenium");
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		
		//Thread.sleep(3000);
		driver.close();
		
	}
	
	@AfterClass
	public static void end() { //REPORTING
		
		report.flush();
		
	}

}
