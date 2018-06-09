package com.steps.api;

import com.entities.Category;
import com.entities.Item;
import com.factories.ApiEntityFactory;
import com.tools.constants.ApiRequestPath;

import net.thucydides.core.annotations.Step;

public class ApiItemSteps extends AbstractApiSteps {

	@Step
	public void createItem() {
		Item itemRequest = ApiEntityFactory.getItemInstance();
	}

	@Step
	public void createItem(Category category) {
		Item itemRequest = ApiEntityFactory.getItemInstance();
		itemRequest.setCategory_id(category.getId());
		Item responseItem = createResource(ApiRequestPath.ITEMS, itemRequest, Item.class);
	}

	@Step
	public void deleteItem(Item item) {
		deleteResource(ApiRequestPath.ITEMS + ApiRequestPath.PATH_SEPARATOR + item.getId());
	}

}
