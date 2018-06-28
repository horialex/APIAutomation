package com.steps.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.entities.Booking;
import com.entities.Item;
import com.entities.User;
import com.factories.ApiEntityFactory;
import com.tools.constants.ApiRequestPath;
import com.tools.persistence.Utils;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class ApiBookingSteps extends AbstractApiSteps{
	
	
	@Step
	public Booking createBookingRequest(Item item ) {
		User user = (User)Serenity.getCurrentSession().get("user");
		Booking bookingRequest = ApiEntityFactory.getBooking();
		String startDate = bookingRequest.getStart_date();
		String endDate = bookingRequest.getEnd_date();
		bookingRequest.setStart_date(Utils.formatDate(startDate));
		bookingRequest.setEnd_date(Utils.formatDate(endDate));
		bookingRequest.setItem_id(item.getId());
		bookingRequest.setUser_id(user.getId());
		Booking bookingResponse = createResource(ApiRequestPath.BOOKING, bookingRequest, Booking.class);
		return bookingResponse;
	}
	
	@Step
	public void cancelBooking(Booking booking) {
		deleteResource(ApiRequestPath.BOOKING, booking.getId());
	}

}
