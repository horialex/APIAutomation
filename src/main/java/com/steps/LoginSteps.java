package com.steps;

import java.util.concurrent.TimeUnit;

import com.entities.User;
import com.factories.ApiEntityFactory;
import com.tools.constants.EnvironmentConstants;

import net.thucydides.core.annotations.Step;

public class LoginSteps extends AbstractSteps {
	private static final long serialVersionUID = 1L;
	
	@Step()
	public void loginAsAdmin() {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		getDriver().get(EnvironmentConstants.BASE_URL);
		getHomePage().clickLoginButton();
		User adminUser = ApiEntityFactory.getAdminUser();
		getLoginPage().login(adminUser.getEmail(), adminUser.getPassword());
	}
	
	@Step()
	public void verifyLoggedIn() {
		getHeaderPage().verifyLoggedIn();
	}

}
