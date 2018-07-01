package com.factories;

import com.entities.Category;
import com.tools.utils.StringHelpers;

public class CategoryFactory {
	
	public static Category getCategoryInstance() {
		Category cateogry = new Category();
		cateogry.setName("Horatiu_Category_" + StringHelpers.randomString("abcdefgh", 5));
		return cateogry;
	}
	
	
}
