package com.tools.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatter {
    public static String formatDate(String date) {
        String dateFormatted[] = date.replaceAll("[^0-9]", " " ).split(" ");
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy, h:mm aaa");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.valueOf(dateFormatted[0]));
        cal.set(Calendar.MONTH, Integer.valueOf(dateFormatted[1]));
        cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(dateFormatted[2]));
        cal.set(Calendar.HOUR, Integer.valueOf(dateFormatted[3]));
        cal.set(Calendar.MINUTE, Integer.valueOf(dateFormatted[4]));

        return sdf.format(cal.getTime());
    }
}
