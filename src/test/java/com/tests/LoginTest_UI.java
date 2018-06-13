package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.HomePageSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class LoginTest_UI extends BaseTest{
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public HomePageSteps homePageSteps;
	
	
	@Test
	public void test_login_ui() {
		homePageSteps.navigateToLoginPage();
	}
}
