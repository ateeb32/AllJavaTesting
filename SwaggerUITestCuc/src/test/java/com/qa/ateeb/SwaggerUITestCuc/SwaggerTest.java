package com.qa.ateeb.SwaggerUITestCuc;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SwaggerTest {
	
	private Response response;
	private RequestSpecification request;

	@Given("^a valid RequestSpec$")
	public void a_valid_RequestSpec() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		request = RestAssured.given();
		
	}

	@When("^a post request with city \"([^\"]*)\", description \"([^\"]*)\", id \"([^\"]*)\", name \"([^\"]*)\" and rating \"([^\"]*)\" is sent$")
	public void a_post_request_with_city_description_id_name_and_rating_is_sent(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		JSONObject params = new JSONObject();
		
		params.put("city", arg1);
		params.put("description", arg2);
		params.put("id", arg3);
		params.put("name", arg4);
		params.put("rating", arg5);
		
	}

	@Then("^the response will have Status Code of \"([^\"]*)\"$")
	public void the_response_will_have_Status_Code_of(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^a get request is sent$")
	public void a_get_request_is_sent() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the response will have Status Code of (\\d+)$")
	public void the_response_will_have_Status_Code_of(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^a Put request is entered to update id (\\d+)'s description$")
	public void a_Put_request_is_entered_to_update_id_s_description(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^a Delete request is sent for id \"([^\"]*)\"$")
	public void a_Delete_request_is_sent_for_id(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}