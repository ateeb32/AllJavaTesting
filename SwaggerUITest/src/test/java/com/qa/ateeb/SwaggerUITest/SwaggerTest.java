package com.qa.ateeb.SwaggerUITest;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SwaggerTest {
	
	private Response response;
	private RequestSpecification request;

	@Test
	public void basicGetAll() {
		System.out.println("Test 1 - Get all hotels");
		
		Response response = given().contentType(ContentType.JSON).when()
				.get(Constants.URL);	// GETS EVERY RECORD
		System.out.println("Basic Get All Test Method: " + response.getStatusCode());
		System.out.println(response.body().prettyPrint());
	}
	
	@Test
	public void postSwagger() {
		System.out.println("Test 2 - Post/Update hotels");
		
		// Uses the URI library within RestAssured to call the URL
		RestAssured.baseURI = Constants.URL;
		
		// Setup the request
		request = RestAssured.given();

		// We are dealing with JSON file format
		request.header("Content-Type", "application/json");

		// Start building the request parameters
		JSONObject requestParams = new JSONObject();
		
			// Data to be inputed
			requestParams.put("city", "London");
			requestParams.put("description", "5 Star");
			requestParams.put("id", 1); // ONLY UPDATE, LEAVE EMPTY IF NEW RECORD REQUIRED
			requestParams.put("name", "Premier Inn");
			requestParams.put("rating", 8.2);
			
			//System.out.println(requestParams.toString());
			//System.out.println(request.body(requestParams.toString()));
			//	OR
			request.body(requestParams.toString());
			
			
			// finally send the request we have built up
			Response response = request.post("/");
			

			System.out.println("Post Swagger Test: " + response.getStatusCode());
			//	OR
			//response.getStatusCode();
		
	}
	
	@Test
	public void simpleGetTest() {
		System.out.println("Test 3 - Get Specific Hotel");
		
		request = given().contentType(ContentType.JSON);
		
		response = request.when().get(Constants.URL + "/1");
			
		System.out.println("Get Test: " + response.getStatusCode());
		
		System.out.println(response.asString());
		
	}
	
	@Test
	public void simpleDeleteTest() {
		System.out.println("Test 4 - Delete Specific hotel");
		
		request = given().contentType(ContentType.JSON);
		
		response = request.when().delete(Constants.URL + "/2");
			
		System.out.println("Del Test: " + response.getStatusCode());
		
	}

}
