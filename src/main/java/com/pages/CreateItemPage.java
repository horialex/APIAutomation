package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.entities.Category;
import com.entities.Item;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class CreateItemPage extends PageObject{

	
	@FindBy(css = "input#item_title")
	private WebElement itemTitleInputField;
	
	@FindBy(css = "select#item-category-id option")
	private List<WebElement> itemCategoriesList;
	
	@FindBy(css = "button[class='btn btn-success']")
	private WebElement addItemButton;
	
	public void createItem(Item item, Category category) {
		itemTitleInputField.clear();
		itemTitleInputField.sendKeys(item.getTitle());
		getDriver().findElement(By.cssSelector("select#item-category-id")).click();
		for(WebElement option : itemCategoriesList) {
			if(option.getText().toLowerCase().trim().contentEquals(category.getName().toLowerCase().trim())) {
				option.click();
			}
		}
		addItemButton.click();
	}
}
