package com.steps;

import com.entities.Category;
import com.factories.ApiEntityFactory;

import net.thucydides.core.annotations.Step;

public class CategorySteps extends AbstractSteps {
	private static final long serialVersionUID = 1L;
	
	@Step()
	public Category createCategory() {
		Category category = ApiEntityFactory.getCategoryInstance();
		getItemPage().clickAddCategoryButton();
		getCreateCategoryPage().createCategory(category);
		return category;
	}

	public void verifyCategoryExists(Category category) {
		getItemPage().categoryExists(category);
	}

	@Step
	public void navigateToCategory(Category category) {
		getItemPage().navigateToCategory(category);
	}
	

}
