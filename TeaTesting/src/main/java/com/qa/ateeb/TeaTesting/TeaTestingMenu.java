package com.qa.ateeb.TeaTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaTestingMenu {
	
	@FindBy(xpath = "//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]/span")
	private WebElement checkoutClick;

	public void clickCheckoutButton() {
		
		checkoutClick.click();

	}

}
