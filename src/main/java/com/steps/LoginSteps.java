package com.steps;

import java.util.concurrent.TimeUnit;

import com.entities.User;
import com.factories.ApiEntityFactory;

import net.thucydides.core.annotations.Step;

public class LoginSteps extends AbstractSteps {
	private static final long serialVersionUID = 1L;
	
	@Step()
	public void loginAsAdmin() {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		getDriver().get("https://wwtest.evozon.com");
		getHomePage().clickLoginButton();
		User adminUser = ApiEntityFactory.getAdminUser();
		getHomePage().login(adminUser.getEmail(), adminUser.getPassword());
	}
	
	@Step()
	public void verifyLoggedIn() {
		getHeaderPage().verifyLoggedIn();
	}

}
