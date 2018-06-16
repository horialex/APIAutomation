package com.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class CreateBookingPage extends PageObject{
	
	@FindBy(css = "button#create-booking-action")
	private WebElement confirmBookingButton;
	
	public void createBooking() {
		//TODO
		
		confirmBookingButton.click();
	}

}
