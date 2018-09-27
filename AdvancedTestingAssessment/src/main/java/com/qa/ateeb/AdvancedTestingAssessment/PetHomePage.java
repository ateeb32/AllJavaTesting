package com.qa.ateeb.AdvancedTestingAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PetHomePage {
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
	private WebElement ownersDropDown;
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a/span[2]")
	private WebElement ownersAll;
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[2]/a/span[2]")
	private WebElement ownersAdd;
	
	public void viewAllOwners() {
		
		ownersDropDown.click();
		ownersAll.click();
		
	}
	
	public void addNewOwner() {
		
		ownersDropDown.click();
		ownersAdd.click();
		
	}

}
