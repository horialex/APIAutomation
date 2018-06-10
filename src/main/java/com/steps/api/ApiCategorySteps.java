package com.steps.api;

import com.entities.Category;
import com.entities.Item;
import com.entities.Login;
import com.factories.ApiEntityFactory;
import com.tools.constants.ApiRequestPath;

import net.thucydides.core.annotations.Step;

public class ApiCategorySteps extends AbstractApiSteps {

	@Step
	public Category createCategory() {
		Category cateogoryRequest = ApiEntityFactory.getCategoryInstance();
		Category responseCategory = createResource(ApiRequestPath.CATEGORIES, cateogoryRequest, Category.class);
		return responseCategory;
	}

	@Step
	public void deleteCategory(Category category) {
		deleteResource(ApiRequestPath.CATEGORIES + ApiRequestPath.PATH_SEPARATOR + category.getId());
	}

	@Step()
	public void addImageToCategory(Category category) {
		AbstractApiSteps.extraHeaders.put("Entity-Type", "category");
		AbstractApiSteps.extraHeaders.put("Entity-Id", Integer.toString(category.getId()));
		AbstractApiSteps.extraHeaders.put("Content-Type", "multipart/form-data");
		uploadResource(ApiRequestPath.UPLOAD_IMAGE,  "costum.PNG");
	}

}
