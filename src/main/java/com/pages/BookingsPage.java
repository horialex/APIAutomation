package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.entities.Booking;
import com.entities.Item;
import com.entities.User;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class BookingsPage extends PageObject {

	@FindBy(css = "a.my-bookings")
	private WebElement myBookingsTab;
	
	@FindBy(css = "div[class*='booking-tab-content'] ul[class*='bookings-listing'] div[class*='item-booking-container'] div[class*='booking-details-container']")
	private List<WebElement> bookingsList;
	
	@FindBy(css = "ul[class='nav nav-tabs nav-decoration'] a")
	private List<WebElement> bookingsActionList;
	
	@FindBy(css = "ul[class*='bookings-listing']")
	private WebElementFacade itemBookingsContainer;
	
	@FindBy(css = "button#item-return-item")
	private WebElementFacade returnItemConfirmationPopup;

	private String bookingContainersCssSelector = "div[class*='item-booking-container']";

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

	public WebElement getBookingItem(String itemName) {
		for (WebElement bookingElement : getDriver().findElements(By.cssSelector(bookingContainersCssSelector))) {
			WebElement item = bookingElement.findElement(By.cssSelector("a[class^='ellipsis']"));
			if (item.getText().contentEquals(itemName)) {
				return bookingElement;
			}
		}
		return null;
	}

	public void selectBookingAction(String actionName) {
		for (WebElement action : bookingsActionList) {
			if (action.getText().toLowerCase().contentEquals(actionName.toLowerCase())) {
				action.click();
			}
		}
	}
	
	public void returnItem(Booking b){
        List<WebElementFacade> bookings = itemBookingsContainer.thenFindAll(By.cssSelector("div[class*='item-booking-container']"));
        for(WebElementFacade booking : bookings) {
            String actualItemName = booking.find(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(1) a")).getText().trim();
            String from = booking.find(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(2) span:nth-child(2)")).getText();
            if (actualItemName.contentEquals(b.getItem().getTitle()) && from.contentEquals(b.getStartDate())) {
                booking.find(By.cssSelector("button[class*='return-item']")).click();
                returnItemConfirmationPopup.click();
                break;
            }
        }
    }
	
	 public Booking getBookingModel(Booking b){
	        Booking bookingModel = new Booking();
	        waitABit(1500);
	        List<WebElementFacade> bookings = itemBookingsContainer.thenFindAll(By.cssSelector("div[class*='item-booking-container']"));
	        for(WebElementFacade booking : bookings){
	            String actualItemName = booking.find(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(1) a")).getText().trim();
	            String from = booking.find(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(2) span:nth-child(2)")).getText();
	            if(actualItemName.contentEquals(b.getItem().getTitle()) && from.contentEquals(b.getStartDate())){
	                String to = booking.find(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(2) span:nth-child(4)")).getText();
	                String userName = booking.find(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(3) a")).getText().trim();
	                User user = new User();
	                user.setName(userName);
	                Item item = new Item();
	                item.setTitle(actualItemName);
	                bookingModel.setBookingStatus(booking.find(By.cssSelector(".status-label")).getText());
	                bookingModel.setStartDate(from);
	                bookingModel.setEndDate(to);
	                bookingModel.setUser(user);
	                bookingModel.setItem(item);
	                break;
	            }
	        }
	        return bookingModel;
	    }
}
