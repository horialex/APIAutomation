package com.steps;

import com.pages.HomePage;

import net.thucydides.core.annotations.Step;

public class HomePageSteps extends AbstractSteps {
	private static final long serialVersionUID = 1L;
	
	HomePage homePage;
	
	@Step
	public void navigateToLoginPage() {
		homePage.clickLoginButton();
	}

}
