package com.qa.ateeb.AdvancedTestingAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnerPage {
	
	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr[18]/td[1]/a")
	private WebElement checkUpdate;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr[11]/td[1]/a")
	private WebElement checkAdd;
	
	public WebElement getCheckUpdated() {
		
		return checkUpdate;
		
	}
	
	public WebElement getCheckAdd() {
		
		return checkAdd;
		
	}

}
