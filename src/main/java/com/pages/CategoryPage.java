package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.entities.Category;
import com.entities.Item;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class CategoryPage extends PageObject{
	
	@FindBy(css = "div[class^='list-container'] li  h3 a")
	private List<WebElement> itemsList;
	
	@FindBy(css = "div[class^='list-container'] li")
	private List<WebElement> itemsContainer;
	
	private String bookItemButtonCssSelector = " button[class$='book-item']";
	
	public void itemExists(Item item) {
		boolean itemFound = false;
		for(WebElement name : itemsList) {
			if(name.getText().toLowerCase().contentEquals(item.getTitle().toLowerCase())) {
				itemFound = true;
				break;
			}
		}
		Assert.assertTrue(itemFound);
	}
	
	public void clickBookItem(Item item) {
		for(WebElement items : itemsContainer) {
			WebElement name = items.findElement(By.cssSelector(" h3 a"));
			if(name.getText().toLowerCase().trim().contentEquals(item.getTitle().toLowerCase())) {
				WebElement bookButton = items.findElement(By.cssSelector(bookItemButtonCssSelector));
				bookButton.click();
				break;
			}
			
		}
	}

}
