package com.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class LoginPage extends PageObject{
	
	@FindBy(id = "email")
	private WebElement emailInput;

	@FindBy(id = "pass")
	private WebElement passwordInput;
	
	@FindBy(css = "input[class^='signin btn']")
	private WebElement signInButton;
	
	public void typeEmail(String email) {
		emailInput.clear();
		emailInput.sendKeys(email);
	}

	public void typePassword(String password) {
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}

	public void clickSignIn() {
		signInButton.click();
	}

	public void login(String email, String password) {
		typeEmail(email);
		typePassword(password);
		clickSignIn();
	}
	
	

}
