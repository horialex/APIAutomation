package com.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.entities.Category;
import com.entities.Item;
import com.steps.BookingSteps;
import com.steps.CategoriesSteps;
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
	public CategoriesSteps categoriesSteps;

	Category category;
	Item item;

	@Before
	public void dataPreparation() {
		apiLoginSteps.loginAsAdmin();
		category = apiCategorySteps.createCategory();
		item = apiItemSteps.createItem(category);
		loginSteps.loginAsAdmin();
	}

	@Test
	public void test04_UT_createBookingRequest() throws InterruptedException {
		homePageSteps.selectMenuOption("ITEMS");
		categoriesSteps.navigateToCategory(category);
		itemSteps.bookItem(item);
		homePageSteps.selectMenuOption("BOOKINGS");
		bookingSteps.selectBookingsAction("My Bookings");
		bookingSteps.verifyBooking(item);
	}
}
