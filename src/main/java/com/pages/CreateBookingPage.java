package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class CreateBookingPage extends PageObject {

	@FindBy(css = "button#create-booking-action")
	private WebElement confirmBookingButton;

	public void createBooking() {
		selectStartDate("");
		// confirmBookingButton.click();
	}

	public void selectStartDate(String startDate) {
		String dateTime = "12/07/2019 02:00 PM";
		WebElement selectDate = getDriver().findElement(By.cssSelector("input#booking_start_date1"));
		selectDate.click();

		waitFor(500);
		// waitFor(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("div[class='bootstrap-datetimepicker-widget
		// dropdown-menu bottom picker-open']"))));
		WebElement nextLink = getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker > div > table > thead > tr.pickerHeader th.next"));
		WebElement midLink = getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker > div > table > thead > tr.pickerHeader th.picker-switch"));
		WebElement previousLink = getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker > div > table > thead > tr.pickerHeader th.prev"));
				

		nextLink.click();
		previousLink.click();

		String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");
		int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
		midLink.click();

		if (yearDiff != 0) {
			// if you have to move next year
			if (yearDiff > 0) {
				for (int i = 0; i < yearDiff; i++) {
					System.out.println("Year Diff->" + i);
					getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker > div.datepicker-months > table > thead > tr.pickerHeader th.next")).click();
				}
			}
			// if you have to move previous year
			else if (yearDiff < 0) {
				for (int i = 0; i < (yearDiff * (-1)); i++) {
					System.out.println("Year Diff->" + i);
					getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker > div.datepicker-months > table > thead > tr.pickerHeader th.prev")).click();
				}
			}
		}
		waitFor(500);
		List<WebElement> list_AllMonthToBook = getDriver().findElements(By.cssSelector("div[style*='block'] div.datepicker > div.datepicker-months > table tbody > tr > td > span[class^='month']"));
		list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();
		
		List<WebElement> list_AllDateToBook = getDriver().findElements(By.cssSelector("div[style*='block'] div.datepicker  div.datepicker-days tbody tr td[class='day']"));
        list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();
        
        ///FOR TIME
        WebElement selectTime = getDriver().findElement(By.cssSelector("input[class^='booking_start_hour']"));
        //click time picker button
        selectTime.click();
        List<WebElement> allTime = getDriver().findElements(By.cssSelector("div.ui-timepicker-wrapper li"));
        dateTime = dateTime.split(" ")[1]+" "+dateTime.split(" ")[2];
        for (WebElement webElement : allTime) {
        	System.out.println(dateTime);
        	if(webElement.getText().contentEquals(dateTime)) {
                webElement.click();
                break;
            }
        }
	}

	public void selectEndDate(String endDate) {

	}

}
