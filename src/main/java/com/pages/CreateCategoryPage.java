package com.pages;

import org.openqa.selenium.WebElement;

import com.entities.Category;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class CreateCategoryPage extends PageObject{

	@FindBy(css = "input#category-name")
	private WebElement categoryNameInputField;
	
	@FindBy(css = "button#save-category")
	private WebElement addCategoryButton;
	
	public void createCategory(Category category) {
		categoryNameInputField.clear();
		categoryNameInputField.sendKeys(category.getName());
		addCategoryButton.click();
	}

}
