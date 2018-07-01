package com.steps.api;

import com.entities.Category;
import com.entities.Item;
import com.factories.ApiEntityFactory;
import com.jayway.restassured.path.json.JsonPath;
import com.tools.constants.ApiRequestPath;
import com.tools.constants.SessionConstants;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;

public class ApiItemSteps extends AbstractApiSteps {

	@Step
	public void createCategoryItem() {
		Category category = SessionUtils.getFromSession(SessionConstants.EXPECTED_CATEGORY);
		
		Item itemRequest = ApiEntityFactory.getItemInstance();
		itemRequest.setCategoryId(category.getId());
		Item itemResponse = createResource(ApiRequestPath.ITEMS, itemRequest, Item.class);
		itemRequest.setCategory(category);
		itemRequest.setId(itemResponse.getId());

		SessionUtils.putOnSession(SessionConstants.ACTUAL_ITEM, itemResponse);
		SessionUtils.putOnSession(SessionConstants.EXPECTED_ITEM, itemRequest);
	}

	@Step
	public Item createItem(Category category) {
		Item itemRequest = ApiEntityFactory.getItemInstance();
		itemRequest.setCategoryId(category.getId());
		Item responseItem = createResource(ApiRequestPath.ITEMS, itemRequest, Item.class);
		return responseItem;
	}

	@Step
	public void deleteItem(Item item) {
		deleteResource(ApiRequestPath.ITEMS, item.getId());
	}
	
	@Step
	public void deleteItem() {
		Item item = SessionUtils.getFromSession(SessionConstants.ACTUAL_ITEM);
		deleteResource(ApiRequestPath.ITEMS, item.getId());
	}

	@Step
	public void createItemFromCsv(Category category) {
		AbstractApiSteps.extraHeaders.put("Entity-Type", "item");
		String csvFile = "zzCat1.csv";
		String fileName = uploadCSVResource(ApiRequestPath.CSV_UPLOAD, csvFile);
		JsonPath jsonPath = new JsonPath(fileName);
		String fileProcessed = jsonPath.get("file");
		createItemFromCSV(ApiRequestPath.PROCESS_CSV_FILE, fileProcessed, category);
		AbstractApiSteps.extraHeaders.remove("Entity-Type");
	}

}
