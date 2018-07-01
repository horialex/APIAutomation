package com.factories;

import com.entities.Booking;
import com.entities.Item;
import com.entities.User;
import com.tools.constants.SessionConstants;
import com.tools.utils.FieldGenerator;
import com.tools.utils.SessionUtils;

public class BookingFactory {

	public static Booking getBookingInstance() {
		Booking booking = new Booking();
		booking.setBookingStatus("Accepted");
		booking.setStartDate(FieldGenerator.getDate(0) + ", " + FieldGenerator.getHour(5));
		booking.setEndDate(FieldGenerator.getDate(1) + ", " + FieldGenerator.getHour(30));
		booking.setItem(new Item());
		booking.setUser(new User());

		Item sessionItem = SessionUtils.getFromSession(SessionConstants.EXPECTED_ITEM);
		User sessionUser = SessionUtils.getFromSession(SessionConstants.EXPECTED_USER);

		booking.getItem().setTitle(sessionItem.getTitle());
		booking.getUser().setName(sessionUser.getName());
		return booking;
	}
	
	 public static Booking getApiBookingInstance() {
	        Booking booking = new Booking();
	        booking.setBookingStatus("Completed");
	        booking.setStartDate(FieldGenerator.getCurrentDate());
	        booking.setEndDate(FieldGenerator.getEndDate(30));
	        booking.setClientTime(FieldGenerator.getCurrentDate());
	        return booking;
	    }

}
