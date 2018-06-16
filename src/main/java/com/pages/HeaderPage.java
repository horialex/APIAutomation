package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class HeaderPage extends PageObject{
	
	@FindBy(css = "img.userImage")
	private WebElement userImage;
	
	public void verifyLoggedIn() {
		Assert.assertTrue(userImage.isDisplayed());
	}

}
