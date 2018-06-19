package com.steps.api;

import com.entities.Category;
import com.entities.Item;
import com.factories.ApiEntityFactory;
import com.jayway.restassured.path.json.JsonPath;
import com.tools.constants.ApiRequestPath;

import net.thucydides.core.annotations.Step;

public class ApiItemSteps extends AbstractApiSteps {

	@Step
	public void createItem() {
		Item itemRequest = ApiEntityFactory.getItemInstance();
	}

	@Step
	public Item createItem(Category category) {
		Item itemRequest = ApiEntityFactory.getItemInstance();
		itemRequest.setCategory_id(category.getId());
		Item responseItem = createResource(ApiRequestPath.ITEMS, itemRequest, Item.class);
		return responseItem;
	}

	@Step
	public void deleteItem(Item item) {
		deleteResource(ApiRequestPath.ITEMS, item.getId());
	}

	@Step
	public void createItemFromCsv(Category category) {
		.addHeader("Entity-Type", "item")
		String csvFile = "zzCat1.csv";
		String fileName = uploadCSVResource(ApiRequestPath.CSV_UPLOAD, csvFile);
		JsonPath jsonPath = new JsonPath(fileName);
		String fileProcessed = jsonPath.get("file");
		createItemFromCSV(ApiRequestPath.PROCESS_CSV_FILE, fileProcessed, category);
	}

}
