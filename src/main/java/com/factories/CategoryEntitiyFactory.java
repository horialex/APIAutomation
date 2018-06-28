package com.factories;

import java.util.Random;

import com.entities.Category;

public class CategoryEntitiyFactory {
	
	public static Category getCategoryInstance() {
		Category cateogry = new Category();
		cateogry.setName("Horatiu_Category_" + randomString("abcdefgh", 5));
		return cateogry;
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
