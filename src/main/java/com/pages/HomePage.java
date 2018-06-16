package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://get.whereswhat.com")
public class HomePage extends PageObject {

	@FindBy(id = "email")
	private WebElement emailInput;

	@FindBy(id = "pass")
	private WebElement passwordInput;

	@FindBy(css = "span[class='sign-in-a']")
	private WebElement loginButton;
	
	@FindBy(css = "input[class^='signin btn']")
	private WebElement signInButton;

	public void clickLoginButton() {
		loginButton.click();
	}

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
