package com.qa.ateeb.AutomatedAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsUserCreatedPage {
	
	@FindBy(id = "people")
	private WebElement userFound;
	
	@FindBy(xpath = "//*[@id=\"people\"]/tbody/tr[3]/td[2]/a")
	private WebElement chris;
	
	
	public boolean findUser() {
		
		if ((userFound.getText().contains("donkey")) 
				|| (userFound.getText().contains("Chris95")) 
				|| (userFound.getText().contains("M4TT")) 
				|| (userFound.getText().contains("DEv"))
				|| (userFound.getText().contains("matthewhunt"))) {
			
			return true;
		}
		
		else {
			
			return false;
			
		}
		
	}
	
	public void clickUser() {
		
		userFound.click();
		
	}
	
//	public void clickChris() {
//		
//		chris.click();
//		
//	}

}
