package com.steps;

import org.junit.Assert;

import com.entities.Category;
import com.factories.CategoryEntitiyFactory;

import net.thucydides.core.annotations.Step;

public class CategoriesSteps extends AbstractSteps {
	private static final long serialVersionUID = 1L;
	
	@Step()
	public Category createCategory() {
		Category category = CategoryEntitiyFactory.getCategoryInstance();
		getCategoriesPage().selectCategoryAction("Add Category");
		getCreateCategoryPage().createCategory(category);
		return category;
	}

	public void verifyCategoryPresence(Category category, boolean expected) {
		boolean found =  getCategoriesPage().categoryExists(category);
		Assert.assertTrue(expected == found);
	}

	@Step
	public void navigateToCategory(Category category) {
		verifyCategoryPresence(category, true);
		getCategoriesPage().getCategory(category).click();
	}
	
}
