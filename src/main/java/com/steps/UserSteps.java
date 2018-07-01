package com.steps;

import com.entities.User;
import com.tools.constants.SessionConstants;
import com.tools.utils.SessionUtils;

import net.thucydides.core.annotations.Step;

public class UserSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	@Step
	public void selectUser() {
		User user = SessionUtils.getFromSession(SessionConstants.EXPECTED_USER);
		getUsersPage().selectUser(user.getName());
	}

}
