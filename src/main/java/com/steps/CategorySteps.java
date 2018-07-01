package com.steps;

import org.junit.Assert;

import com.entities.Category;
import com.factories.CategoryFactory;
import com.tools.constants.SessionConstants;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;

public class CategorySteps extends AbstractSteps {
	private static final long serialVersionUID = 1L;

	@Step()
	public Category createCategory() {
		Category category = CategoryFactory.getCategoryInstance();
		getCategoriesPage().selectCategoryAction("Add Category");
		getCreateCategoryPage().createCategory(category);
		return category;
	}

	public void verifyCategoryPresence(Category category, boolean expected) {
		boolean found = getCategoriesPage().categoryExists(category);
		Assert.assertTrue(expected == found);
	}

	@Step
	public void navigateToCategory(Category category) {
		verifyCategoryPresence(category, true);
		getCategoriesPage().getCategory(category).click();
	}

	@Step
	public void selectCategory() {
		Category category = SessionUtils.getFromSession(SessionConstants.EXPECTED_CATEGORY);
		verifyCategoryPresence(category, true);
		getCategoriesPage().getCategory(category).click();
	}

}
