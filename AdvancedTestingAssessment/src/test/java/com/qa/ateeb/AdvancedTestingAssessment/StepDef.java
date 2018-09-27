package com.qa.ateeb.AdvancedTestingAssessment;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utils.ScreenshotMethod;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class StepDef {
	
	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;
	
	WebDriver driver;
	
	public static ExtentReports report; //REPORTING
	public ExtentTest test1; //REPORTING
	public ExtentTest test2; //REPORTING
	public ExtentTest test3; //REPORTING
	public ExtentTest test4; //REPORTING
	public ExtentTest test5; //REPORTING
	
	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", Constants.chromeDriverRoot);
	
	}

	@Given("^a vet$")
	public void a_vet() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		Response response = given().contentType(ContentType.JSON).when()
				.get(Constants.ownersURL);	// GETS EVERY RECORD
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.homeURL);
		
	}

	@When("^I click on some records$")
	public void i_click_on_some_records() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		test1 = TestRunner.report.startTest("Test 1 - Owner Records Page Test"); //REPORTING
		
		PetHomePage homePage = PageFactory.initElements(driver, PetHomePage.class);
		homePage.viewAllOwners();
	    
	}

	@Then("^I can see the care available for animals$")
	public void i_can_see_the_care_available_for_animals() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		test1.log(LogStatus.INFO, "Testing Owner Records Page ..."); //REPORTING
		
		if (driver.getCurrentUrl().equals(Constants.ownersURL)) { //REPORTING
			
			test1.log(LogStatus.PASS, "Successfully directed to the correct page!");
			ScreenshotMethod.screenshot(driver);
			
		}
		
		else { //REPORTING
			
			test1.log(LogStatus.FAIL, "Unsuccessful! Page Was NOT Correct");
			ScreenshotMethod.screenshot(driver);
			
		}
		
		TestRunner.report.endTest(test1); //REPORTING
		
		Thread.sleep(2000);
		
		assertEquals("Navigated to incorrect page", Constants.ownersURL, driver.getCurrentUrl());
		
		driver.quit();
	}

	@Given("^an admin$")
	public void an_admin() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		Response response = given().contentType(ContentType.JSON).when()
				.get(Constants.ownersURL);
		
	}

	@When("^I update a record$")
	public void i_update_a_record() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		test2 = TestRunner.report.startTest("Test 2 - Admin Update Records Test"); //REPORTING
		
		test2.log(LogStatus.INFO, "Updating new record on the database!"); //REPORTING
		
		// Uses the URI library within RestAssured to call the URL
		RestAssured.baseURI = Constants.getOwnersBackendURL;
				
		// Start building the request parameters
		JSONObject animalType = new JSONObject();
		
		// Data to be inputed
		test2.log(LogStatus.INFO, "Updating Animal Type . . ."); //REPORTING
		animalType.put("id", 999);
		animalType.put("name", "doggy");
				
		JSONArray animalInfo = new JSONArray();
				
		animalInfo.put(animalType);
				
		JSONObject animalInfoParams = new JSONObject();
				
		// Data to be inputed
		test2.log(LogStatus.INFO, "Updating Animal Info . . ."); //REPORTING
		animalInfoParams.put("type", animalInfo);
		animalInfoParams.put("id", 999);
		animalInfoParams.put("name", "Wooooooooooooooooooooof");
		animalInfoParams.put("birthDate", "2010/01/01");
				
		JSONArray address = new JSONArray();
				
		address.put(animalInfoParams);
				
		JSONObject ownerInfoParams = new JSONObject();
				
		// Data to be inputed
		test2.log(LogStatus.INFO, "Updating Owner Details . . ."); //REPORTING
		ownerInfoParams.put("pets", address);
		ownerInfoParams.put("id", 999);
		ownerInfoParams.put("firstName", "Tommy");
		ownerInfoParams.put("lastName", "Ghost");
		ownerInfoParams.put("address", "The Queens");
		ownerInfoParams.put("city", "NYC");
		ownerInfoParams.put("telephone", "09999999990");
		
		System.out.println(ownerInfoParams.toString());
		
		request = given().body(ownerInfoParams.toString()).
		header("Content-Type", "application/json");
		response = request.when().post("/");
		
	}

	@Then("^the correct details are now shown$")
	public void the_correct_details_are_now_shown() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.homeURL);
		
		PetHomePage homePage = PageFactory.initElements(driver, PetHomePage.class);
		homePage.viewAllOwners();
		OwnerPage ownerPage = PageFactory.initElements(driver, OwnerPage.class);
		
		ScreenshotMethod.screenshot(driver);
		
		Thread.sleep(2000);
		
		test2.log(LogStatus.PASS, "Successfully updated the record!");
		
		TestRunner.report.endTest(test2); //REPORTING
		
		assertEquals("Tommy Ghost", ownerPage.getCheckUpdated().getText());
		
		driver.quit();
		
	}

	@When("^I delete a animal$")
	public void i_delete_a_animal() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		test3 = TestRunner.report.startTest("Test 3 - Admin Delete Animal Test"); //REPORTING
		
		request = given().contentType(ContentType.JSON);
		
		test3.log(LogStatus.INFO, "Processing deletion of field . . .");
		
		response = request.when().delete(Constants.getOwnersBackendURL + "/11");
		
		test3.log(LogStatus.PASS, "Successfully deleted!");
		
	}

	@Then("^emails arent sent to deceased annimals$")
	public void emails_arent_sent_to_deceased_annimals() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		TestRunner.report.endTest(test3); //REPORTING
		
	}

	@When("^I add new records$")
	public void i_add_new_records() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		test4 = TestRunner.report.startTest("Test 4 - Admin Add New Records Test"); //REPORTING
		
	}

	@Then("^the records are correct$")
	public void the_records_are_correct() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		TestRunner.report.endTest(test4); //REPORTING
		
	}

	@When("^I add new owners to the records$")
	public void i_add_new_owners_to_the_records() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		test5 = TestRunner.report.startTest("Test 5 - Admin Add New Owners Test"); //REPORTING
		
		test5.log(LogStatus.INFO, "Adding new record to the database!"); //REPORTING
		
		// Uses the URI library within RestAssured to call the URL
		RestAssured.baseURI = Constants.getOwnersBackendURL;
				
		// Start building the request parameters
		JSONObject animalType = new JSONObject();
		
		// Data to be inputed
		test5.log(LogStatus.INFO, "Inputting Animal Type . . ."); //REPORTING
		animalType.put("id", 999);
		animalType.put("name", "cat");
				
		JSONArray animalInfo = new JSONArray();
				
		animalInfo.put(animalType);
				
		JSONObject animalInfoParams = new JSONObject();
				
		// Data to be inputed
		test5.log(LogStatus.INFO, "Inputting Animal Info . . ."); //REPORTING
		animalInfoParams.put("type", animalInfo);
		animalInfoParams.put("id", 999);
		animalInfoParams.put("name", "Fraudau");
		animalInfoParams.put("birthDate", "2020/01/01");
				
		JSONArray address = new JSONArray();
				
		address.put(animalInfoParams);
				
		JSONObject ownerInfoParams = new JSONObject();
				
		// Data to be inputed
		test5.log(LogStatus.INFO, "Inputting Owner Details . . ."); //REPORTING
		ownerInfoParams.put("pets", address);
		ownerInfoParams.put("id", 999);
		ownerInfoParams.put("firstName", "Bob");
		ownerInfoParams.put("lastName", "The-Builder");
		ownerInfoParams.put("address", "69 Zoo Lane");
		ownerInfoParams.put("city", "Zooland");
		ownerInfoParams.put("telephone", "01234567890");
		
		System.out.println(ownerInfoParams.toString());
		
		request = given().body(ownerInfoParams.toString()).
		header("Content-Type", "application/json");
		response = request.when().post("/");
		json = response.then().statusCode(201);
		
	}

	@Then("^the details show the change$")
	public void the_details_show_the_change() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.homeURL);
		
		PetHomePage homePage = PageFactory.initElements(driver, PetHomePage.class);
		homePage.viewAllOwners();
		OwnerPage ownerPage = PageFactory.initElements(driver, OwnerPage.class);
		
		ScreenshotMethod.screenshot(driver);
		
		Thread.sleep(2000);
		
		test5.log(LogStatus.PASS, "Successfully added a new record!");
		
		TestRunner.report.endTest(test5); //REPORTING
		
		assertEquals("Bob The-Builder", ownerPage.getCheckAdd().getText());
		
		driver.quit();
		
	}
	
	@After
	public void teardown() {
		
		TestRunner.report.flush();
		
	}

}
