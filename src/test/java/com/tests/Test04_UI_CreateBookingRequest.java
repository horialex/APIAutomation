package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.entities.Category;
import com.entities.Item;
import com.steps.BookingSteps;
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
public class Test04_UI_CreateBookingRequest extends BaseTest {

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
	public BookingSteps bookingSteps;
	@Steps
	public CategorySteps categorySteps;

	@Test
	public void test04_UT_createBookingRequest() throws InterruptedException {
		apiLoginSteps.loginAsAdmin();
		Category category = apiCategorySteps.createCategory();
		Item item = apiItemSteps.createItem(category);
		loginSteps.loginAsAdmin();
		homePageSteps.navigateToItemsPage();
		categorySteps.navigateToCategory(category);
		itemSteps.bookItem(item);
		homePageSteps.navigateToBookingsPage();
		bookingSteps.navigateToMyBookingsTab();
		bookingSteps.verifyBooking(item);
	}
}
