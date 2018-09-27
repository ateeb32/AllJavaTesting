package com.qa.ateeb.RESTassuredExample;

import static org.junit.Assert.*;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class SimpleTest {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	@Test
	public void test() {
		
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.get(Constants.websiteApiURL + "&t=batman")
			
		.then().statusCode(200).body("Rated", equalTo("PG-13"));
		
		
	}

}
