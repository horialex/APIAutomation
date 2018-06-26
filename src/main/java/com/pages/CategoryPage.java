package com.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.entities.Item;
import net.serenitybdd.core.pages.PageObject;

public class CategoryPage extends PageObject{
	private String bookItemButtonCssSelector = " button[class$='book-item']";
	private String itemsNamesListCssSelector = "div[class^='list-container'] li  h3 a";
	private String itemsContainerListCssSelector = "div[class^='list-container'] li";
	
	
	public boolean itemIsPresent(Item item) {
		for(WebElement name : getDriver().findElements(By.cssSelector(itemsNamesListCssSelector))) {
			if(name.getText().toLowerCase().contentEquals(item.getTitle().toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	
	public void itemExists(Item item) {
		boolean itemFound = false;
		for(WebElement name : getDriver().findElements(By.cssSelector(itemsNamesListCssSelector))) {
			if(name.getText().toLowerCase().contentEquals(item.getTitle().toLowerCase())) {
				itemFound = true;
				break;
			}
		}
		Assert.assertTrue(itemFound);
	}
	
	public void clickBookItem(Item item) {
		for(WebElement items : getDriver().findElements(By.cssSelector(itemsContainerListCssSelector))) {
			WebElement name = items.findElement(By.cssSelector(" h3 a"));
			if(name.getText().toLowerCase().trim().contentEquals(item.getTitle().toLowerCase())) {
				WebElement bookButton = items.findElement(By.cssSelector(bookItemButtonCssSelector));
				bookButton.click();
				break;
			}
			
		}
	}

}
