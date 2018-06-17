package com.tools.persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static String formatDate(String date) {
		final String OLD_FORMAT = "dd/MM/yyyy HH:mm a";
		final String NEW_FORMAT = "yyyy/MM/dd HH:mm a";
		String newDateString ="";
		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		Date d;
		try {
			d = sdf.parse(date);
			sdf.applyPattern(NEW_FORMAT);
			newDateString = sdf.format(d);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return newDateString;
	}
}
