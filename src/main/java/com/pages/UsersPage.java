package com.pages;

import java.util.List;

import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class UsersPage extends PageObject {
	@FindBy(css = "div[class*='list-container'] ul")
	WebElementFacade usersContainer;

	public void selectUser(String userName) {
		List<WebElementFacade> usersList = usersContainer.thenFindAll(By.cssSelector("h3 a"));
		for (WebElementFacade user : usersList) {
			if (user.getText().trim().contentEquals(userName)) {
				user.click();
				break;
			}
		}
	}

}
