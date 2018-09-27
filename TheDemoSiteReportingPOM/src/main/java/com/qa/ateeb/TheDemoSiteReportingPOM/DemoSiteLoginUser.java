package com.qa.ateeb.TheDemoSiteReportingPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoSiteLoginUser {
	
	@FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	private WebElement writeUserFieldLogin;
	
	@FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	private WebElement writePassFieldLogin;
	
	@FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
	private WebElement clickTestLogin;
	
	@FindBy (xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement successfulLogin;
	
	public void writeUserFieldLogin() {
		
		writeUserFieldLogin.sendKeys("Ateeb");
		
	}
	
	public void writePassFieldLogin() {
		
		writePassFieldLogin.sendKeys("Hello");
		
	}
	
	public void clickTestLogin() {
		
		clickTestLogin.click();
		
	}
	
	public boolean checkSuccessfulLogin() {
		
		if (successfulLogin.getText().equals("**Successful Login**")) {
			
			return true;
		}
		
		return false;
	}
	
	public String checkSuccessfulLoginString() {
		
		return successfulLogin.getText();
		
	}

}
