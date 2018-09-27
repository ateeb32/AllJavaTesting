package com.qa.ateeb.BingTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingSearchPage {
	
	@FindBy(xpath = ("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"))
	private WebElement heading;
	
	public WebElement getHeading() {
		
		return heading;
		
	}

}
