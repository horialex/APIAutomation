package com.entities;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.findby.By;

public class BookingsPage extends PageObject {

	@FindBy(css = "a.my-bookings")
	private WebElement myBookingsTab;

	@FindBy(css = "div[class*='booking-tab-content'] ul[class*='bookings-listing'] div[class*='item-booking-container'] div[class*='booking-details-container']")
	private List<WebElement> bookingsList;

	public void clickMyBookingsTab() {
		myBookingsTab.click();
	}

	public void verifyBookingUser() {
		for (WebElement bookingElement : bookingsList) {
			WebElement bookingUser = bookingElement.findElement(By.cssSelector(" a[class^='userName ']"));
			// TO DO
		}
	}

	public void verifyBookingItem(Item item) {
		boolean bookingItemFound = false;
		for (WebElement bookingElement : bookingsList) {
			WebElement bookingItem = bookingElement.findElement(By.cssSelector("a[class^='ellipsis']"));
			if (bookingItem.getText().contentEquals(item.getTitle())) {
				bookingItemFound = true;
				break;
			}
		}
		Assert.assertTrue(bookingItemFound);
	}
}
