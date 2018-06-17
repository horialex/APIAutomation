package com.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.entities.Booking;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class CreateBookingPage extends PageObject {

	@FindBy(css = "button#create-booking-action")
	private WebElement confirmBookingButton;

	public void createBooking(Booking booking) {
		selectStartDate(booking.getStartDate());
		selectEndDate(booking.getEndDate());
		confirmBookingButton.click();
	}

	public void selectStartDate(String startDate) {
		final String OLD_FORMAT = "yyyy/MM/dd HH:mm a";
		final String NEW_FORMAT = "dd/MM/yyyy HH:mm a";
		String newDateString ="";
		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		Date d;
		try {
			d = sdf.parse(startDate);
			sdf.applyPattern(NEW_FORMAT);
			newDateString = sdf.format(d);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		WebElement selectDate = getDriver().findElement(By.cssSelector("input#booking_start_date1"));
		selectDate.click();
		waitFor(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker > div > table > thead > tr.pickerHeader th.next"))));
		WebElement nextLink = getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker > div > table > thead > tr.pickerHeader th.next"));
		WebElement midLink = getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker > div > table > thead > tr.pickerHeader th.picker-switch"));
		WebElement previousLink = getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker > div > table > thead > tr.pickerHeader th.prev"));
		String date_dd_MM_yyyy[] = (newDateString.split(" ")[0]).split("/");
		//an
		int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
		midLink.click();

		if (yearDiff != 0) {
			// if you have to move next year
			if (yearDiff > 0) {
				for (int i = 0; i < yearDiff; i++) {
					getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker > div.datepicker-months > table > thead > tr.pickerHeader th.next")).click();
				}
			}
			// if you have to move previous year
			else if (yearDiff < 0) {
				for (int i = 0; i < (yearDiff * (-1)); i++) {
					getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker > div.datepicker-months > table > thead > tr.pickerHeader th.prev")).click();
				}
			}
		}
		waitFor(500);
		//luna
		List<WebElement> list_AllMonthToBook = getDriver().findElements(By.cssSelector("div[style*='block'] div.datepicker > div.datepicker-months > table tbody > tr > td > span[class^='month']"));
		list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();
		
		Calendar calendar = Calendar.getInstance();
		int currentDay = calendar.get(Calendar.DATE); 
		List<WebElement> list_AllDateToBook = getDriver().findElements(By.cssSelector("div[style*='block'] div.datepicker  div.datepicker-days tbody tr td[class='day']"));
		
		String expectedDay = Integer.toString(Integer.parseInt(date_dd_MM_yyyy[0]));
		if(Integer.toString(currentDay).contentEquals(expectedDay)) {
			WebElement currentDayInCalendar = getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker  div.datepicker-days tbody tr td[class*='today']"));
			currentDayInCalendar.click();
		}else {
			for(WebElement day : list_AllDateToBook) {
				if(day.getText().contentEquals(expectedDay)) {
					day.click();
					break;
				}
			}
		}
		
        ///selecteaza timpul
        WebElement selectTime = getDriver().findElement(By.cssSelector("input[class^='booking_start_hour']"));
        //click time picker button
        selectTime.click();
        List<WebElement> allTime = getDriver().findElements(By.cssSelector("div.ui-timepicker-wrapper li"));
        newDateString = newDateString.split(" ")[1]+" " + newDateString.split(" ")[2];
        for (WebElement webElement : allTime) {
        	if(webElement.getText().contentEquals(newDateString)) {
                webElement.click();
                break;
            }
        }
	}

	public void selectEndDate(String endDate) {
//		final String OLD_FORMAT = "yyyy/MM/dd HH:mm a";
//		final String NEW_FORMAT = "dd/MM/yyyy HH:mm a";
//		String newDateString ="";
//		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
//		Date d;
//		try {
//			d = sdf.parse(endDate);
//			sdf.applyPattern(NEW_FORMAT);
//			newDateString = sdf.format(d);
//			
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		System.out.println("END DATE IN NEW FORMAT IS " + newDateString);
		
		WebElement selectEndDate = getDriver().findElement(By.cssSelector("input#booking_start_date2"));
		selectEndDate.click();
		waitFor(500);
		waitFor(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker > div > table > thead > tr.pickerHeader th.next"))));
		WebElement nextLink = getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker > div > table > thead > tr.pickerHeader th.next"));
		WebElement midLink = getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker > div > table > thead > tr.pickerHeader th.picker-switch"));
		WebElement previousLink = getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker > div > table > thead > tr.pickerHeader th.prev"));
				
		String date_dd_MM_yyyy[] = (endDate.split(" ")[0]).split("/");
		//an
		int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
		midLink.click();
		if (yearDiff != 0) {
			// if you have to move next year
			if (yearDiff > 0) {
				for (int i = 0; i < yearDiff; i++) {
					getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker > div.datepicker-months > table > thead > tr.pickerHeader th.next")).click();
				}
			}
			// if you have to move previous year
			else if (yearDiff < 0) {
				for (int i = 0; i < (yearDiff * (-1)); i++) {
					getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker > div.datepicker-months > table > thead > tr.pickerHeader th.prev")).click();
				}
			}
		}
		
		waitFor(500);
		//month
		List<WebElement> list_AllMonthToBook = getDriver().findElements(By.cssSelector("div[style*='block'] div.datepicker > div.datepicker-months > table tbody > tr > td > span[class^='month']"));
		list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();
		
		//day
		Calendar calendar = Calendar.getInstance();
		int currentDay = calendar.get(Calendar.DATE); 
		List<WebElement> list_AllDateToBook = getDriver().findElements(By.cssSelector("div[style*='block'] div.datepicker  div.datepicker-days tbody tr td[class='day']"));
		
		String expectedDay = Integer.toString(Integer.parseInt(date_dd_MM_yyyy[0]));
		if(Integer.toString(currentDay).contentEquals(expectedDay)) {
			WebElement currentDayInCalendar = getDriver().findElement(By.cssSelector("div[style*='block'] div.datepicker  div.datepicker-days tbody tr td[class*='today']"));
			currentDayInCalendar.click();
		}else {
			for(WebElement day : list_AllDateToBook) {
				if(day.getText().contentEquals(expectedDay)) {
					day.click();
					break;
				}
			}
		}
		//Selcteaza timpul
        WebElement selectTime = getDriver().findElement(By.cssSelector("input[class^='booking_end_hour']"));	
        selectTime.click();
        List<WebElement> allTime = getDriver().findElements(By.cssSelector("div.ui-timepicker-wrapper li"));
        endDate = endDate.split(" ")[1]+" "+ endDate.split(" ")[2];
        for (WebElement webElement : allTime) {
        	if(webElement.getText().contentEquals(endDate)) {
                webElement.click();
                break;
            }
        }
	}
}
