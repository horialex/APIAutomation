package com.factories;

import com.entities.Item;
import com.tools.utils.FieldGenerator;

public class ItemFactory {
	
	 public static Item getCategoryItemsInstance() {
	        Item items = new Item();
	        items.setTitle("Item - " + FieldGenerator.generateStringValue(4, FieldGenerator.TypeOfString.ALPHANUMERIC));
	        items.setCustomFields(new Object[0]);
	        return items;
	    }

}
