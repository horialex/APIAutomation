package com.steps;

import com.entities.Booking;
import com.entities.Category;
import com.entities.Item;
import com.factories.ApiEntityFactory;

import net.thucydides.core.annotations.Step;

public class ItemSteps extends AbstractSteps {
	private static final long serialVersionUID = 1L;
	


	@Step
	public Item createItem(Category category) {
		Item item = ApiEntityFactory.getItemInstance();
		item.setCategory_id(category.getId());
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
		Booking booking = ApiEntityFactory.getBooking();
		getCategoryPage().clickBookItem(item);
		getCreateBookingPage().createBooking(booking);
	}
}
