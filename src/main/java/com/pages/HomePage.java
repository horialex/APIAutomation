package com.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://get.whereswhat.com")
public class HomePage extends PageObject {

	@FindBy(partialLinkText = "log_in")
	private WebElement loginButton;
	
	@FindBy(name = "search")
	private WebElement signUpButton;
	
	public void clickLoginButton() {
		loginButton.click();
	}

}
