package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.entities.Category;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class CategoriesPage extends PageObject {
	
	@FindBy(css = "span#add-category")
	private WebElement addCategoryButton;
	
	@FindBy(css = "span#add-item")
	private WebElement addItemButton;
	
	@FindBy(css = "div#categories_page ul#categories_container li h3 a")
	private List<WebElement> categoriesNameList;
	
	@FindBy(css = "div.collection-action-container > span span[class$='label']")
	private List<WebElement> actionsList;
	
//	public void clickAddCategoryButton() {
//		addCategoryButton.click();
//	}
//	
//	public void clickAddItemButton() {
//		addItemButton.click();
//	}
	
	//TO DO change to select categoryAction

	public void selectCategoryAction(String actionName) {
		for(WebElement action : actionsList) {
			if(action.getText().toLowerCase().contentEquals(actionName.toLowerCase())) {
				action.click();
				break;
			}
		}
	}
	
	public boolean categoryExists(Category category) {
		for(WebElement name : categoriesNameList) {
			if(name.getText().toLowerCase().contentEquals(category.getName().toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	public WebElement getCategory(Category category) {
		for(WebElement name : categoriesNameList) {
			if(name.getText().toLowerCase().contentEquals(category.getName().toLowerCase())) {
				return name;
			}
		}
		return null;
	}
	
	

}
