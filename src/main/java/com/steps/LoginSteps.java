package com.steps;

import java.util.concurrent.TimeUnit;

import com.entities.User;
import com.tools.constants.EnvironmentConstants;
import com.tools.constants.SessionConstants;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class LoginSteps extends AbstractSteps {
	private static final long serialVersionUID = 1L;

	@StepGroup
	public void login() {
		User user = SessionUtils.getFromSession(SessionConstants.EXPECTED_USER);
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		getDriver().get(EnvironmentConstants.BASE_URL);
		getHomePage().clickLoginButton();
		getLoginPage().login(user.getEmail(), user.getPassword());
	}

	@Step()
	public void verifyLoggedIn() {
		getHeaderPage().verifyLoggedIn();
	}

}
