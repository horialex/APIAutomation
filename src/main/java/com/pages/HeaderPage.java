package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class HeaderPage extends PageObject{
	
	@FindBy(css = "img.userImage")
	private WebElement userImage;
	
	@FindBy(css = "nav#menu ul[class$='views'] li a")
	private List<WebElement> headerMenuList;
	
		
	public void verifyLoggedIn() {
		Assert.assertTrue(userImage.isDisplayed());
	}
	
	public void selectMenuOption(String menuOption) {
		for(WebElement element : headerMenuList) {
			if(element.getText().toLowerCase().contentEquals(menuOption.toLowerCase())) {
				element.click();
				break;
			}
		}
	}
	
}
