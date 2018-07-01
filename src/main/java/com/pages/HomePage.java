package com.pages;

import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class HomePage extends PageObject {
	
	@FindBy(css = "span[class='sign-in-a']")
	private WebElement loginButton;
	
	public void clickLoginButton() {
		loginButton.click();
	}
}
