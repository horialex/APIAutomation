package com.factories;

import com.entities.Login;
import com.entities.User;
import com.tools.utils.TestConfigConstants;

public class LoginFactory {

	public static Login getLoginInstance() {
		Login login = new Login();
		User user = new User();
		user.setEmail(TestConfigConstants.USER);
		user.setPassword(TestConfigConstants.PASS);
        user.setName(TestConfigConstants.USER_NAME);
		login.setUser(user);
		return login;
	}
	
}
