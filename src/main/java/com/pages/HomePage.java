package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://get.whereswhat.com")
public class HomePage extends PageObject {
	
	@FindBy(css = "span[class='sign-in-a']")
	private WebElement loginButton;
	

	public void clickLoginButton() {
		loginButton.click();
	}
}
