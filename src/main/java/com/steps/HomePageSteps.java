package com.steps;

import com.entities.User;
import com.factories.ApiEntityFactory;
import com.pages.HomePage;

import net.thucydides.core.annotations.Step;

public class HomePageSteps extends AbstractSteps {
	private static final long serialVersionUID = 1L;
	
	HomePage homePage;
	
	@Step
	public void navigateToLoginPage() {
		getHomePage().clickLoginButton();
	}
	
	@Step()
	public void loginAsAdmin() {
		User adminUser = ApiEntityFactory.getAdminUser();
		getHomePage().login(adminUser.getEmail(), adminUser.getPassword());
	}
	
	@Step()
	public void verifyLoggedIn() {
		getHeaderPage().verifyLoggedIn();
	}

}
