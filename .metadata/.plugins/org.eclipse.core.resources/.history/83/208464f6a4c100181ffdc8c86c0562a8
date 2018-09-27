package com.qa.ateeb.SwaggerUITest;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import cucumber.api.java.en.*;
//import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

@SuppressWarnings("unused")
public class StepDef {
	
	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;
	
	@Given("^a valid RequestSpec$")
	public void a_valid_RequestSpec() throws Throwable {
		request = given();
	}

	@When("^a post request with city \"([^\"]*)\", description \"([^\"]*)\", id \"([^\"]*)\", name \"([^\"]*)\" and rating \"([^\"]*)\" is sent$")
	public void a_post_request_with_city_description_id_name_and_rating_is_sent(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		
//		RestAssured.baseURI = Constants.URL;
		JSONObject params = new JSONObject();
		
		params.put("city", arg1);
		params.put("description", arg2);
		params.put("id", Integer.valueOf(arg3));
		params.put("name", arg4);
		params.put("rating", Integer.valueOf(arg5));
		
		System.out.println(params.toString());
		
		request.body(params.toString()).header("Content-Type", "application/json");
		response = request.when().post("http://localhost:8090/example/v1/hotels");
	}

	@Then("^the response will have Status Code of \"([^\"]*)\"$")
	public void the_response_will_have_Status_Code_of(String arg1) throws Throwable {
		System.out.println(arg1);
		json = response.then().statusCode(Integer.valueOf(arg1));
	}
	
	@Then("^the response will have Status Code of (\\d+)$")
	public void the_response_will_have_Status_Code_of(int arg1) throws Throwable {
		//System.out.println(arg1);
		json = response.then().statusCode(arg1);
	}

	@When("^a get request is sent$")
	public void a_get_request_is_sent() throws Throwable {
		request.contentType(ContentType.JSON);
	    response = request.when().get("http://localhost:8090/example/v1/hotels"+"/?page=0&size=10");
	}

	@When("^a Put request is entered to update id (\\d+)'s description$")
	public void a_Put_request_is_entered_to_update_id_s_description(int arg1) throws Throwable {
//		RestAssured.baseURI = Constants.URL+"/"+arg1;
		JSONObject params = new JSONObject();
		
		System.out.println(arg1);
		
		params.put("city", "Leeds");
		params.put("description", "Huge");
		params.put("id", arg1);
		params.put("name", "Melvins");
		params.put("rating", 5);
		
		request.body(params.toString()).header("Content-Type", "application/json");
		response = request.when().put("http://localhost:8090/example/v1/hotels"+"/"+arg1);
	}

	@When("^a Delete request is sent for id \"([^\"]*)\"$")
	public void a_Delete_request_is_sent_for_id(String arg1) throws Throwable {
		response = request.when().delete(Constants.URL+"/"+arg1);
	}
}
