package com.qa.ateeb.SeleniumExample;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {
	
	WebDriver driver;
	String url = "https://www.google.co.uk";
	final String filePath = "C:\\Testing/chromedriver.exe";
	final String driverType = "webdriver.chrome.driver";
	
	@Before
	public void setup() {
		
		System.setProperty(driverType, filePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	@Test
	public void methodTest() {
		
		driver.findElement(By.id("lst-ib")).click();
		driver.findElement(By.id("lst-ib")).sendKeys("hello world");
	    driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
		assertTrue(true);
		
	}
	
	@After
	public void teardown() {
		
		driver.quit();
		
	}
	
}
