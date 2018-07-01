package com.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class LoginPage extends AbstractPage{
	
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
