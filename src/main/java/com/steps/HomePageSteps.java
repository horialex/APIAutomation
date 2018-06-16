package com.steps;

import net.thucydides.core.annotations.Step;

public class HomePageSteps extends AbstractSteps {
	private static final long serialVersionUID = 1L;
	
	@Step
	public void navigateToLoginPage() {
		getHomePage().clickLoginButton();
	}
	
	@Step()
	public void navigateToItemsPage() {
		getHeaderPage().clickItemsMenu();
	}
	
	@Step()
	public void navigateToBookingsPage() {
		getHeaderPage().clickBookingsMenu();
	}
}
