package com.steps;

import com.entities.Booking;
import com.entities.Category;
import com.entities.Item;
import com.factories.ApiEntityFactory;
import com.factories.BookingFactory;
import com.tools.constants.SessionConstants;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;

public class ItemSteps extends AbstractSteps {
	private static final long serialVersionUID = 1L;

	@Step
	public Item createItem(Category category) {
		Item item = ApiEntityFactory.getItemInstance();
		item.setCategoryId(category.getId());
		getCategoriesPage().selectCategoryAction("Add Item");
		getCreateItemPage().createItem(item, category);
		return item;
	}

	@Step
	public void verifyItemExists(Item item) {
		getCategoryPage().itemExists(item);
	}

	@Step
	public void validateItem() {

	}

	@Step
	public void bookItem(Item item) {
		Booking booking = BookingFactory.getBookingInstance();
		getCategoryPage().clickBookItem(item.getTitle());
		getCreateBookingPage().createBooking(booking);
	}

	@Step
	public void bookItem() {
		Booking booking = BookingFactory.getBookingInstance();
		getCategoryPage().clickBookItem(booking.getItem().getTitle());
		getCreateBookingPage().createBooking(booking);
		SessionUtils.putOnSession(SessionConstants.EXPECTED_BOOKING, booking);
	}
}
