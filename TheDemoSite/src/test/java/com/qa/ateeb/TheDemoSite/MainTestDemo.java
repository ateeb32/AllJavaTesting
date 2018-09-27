package com.qa.ateeb.TheDemoSite;

import static org.junit.Assert.*;

import java.sql.Driver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTestDemo {
	
	WebDriver driver;
	String url = "https://www.thedemosite.co.uk";
	final String filePath = "C:\\Testing/chromedriver.exe";
	final String driverType = "webdriver.chrome.driver";
	
	@Before
	public void setup() {
		
		System.setProperty(driverType, filePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	public void clickCreateUser() {
		
		String link = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]";
		WebElement clickOnUser = driver.findElement(By.xpath(link));
		clickOnUser.click();
		
	}
	
	public void selectUser() {
		
		String link = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input";
		WebElement clickUserField = driver.findElement(By.xpath(link));
		clickUserField.click();
		
	}
	
	public void writeUser() {
		
		String link = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input";
		WebElement writeUserField = driver.findElement(By.xpath(link));
		writeUserField.sendKeys("Ateeb");
		
	}
	
	public void selectPass() {
		
		String link = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input";
		WebElement clickPassField = driver.findElement(By.xpath(link));
		clickPassField.click();
		
	}
	
	public void writePass() {
		
		String link = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input";
		WebElement writePassField = driver.findElement(By.xpath(link));
		writePassField.sendKeys("Hello");
		
	}
	
	public void clickSave() {
		
		String link = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input";
		WebElement clickSaveButton = driver.findElement(By.xpath(link));
		clickSaveButton.click();
		
	}
	
	//////////////////////////////////////////////////////////////////////////////
	
	public void clickUserLogin() {
		
		String link = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]";
		WebElement clickLoginUserP = driver.findElement(By.xpath(link));
		clickLoginUserP.click();
		
	}
	
	public void selectLoginUser() {
		
		String link = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input";
		WebElement clickUserL = driver.findElement(By.xpath(link));
		clickUserL.click();
		
	}
	
	public void writeLoginUser() {
		
		String link = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input";
		WebElement writeUserL = driver.findElement(By.xpath(link));
		writeUserL.sendKeys("Ateeb");
		
	}
	
	public void selectLoginPass() {
		
		String link = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input";
		WebElement clickPassL = driver.findElement(By.xpath(link));
		clickPassL.click();
		
	}
	
	public void writeLoginPass() {
		
		String link = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input";
		WebElement writePassL = driver.findElement(By.xpath(link));
		writePassL.sendKeys("Hello");
		
	}
	
	public void clickLogin() {
		
		String link = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input";
		WebElement clickLoginButton = driver.findElement(By.xpath(link));
		clickLoginButton.click();
		
	}
	
	@Test
	public void methodTest() {
		
		clickCreateUser();
		selectUser();
		writeUser();
		selectPass();
		writePass();
		clickSave();
		
		clickUserLogin();
		selectLoginUser();
		writeLoginUser();
		selectLoginPass();
		writeLoginPass();
		clickLogin();
		//assertTrue(true);
		
	}
	
//	@After
//	public void teardown() {
//		
//		driver.quit();
//		
//	}
	
}
