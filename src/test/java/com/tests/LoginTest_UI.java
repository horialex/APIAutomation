package com.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.HomePageSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class LoginTest_UI extends BaseTest{
	
	
	@Steps
	public HomePageSteps homePageSteps;
	
	
	@Test
	public void test_login_ui() {
		webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webdriver.manage().window().maximize();
		webdriver.get("http://www.google.com");  
//		homePageSteps.navigateToLoginPage();
	}
}
