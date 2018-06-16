package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.findby.By;

public class HeaderPage extends PageObject{
	
	@FindBy(css = "img.userImage")
	private WebElement userImage;
	
	@FindBy(css = "nav#menu ul[class$='views'] li a")
	private List<WebElement> headerMenuList;
	
	@FindBy(css ="a[href='#items']")
	private WebElement itemsMenuButton;
	
	@FindBy(css ="a[href='#bookings']")
	private WebElement bookingsMenuButton;
	
	public void verifyLoggedIn() {
		Assert.assertTrue(userImage.isDisplayed());
	}
	
	public void selectMenuOption(String menuOption) {
		for(WebElement element : headerMenuList) {
			if(element.getText().toLowerCase().contentEquals(menuOption.toLowerCase())) {
				element.click();
			}
		}
	}
	
	public void clickItemsMenu() {
		WebDriverWait wait2 = new WebDriverWait(getDriver(), 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#items']")));
		itemsMenuButton.click();
	}
	
	public void clickBookingsMenu() {
		bookingsMenuButton.click();
	}

}
