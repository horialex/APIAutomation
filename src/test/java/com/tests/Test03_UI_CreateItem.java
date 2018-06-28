package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.entities.Category;
import com.entities.Item;
import com.steps.CategorySteps;
import com.steps.HomePageSteps;
import com.steps.ItemSteps;
import com.steps.LoginSteps;
import com.steps.api.ApiCategorySteps;
import com.steps.api.ApiItemSteps;
import com.steps.api.ApiLoginSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test03_UI_CreateItem  extends BaseTest {
	
	@Steps
	public ApiLoginSteps apiLoginSteps;
	@Steps
	public ApiCategorySteps apiCategorySteps;
	@Steps
	public ApiItemSteps apiItemSteps;
	@Steps
	public HomePageSteps homePageSteps;
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public ItemSteps itemSteps;
	@Steps
	public CategorySteps categorySteps;
	
	@Test
	public void test03_UI_createItem() throws InterruptedException {
		apiLoginSteps.loginAsAdmin();
		Category category = apiCategorySteps.createCategory();
		loginSteps.loginAsAdmin();
		homePageSteps.navigateToItemsPage();
		Item item = itemSteps.createItem(category);
		categorySteps.navigateToCategory(category);
		itemSteps.verifyItemExists(item);
	}
}
