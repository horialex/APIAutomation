package com.steps.api;

import com.entities.Category;
import com.entities.Item;
import com.entities.Login;
import com.factories.ApiEntityFactory;
import com.factories.CategoryEntitiyFactory;
import com.tools.constants.ApiRequestPath;

import net.thucydides.core.annotations.Step;

public class ApiCategorySteps extends AbstractApiSteps {

	@Step
	public Category createCategory() {
		Category cateogoryRequest = CategoryEntitiyFactory.getCategoryInstance();
		Category responseCategory = createResource(ApiRequestPath.CATEGORIES, cateogoryRequest, Category.class);
		return responseCategory;
	}

	@Step
	public void deleteCategory(Category category) {
		deleteResource(ApiRequestPath.CATEGORIES,  category.getId());
	}

	@Step()
	public void addImageToCategory(Category category) {
		AbstractApiSteps.extraHeaders.put("Entity-Type", "category");
		AbstractApiSteps.extraHeaders.put("Entity-Id", Integer.toString(category.getId()));
		uploadResource(ApiRequestPath.UPLOAD_IMAGE,  "costum.PNG");
		AbstractApiSteps.extraHeaders.remove("Entity-Type");
		AbstractApiSteps.extraHeaders.remove("Entity-Id");
		AbstractApiSteps.extraHeaders.remove("Content-Type");
	}
	
	@Step()
	public void validateCategory(Category expected, Category actual) {
		//Category expected = Serentiy
		//Category actual = 
		// bla lba bla
	}

}
