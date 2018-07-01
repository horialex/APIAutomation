package com.factories;

import java.util.Random;

import com.entities.Item;
import com.entities.Login;
import com.entities.User;
import com.tools.utils.TestConfigConstants;

public class ApiEntityFactory {

	public static Login getLoginInstance() {
		Login login = new Login();
		User user = new User();
		user.setEmail(TestConfigConstants.USER);
		user.setPassword(TestConfigConstants.PASS);
        user.setName(TestConfigConstants.USER_NAME);
		login.setUser(user);
		return login;
	}

	public static Item getItemInstance() {
		Item item = new Item();
		item.setTitle(("Horatiu_Item_" + randomString("zsdsfa", 5)));
		Object[] emptyArray = {};
		item.setCustomFields(emptyArray);
		return item;
	}
	
	public static User getAdminUser() {
		User user = new User();
		user.setEmail("horatiu.encian@evozon.com");
		user.setPassword("testtest1");
		user.setName("Horatiu Encian");
		return user;
	}
	
//	public static Booking getBooking() {
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = new Date();
//		Booking booking = new Booking();
//		booking.setStart_date("20/06/2018 03:50 PM");
//		booking.setEnd_date("20/06/2018 04:00 PM");
//		booking.setClient_time(dateFormat.format(date));
//		return booking;
//	}
	
	public static String randomString(String chars, int length) {
		  Random rand = new Random();
		  StringBuilder buf = new StringBuilder();
		  for (int i=0; i<length; i++) {
		    buf.append(chars.charAt(rand.nextInt(chars.length())));
		  }
		  return buf.toString();
		}

}
