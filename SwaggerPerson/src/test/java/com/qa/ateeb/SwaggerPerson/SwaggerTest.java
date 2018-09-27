package com.qa.ateeb.SwaggerPerson;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class SwaggerTest {
	
	private Response response;
	private RequestSpecification request;
	private ValidatableResponse json;

	@Test
	public void basicGetAll() {
		System.out.println("Test 3 - Get all persons");
		
		Response response = given().contentType(ContentType.JSON).when()
				.get(Constants.URL + "s?size=10&page=0");	// GETS EVERY RECORD
		
		System.out.println(response.getStatusCode());
		response.body().prettyPrint();
		System.out.println("");
	}
	
	@Test
	public void postSwagger() {
		System.out.println("Test 1 - Post/Update persons");
		
		// Uses the URI library within RestAssured to call the URL
		RestAssured.baseURI = Constants.URL;

		// Start building the request parameters
		JSONObject address = new JSONObject();
		
			// Data to be inputed
			address.put("city", "London");
			address.put("id", 1); // ONLY UPDATE, LEAVE EMPTY IF NEW RECORD REQUIRED
			address.put("line1", "Premier Innn");
			address.put("line2", "Premier Inn");
			address.put("state", "Premier In");
			address.put("zip", "MMMZZZ");
			
			JSONArray addresses = new JSONArray();
			
			addresses.put(address);
			
			JSONObject params = new JSONObject();
			
			params.put("addresses", addresses);
			params.put("dateOfBirth", "2018-09-26T08:28:58.312Z");
			params.put("firstName", "Donkey");
			params.put("gender", "M");
			params.put("id", 1);
			params.put("lastName", "Kong");
			params.put("middleName", "King");
			
			System.out.println(params.toString());
			//System.out.println(request.body(requestParams.toString()));
			//	OR
			//request.body(address.toString());
			
			request = given().body(params.toString()).
					header("Content-Type", "application/json").header("userId", "00000000");
			response = request.when().put("/");
			json = response.then().statusCode(200);
			
			// finally send the request we have built up
			//Response response = request.post("/");
			

			//System.out.println("Post Swagger Test: " + response.getStatusCode());
			//	OR
			//response.getStatusCode();
			
			System.out.println(response.getStatusCode());
			System.out.println("");
		
	}
	
	@Test
	public void simpleGetTestV() {
		System.out.println("Test 2 - Get Specific Person");
		
		json = given().header("Content-Type", "application/json").
				when().get(Constants.URL + "/1").
				then().statusCode(200);
		
		System.out.println(given().header("Content-Type", "application/json").
				when().get(Constants.URL + "/1").getStatusCode());
		System.out.println(given().header("Content-Type", "application/json").
				when().get(Constants.URL + "/1").asString());
		System.out.println("");
		
	}
	
//	@Test
//	public void simpleDeleteTest() {
//		System.out.println("Test 4 - Delete Specific hotel");
//		
//		request = given().contentType(ContentType.JSON);
//		
//		response = request.when().delete(Constants.URL + "/2");
//			
//		System.out.println("Del Test: " + response.getStatusCode());
//		
//	}

}
