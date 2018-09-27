package com.qa.ateeb.ShoppingWebsite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage {
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
	private WebElement checkProductNamedDress;
	
	public boolean checkForDress() {
		
		if (checkProductNamedDress.getText().equals("Printed Chiffon Dress")) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	public String checkForDressString() {
		
		return checkProductNamedDress.getText();
		
	}

}
