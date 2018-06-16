package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.entities.Item;
import com.steps.HomePageSteps;
import com.steps.ItemSteps;
import com.steps.LoginSteps;
import com.steps.api.ApiCategorySteps;
import com.steps.api.ApiItemSteps;
import com.steps.api.ApiLoginSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

@RunWith(SerenityRunner.class)
// public class Test04_UI_CreateBookingRequest extends BaseTest{

public class Test04_UI_CreateBookingRequest {

	@Managed(uniqueSession = false)
	public WebDriver webdriver;
//	@ManagedPages(defaultUrl = "https://wwtest.evozon.com/#category/186/items")
//	public Pages pages;

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

	@Test
	public void test04_UT_createBookingRequest() throws InterruptedException {
		System.setProperty("runPlatform", "desktop");
		// apiLoginSteps.loginAsAdmin();
		// Category category = apiCategorySteps.createCategory();
		// Item item = apiItemSteps.createItem(category);
		
		// homePageSteps.navigateToItemsPage();
		// itemSteps.navigateToCategory(category);
//		webdriver.get("https://wwtest.evozon.com/#category/186/items");
	
		loginSteps.loginAsAdmin();
		Thread.sleep(2000);
		webdriver.get("https://wwtest.evozon.com/#category/186/items");
		// itemSteps.bookItem(item);
		Item itemx = new Item();
		itemx.setTitle("Horatiu_Item_aazad");
		itemSteps.bookItem(itemx);
		Thread.sleep(2000);
		// CREATE BOOKING REQUEST

	}

}
