package com.factories;

import java.util.UUID;

import com.entities.Category;
import com.entities.Item;
import com.entities.Login;
import com.entities.User;

public class ApiEntityFactory {

	public static Login getLoginInstance() {
		Login login = new Login();
		User user = new User();
		user.setEmail("horatiu.encian@evozon.com");
		//user.setPassword("Jungla123.,");
		user.setPassword("testtest1");
		login.setUser(user);
		return login;
	}

	public static Category getCategoryInstance() {
		Category cateogry = new Category();
		cateogry.setName("Horatiu_Category_" + UUID.randomUUID().toString());
		return cateogry;
	}

	public static Item getItemInstance() {
		Item item = new Item();
		item.setTitle(("Horatiu_Item_" + UUID.randomUUID().toString()));
		Object[] emptyArray = {};
		item.setCustom_fields(emptyArray);
		return item;
	}

}
