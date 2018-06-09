package com.steps.api;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;

import net.serenitybdd.core.Serenity;

public class AbstractApiSteps {

	private static RequestSpecification tokenSpec = null;
	public static Map<String, String> extraHeaders = new HashMap<String, String>();

//	public static RequestSpecification getSpec() {
//
//		spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("User-Agent-WW", "web_agent")
//				.setBaseUri("https://www.whereswhat.com").build();
//		return spec;
//	}
	
	public static RequestSpecification getSpecWithExtraHeaders(){
		
		tokenSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setBaseUri("https://www.whereswhat.com/api")
				.addHeader("User-Agent-WW", "web_agent")
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
	
	protected void deleteResource (String path) {
		given().relaxedHTTPSValidation()
			.spec(getSpecWithExtraHeaders())
			.when().delete(path)
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

//	@Step
//	public void loginAsInitiator() {
//
//		String token = given().relaxedHTTPSValidation()
//				.spec(getSpec())
//				.formParam("user", "mihai.barta@evozon.com")
//				.formParam("password", "deltaforce1")
//				.when()
//				.post("/sign_in")
//				.then()
//				.statusCode(200)
//				.extract().path("authentication_token");
//
//		Serenity.getCurrentSession().put("token", token);
//	}

}
