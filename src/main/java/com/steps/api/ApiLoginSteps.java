package com.steps.api;

import com.entities.Login;
import com.entities.User;
import com.factories.ApiEntityFactory;
import com.jayway.restassured.path.json.JsonPath;
import com.tools.constants.ApiRequestPath;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class ApiLoginSteps extends AbstractApiSteps {

	@Step
	public void loginAsAdmin() {
		//sterge numai headerula auth
		  AbstractApiSteps.extraHeaders.clear();
		  Login loginRequest = ApiEntityFactory.getLoginInstance();
		  String loginResponse = createResource(ApiRequestPath.LOGIN_PATH, loginRequest);
		  JsonPath jsonPath = new JsonPath(loginResponse);
		  String token = jsonPath.get("authentication_token");
		  AbstractApiSteps.extraHeaders.put("Authorization", "Basic " + token);
	}
	
	@Step
	public void loginAsAdminUser() {
		//sterge numai headerula auth
		  AbstractApiSteps.extraHeaders.clear();
		  Login loginRequest = ApiEntityFactory.getLoginInstance();
		  String loginResponse = createResource(ApiRequestPath.LOGIN_PATH, loginRequest);
		  JsonPath jsonPath = new JsonPath(loginResponse);
		  String token = jsonPath.get("authentication_token");
		  int user_id =  jsonPath.get("id");
		  AbstractApiSteps.extraHeaders.put("Authorization", "Basic " + token);
		  User user = new User();
		  user.setId(user_id);
		  
		  Serenity.setSessionVariable(user);
//		  return user;
	}

}
