package com.steps.ui.flow_steps;

import com.entities.Booking;
import com.entities.Item;
import com.steps.AbstractSteps;
import com.steps.CategorySteps;
import com.steps.HeaderSteps;
import com.steps.ItemSteps;
import com.steps.UserSteps;
import com.tools.constants.SessionConstants;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;

public class ItemBookingSteps extends AbstractSteps {
	private static final long serialVersionUID = 1L;

	@Steps
	HeaderSteps headerSteps;
	@Steps
	CategorySteps categorySteps;
	@Steps
	ItemSteps itemSteps;
	@Steps
	UserSteps userSteps;

	@Step
	public void verifyBooking(Item item) {
		getBookingsPage().verifyBookingItem(item);
	}

	@Step
	public void selectBookingsAction(String action) {
		getBookingsPage().selectBookingAction(action);
	}

	@Step
	public void validateBooking() {
		Booking expectedBooking = SessionUtils.getFromSession(SessionConstants.EXPECTED_BOOKING);
		Booking actualdBooking = getBookingsPage().getBookingModel(expectedBooking);
		//TO DO VALIDATION
	}

	@StepGroup
	public void bookItem() {
		headerSteps.goTo("ITEMS");
		categorySteps.selectCategory();
		itemSteps.bookItem();
		headerSteps.goTo("USERS");
		userSteps.selectUser();

	}

}
