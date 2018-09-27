package com.qa.ateeb.RESTassuredCucumber;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class StepDef {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	@Given("^a film exists with the Title Guardians of the Galaxy Two$")
	public void a_film_exists_with_the_Title_Guardians_of_the_Galaxy_Two() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		request = given().contentType(ContentType.JSON);
	}

	@When("^a user retrieves the film by the title Guardians of the Galaxy Two$")
	public void a_user_retrieves_the_film_by_the_title_Guardians_of_the_Galaxy_Two() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		response = request.when().get(Constants.websiteApiURL + ("&t=" + "Guardians of the Galaxy Two"));
		
	}

	@Then("^the status code reads (\\d+)$")
	public void the_status_code_reads(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		json = response.then().statusCode(200);
		
	}

	@Given("^a film exists with the Title IT$")
	public void a_film_exists_with_the_Title_IT() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		request = given().contentType(ContentType.JSON);
		
	}

	@When("^a user retrieves the film by the title IT$")
	public void a_user_retrieves_the_film_by_the_title_IT() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		response = request.when().get(Constants.websiteApiURL + ("&t=" + "IT"));
		
	}

	@Then("^the Rated Field is equal to R$")
	public void the_Rated_Field_is_equal_to_R() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		json = response.then().body("Rated", equalTo("R"));
		
	}

	@Given("^a film exists with the Title \"([^\"]*)\"$")
	public void a_film_exists_with_the_Title(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		request = given().contentType(ContentType.JSON);
		
	}

	@When("^a user retrieves the film by the title \"([^\"]*)\"$")
	public void a_user_retrieves_the_film_by_the_title(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		response = request.when().get(Constants.websiteApiURL + ("&t=" + arg1));
		
	}

	@Then("^the Rated Field is equal to \"([^\"]*)\"$")
	public void the_Rated_Field_is_equal_to(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		json = response.then().body("Rated", equalTo(arg1));
		
	}

}
