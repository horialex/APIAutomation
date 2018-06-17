package com.steps.api;

import com.entities.Booking;
import com.entities.Item;
import com.entities.User;
import com.factories.ApiEntityFactory;
import com.tools.constants.ApiRequestPath;

import net.thucydides.core.annotations.Step;

public class ApiBookingSteps extends AbstractApiSteps{
	
	
	@Step
	public Booking createBookingRequest(Item item, User user) {
		Booking bookingRequest = ApiEntityFactory.getBooking();
		
		bookingRequest.setItem_id(item.getId());
		bookingRequest.setUser_id(user.getId());
		Booking bookingResponse = createResource(ApiRequestPath.BOOKING, bookingRequest, Booking.class);
		return bookingResponse;
	}

}
