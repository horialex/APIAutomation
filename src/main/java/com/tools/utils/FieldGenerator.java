package com.tools.utils;

import com.mifmif.common.regex.Generex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FieldGenerator {

    public static enum TypeOfString {
        ALPHA_CAPS, ALPHA, ALPHANUMERIC, NUMERIC, ALPHANUMERICSCHAR, EMAIL,
    }

    public static String generateStringValue(int lenght, TypeOfString type) {

        String value = "";

        switch (type) {

            case ALPHA_CAPS:
                value = "[A-Z]{" + lenght + "}";
                break;

            case ALPHA:
                value = "[A-Za-z]{" + lenght + "}";
                break;


            case NUMERIC:
                value = "[0-9]{" + lenght + "}";
                break;

            case ALPHANUMERIC:
                value = "[0-9a-zA-Z]{" + lenght + "}";
                break;

            case ALPHANUMERICSCHAR:
                value = "[^0-9a-zA-Z]{" + lenght + "}";
                break;

            case EMAIL:
                value = "[0-9a-z]{" + lenght + "}";

                break;
        }
        Generex generex = new Generex(value);
        value = generex.random();

        return value;
    }

    public static int generateIntValue(int lenght) {
        int random;
        Generex generex = new Generex("[0-9]{" + lenght + "}");
        random = Integer.parseInt(generex.random());

        return random;
    }

    public static String getDate(int days) {
        String date = "";
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, days);

        date = sdf.format(cal.getTime());

        return date;
    }

    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy, h:mm aaa");
        Calendar cal = Calendar.getInstance();

        return sdf.format(cal.getTime());
    }

    public static String getEndDate(int addMinutes) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy, h:mm aaa");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, addMinutes);

        return sdf.format(cal.getTime());
    }

    public static String getHour(int addMinutes) {
        String hour = "";
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm aaa");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, addMinutes);
        for(int i = cal.get(Calendar.MINUTE); i <= cal.getActualMaximum(Calendar.MINUTE) ; i++){
            if(i % 5 == 0){
                cal.set(Calendar.MINUTE, i);
                break;
            }
        }
        hour = sdf.format(cal.getTime());

        return String.valueOf(hour);
    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
}
