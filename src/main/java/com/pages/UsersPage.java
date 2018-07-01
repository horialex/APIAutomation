package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tools.constants.EnvironmentConstants;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class UsersPage extends PageObject {
	@FindBy(css = "div[class*='list-container'] ul")
	WebElement usersContainer;

	public void selectUser(String userName) {
		waitABit(1000);
		List<WebElement> usersList = usersContainer.findElements(By.cssSelector("h3 a"));
		for (WebElement user : getDriver().findElements(By.cssSelector("div[class*='list-container'] ul h3 a"))) {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", usersList.get(usersList.size()-1));
			if (user.getText().toLowerCase().trim().contentEquals(userName.toLowerCase().trim())) {
				waitABit(250);
				user.click();
				break;
			}
		}
	}
	
	public void navigateToUserPage(int userId) {
		getDriver().get(EnvironmentConstants.BASE_URL + "/#users/" + userId);
	}

}
