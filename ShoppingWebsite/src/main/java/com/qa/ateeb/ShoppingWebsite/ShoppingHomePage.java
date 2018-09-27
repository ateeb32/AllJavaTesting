package com.qa.ateeb.ShoppingWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingHomePage {

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	private WebElement hoverWomen;
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")
	private WebElement tShirtsLink;
	
	@FindBy(xpath = "//*[@id=\"header_logo\"]/a/img")
	private WebElement backToHome;

	@FindBy(id = "search_query_top")
	private WebElement writeSearchBar;

	@FindBy(xpath = "//*[@id=\"searchbox\"]/button")
	private WebElement clickSearch;

	public void dropdownMenu(WebDriver driver) throws InterruptedException {

		Actions action = new Actions(driver);
		action.moveToElement(hoverWomen).perform();
		Thread.sleep(2000);
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		WebElement myHoverElement = driver.findElement(By.xpath("//*[@id=\\\"block_top_menu\\\"]/ul/li[1]/ul/li[1]/ul/li[1]/a"));
//		action.moveToElement(myHoverElement).click().perform();
		
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul")));
		
		action.moveToElement(myDynamicElement).perform();
		
		tShirtsLink.click();
		
	}
	
	public void clickHome() {
		
		backToHome.click();
		
	}
	
	public void writeSeachBar() {

		writeSearchBar.sendKeys("chiffon dress");

	}

	public void clickSearch() {

		clickSearch.click();

	}

}
