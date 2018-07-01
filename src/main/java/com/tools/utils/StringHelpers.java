package com.tools.utils;

import java.util.Random;

public class StringHelpers {
    public static String cleanZeroLeadingStrings(String no) {
        String number = no.trim();
        if(no.startsWith("0")) {
            number = no.substring(1);
        }
        return number;
    }
    
    public static String randomString(String chars, int length) {
		  Random rand = new Random();
		  StringBuilder buf = new StringBuilder();
		  for (int i=0; i<length; i++) {
		    buf.append(chars.charAt(rand.nextInt(chars.length())));
		  }
		  return buf.toString();
		}

}
