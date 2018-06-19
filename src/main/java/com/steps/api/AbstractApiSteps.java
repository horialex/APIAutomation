package com.steps.api;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.entities.Category;
import com.jayway.restassured.builder.MultiPartSpecBuilder;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;
import com.tools.constants.EnvironmentConstants;

public class AbstractApiSteps {

	private static RequestSpecification tokenSpec = null;
	public static Map<String, String> extraHeaders = new HashMap<String, String>();
	
	public static RequestSpecification getSpecWithExtraHeaders(){
		tokenSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setBaseUri("https://wwtest.evozon.com/api")
				.addHeader("User-Agent-WW", "web_agent")
				.addHeaders(extraHeaders)
				.build();
	return tokenSpec;
	}
	
	public static RequestSpecification getMultipartSpec(){
		tokenSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setBaseUri("https://wwtest.evozon.com/api")
				.addHeader("User-Agent-WW", "web_agent")
				.addHeader("Content-Type", "multipart/form-data")
				.addHeaders(extraHeaders)
				.build();
	return tokenSpec;
	}
	
	public static RequestSpecification getCsvMultipartSpec(){
		tokenSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setBaseUri("https://wwtest.evozon.com/api")
				.addHeader("User-Agent-WW", "web_agent")
				.addHeader("Host", "wwtest.evozon.com")
				.addHeader("Content-Type", "multipart/form-data")
				.addHeaders(extraHeaders)
				.build();
	return tokenSpec;
	}
	
	
	protected <T> T createResource (String path, Object requestBody, Class<T> responseClass) {
		return  given().relaxedHTTPSValidation()
				.spec(getSpecWithExtraHeaders())
				.body(requestBody)
				.when().post(path)
				.then()
				.assertThat().statusCode(anyOf(is(201), is(200), is(302)))
				.extract().as(responseClass);
	}
	
	protected void deleteResource (String path, int id) {
		given().relaxedHTTPSValidation()
			.spec(getSpecWithExtraHeaders())
			.when().delete(path + "/" + id)
			.then()
			.assertThat().statusCode(anyOf(is(201),is(204), is(200), is(302)))
		    .extract().response().asString();
	}
	
	protected String createResource (String path, Object requestBody) {
		return given().relaxedHTTPSValidation()
			.spec(getSpecWithExtraHeaders())
			.body(requestBody)
			.when().post(path)
			.then()
			.assertThat().statusCode(anyOf(is(201),is(204), is(200), is(302)))
		    .extract().response().asString();
	}
	
	protected String uploadResource (String path, String fileName) {
		return given().relaxedHTTPSValidation()
			.spec(getMultipartSpec())
			.multiPart(new File(EnvironmentConstants.RESOURCES_PATH + fileName))
			.when().post(path)
			.then()
			.assertThat().statusCode(anyOf(is(201),is(204), is(200), is(302)))
		    .extract().response().asString();
	}
	
	protected String uploadCSVResource (String path, String fileName) {
		 return given().relaxedHTTPSValidation()
			.spec(getCsvMultipartSpec())
			.multiPart(new MultiPartSpecBuilder(new File(System.getProperty("user.dir") + EnvironmentConstants.CSV_RESOURCES_PATH + fileName)).fileName(fileName).mimeType("application/vnd.ms-excel").build())
			.when().post(path)
			.then()
			.assertThat().statusCode(anyOf(is(201),is(204), is(200), is(302)))
		    .extract().response().asString();
	}
	
	protected String createItemFromCSV(String path, String fileName, Category category) {
		 return given().relaxedHTTPSValidation()
					.spec(getCsvMultipartSpec())
					.when().post(path + "?filename=" + fileName + "&" + "category_id="+category.getId())
					.then()
					.assertThat().statusCode(anyOf(is(201),is(204), is(200), is(302)))
				    .extract().response().asString();
	}
	
	
}
