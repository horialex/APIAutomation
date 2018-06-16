package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.entities.Category;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class ItemsPage extends PageObject {
	
	@FindBy(css = "span#add-category")
	private WebElement addCategoryButton;
	
	@FindBy(css = "span#add-item")
	private WebElement addItemButton;
	
	@FindBy(css = "div#categories_page ul#categories_container li h3 a")
	private List<WebElement> categoriesNameList;
	
	public void clickAddCategoryButton() {
		addCategoryButton.click();
	}
	
	public void clickAddItemButton() {
		addItemButton.click();
	}

	public void categoryExists(Category category) {
		boolean categoryFound = false;
		for(WebElement name : categoriesNameList) {
			if(name.getText().toLowerCase().contentEquals(category.getName().toLowerCase())) {
				categoryFound = true;
				break;
			}
		}
		Assert.assertTrue(categoryFound);
	}

	public void navigateToCategory(Category category) {
		for(WebElement name : categoriesNameList) {
			if(name.getText().toLowerCase().contentEquals(category.getName().toLowerCase())) {
				name.click();
				break;
			}
		}
	}

}
