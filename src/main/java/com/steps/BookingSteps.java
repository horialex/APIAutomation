package com.steps;

import com.entities.Item;

import net.thucydides.core.annotations.Step;

public class BookingSteps extends AbstractSteps{
	private static final long serialVersionUID = 1L;
	
	
	@Step
	public void verifyBooking(Item item) {
		getBookingsPage().verifyBookingItem(item);
	}
	
	@Step
	public void selectBookingsAction(String action) {
		getBookingsPage().selectBookingAction(action);
	}
	
}
