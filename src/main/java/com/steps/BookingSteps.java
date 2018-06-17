package com.steps;

import com.entities.Item;

import net.thucydides.core.annotations.Step;

public class BookingSteps extends AbstractSteps{
	private static final long serialVersionUID = 1L;
	
	@Step
	public void navigateToMyBookingsTab() {
		getBookingsPage().clickMyBookingsTab();
	}
	
	@Step
	public void verifyBooking(Item item) {
		getBookingsPage().verifyBookingItem(item);
	}
	
	
}
