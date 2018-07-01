package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.entities.Booking;
import com.tools.utils.StringHelpers;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CreateBookingPage extends PageObject {

    @FindBy(css="input[class*='booking_start_date']")
    WebElementFacade startDate;
    @FindBy(css="input[class*='booking_end_date']")
    WebElementFacade endDate;
    @FindBy(css="input[class*='booking_start_hour']")
    WebElementFacade startHour;
    @FindBy(css="input[class*='booking_end_hour']")
    WebElementFacade endHour;
    @FindBy(css="div[class*='picker-open']")
    WebElementFacade datePickerContainer;
    @FindBy (css="#create-booking-action")
    WebElementFacade save;
    @FindBy (css="div.ui-timepicker-wrapper")
    WebElementFacade hourContainer;
    @FindBy (css="div[class*='picker-open'] div.datepicker-months thead th.next")
    WebElementFacade nextYear;
	
	@FindBy(css = "button#create-booking-action")
	private WebElement confirmBookingButton;

	@FindBy(css = "input#booking_start_date1")
	private WebElement calendarStartDate;

	@FindBy(css = "input#booking_start_date2")
	private WebElement calendarEndDate;

//	private String calendarNextButtonCssSelector = "div[style*='block'] div.datepicker > div.datepicker-months > table > thead > tr.pickerHeader th.next";
//	private String calendarMidButtonCssSelector = "div[style*='block'] div.datepicker > div > table > thead > tr.pickerHeader th.picker-switch";
//	private String calendarPreviousButtonCssSelector = "div[style*='block'] div.datepicker > div > table > thead > tr.pickerHeader th.prev";
//	private String calendarMonthListCssSelector = "div[style*='block'] div.datepicker > div.datepicker-months > table tbody > tr > td > span[class^='month']";
//	private String calendarDaysListCssSelector = "div[style*='block'] div.datepicker  div.datepicker-days tbody tr td[class='day']";
//	private String calendarCurrentDayCssSelector = "div[style*='block'] div.datepicker  div.datepicker-days tbody tr td[class*='today']";
//	private String calendarStartTimeCssSelector = "input[class^='booking_start_hour']";
//	private String calendarEndTimeCssSelector = "input[class^='booking_end_hour']";
//	private String calendarHoursListCssSelector = "div.ui-timepicker-wrapper li";

	public void createBooking(Booking booking) {
		selectStartDate(booking.getStartDate());
        selectStartHour(booking.getStartDate());
        selectEndDate(booking.getEndDate());
        selectEndHour(booking.getEndDate());
        saveBooking();
//		selectStartDate(booking.getStart_date());
//		selectEndDate(booking.getEnd_date());
	}

//	public void selectStartDate(String startDate) {
//		calendarStartDate.click();
//		waitFor(ExpectedConditions.visibilityOf(getDriver().findElement(
//				By.cssSelector("div[style*='block'] div.datepicker > div > table > thead > tr.pickerHeader th.next"))));
//		selectYear(startDate);
//		waitFor(500);
//		selectMonth(startDate);
//		selectDay(startDate);
//		selectStartTime(startDate);
//	}
//
//	public void selectEndDate(String endDate) {
//		calendarEndDate.click();
//		waitFor(ExpectedConditions.visibilityOf(getDriver().findElement(
//				By.cssSelector("div[style*='block'] div.datepicker > div > table > thead > tr.pickerHeader th.next"))));
//		selectEndYear(endDate);
//		waitFor(500);
//		selectMonth(endDate);
//		selectDay(endDate);
//		selectEndTime(endDate);
//	}
//
//	public void selectYear(String date) {
//		String date_dd_MM_yyyy[] = (date.split(" ")[0]).split("/");
//		WebElement midLink = getDriver().findElement(By.cssSelector(calendarMidButtonCssSelector));
//		int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
//		midLink.click();
//		if (yearDiff != 0) {
//			// if you have to move next year
//			if (yearDiff > 0) {
//				for (int i = 0; i < yearDiff; i++) {
//					getDriver().findElement(By.cssSelector(calendarNextButtonCssSelector)).click();
//				}
//			}
//			// if you have to move previous year
//			else if (yearDiff < 0) {
//				for (int i = 0; i < (yearDiff * (-1)); i++) {
//					getDriver().findElement(By.cssSelector(calendarPreviousButtonCssSelector)).click();
//				}
//			}
//		}
//	}
//
//	public void selectEndYear(String date) {
//		String date_dd_MM_yyyy[] = (date.split(" ")[0]).split("/");
//		WebElement midLink = getDriver().findElement(By.cssSelector(calendarMidButtonCssSelector));
//		String calendarNumbers = midLink.getText().replaceAll("[^0-9]", "");
//		int calendarEndYear = Integer.parseInt(calendarNumbers);
//		int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - calendarEndYear;
//		midLink.click();
//		if (yearDiff != 0) {
//			// if you have to move next year
//			if (yearDiff > 0) {
//				for (int i = 0; i < yearDiff; i++) {
//					getDriver().findElement(By.cssSelector(calendarNextButtonCssSelector)).click();
//				}
//			}
//			// if you have to move previous year
//			else if (yearDiff < 0) {
//				for (int i = 0; i < (yearDiff * (-1)); i++) {
//					getDriver().findElement(By.cssSelector(calendarPreviousButtonCssSelector)).click();
//				}
//			}
//		}
//	}
//
//	public void selectMonth(String date) {
//		String date_dd_MM_yyyy[] = (date.split(" ")[0]).split("/");
//		List<WebElement> list_AllMonthToBook = getDriver().findElements(By.cssSelector(calendarMonthListCssSelector));
//		list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1]) - 1).click();
//	}
//
//	public void selectDay(String date) {
//		String date_dd_MM_yyyy[] = (date.split(" ")[0]).split("/");
//		Calendar calendar = Calendar.getInstance();
//		int currentYear = calendar.get(Calendar.YEAR);
//		int currentMonth = calendar.get(Calendar.MONTH);
//		int currentDay = calendar.get(Calendar.DATE);
//
//		List<WebElement> list_AllDateToBook = getDriver().findElements(By.cssSelector(calendarDaysListCssSelector));
//		int expectedYear = Integer.parseInt(date_dd_MM_yyyy[2]);
//		int expectedMonth = (Integer.parseInt(date_dd_MM_yyyy[1])-1);
//		int expectedDay = Integer.parseInt(date_dd_MM_yyyy[0]);
//
//		if ((currentYear == expectedYear) && (currentMonth == expectedMonth) && (currentDay == expectedDay)) {
//			WebElement currentDayInCalendar = getDriver().findElement(By.cssSelector(calendarCurrentDayCssSelector));
//			currentDayInCalendar.click();
//		} else {
//			for (WebElement day : list_AllDateToBook) {
//				if (day.getText().contentEquals(Integer.toString(expectedDay))) {
//					day.click();
//					break;
//				}
//			}
//		}
//	}
//	
//	public void selectStartTime(String startDate) {
//		WebElement selectTime = getDriver().findElement(By.cssSelector(calendarStartTimeCssSelector));
//		// click time picker button
//		selectTime.click();
//		List<WebElement> allTime = getDriver().findElements(By.cssSelector(calendarHoursListCssSelector));
//		startDate = startDate.split(" ")[1] + " " + startDate.split(" ")[2];
//		for (WebElement webElement : allTime) {
//			if (webElement.getText().contentEquals(startDate)) {
//				webElement.click();
//				break;
//			}
//		}
//	}
//	
//	public void selectEndTime(String endDate) {
//		WebElement selectTime = getDriver().findElement(By.cssSelector(calendarEndTimeCssSelector));
//		selectTime.click();
//		List<WebElement> allTime = getDriver().findElements(By.cssSelector(calendarHoursListCssSelector));
//		endDate = endDate.split(" ")[1] + " " + endDate.split(" ")[2];
//		for (WebElement webElement : allTime) {
//			if (webElement.getText().contentEquals(endDate)) {
//				webElement.click();
//				break;
//			}
//		}
//	}
//	
	  public void saveBooking(){
	        save.click();
	        // TO DO ensure form was saved - maybe success message
	    }


	    /** this is for the cases where you
	    * don't want some of the steps to
	    * appear in report.
	    * otherwise the methods inside can
	    * be annotated in steps*/
	    public void selectStartDate(String date){
	        startDate.click();
	        selectYear(date);
	        selectMonth(date);
	        selectDay(date);
	    }

	    public void selectEndDate(String date){
	        endDate.click();
	        selectYear(date);
	        selectMonth(date);
	        selectDay(date);
	    }

	    public void selectStartHour(String hour){
	        startHour.click();
	        selectHour(hour.split(",")[1].trim());
	    }

	    public void selectEndHour(String hour){
	        endHour.click();
	        selectHour(hour.split(",")[1].trim());
	    }

	    public void selectMonth(String date){
	        String m = date.split(",")[0].split(" ")[0];
	        List<WebElementFacade> monthList = datePickerContainer.thenFindAll(By.cssSelector("div.datepicker-months tbody span"));
	        for(WebElementFacade month : monthList){
	            if(month.getText().contentEquals(m)){
	                month.click();
	                break;
	            }
	        }
	    }

	    public void selectYear(String date){
	        datePickerContainer.find(By.cssSelector("div.datepicker-days thead th.picker-switch")).click();
	        String providedYear = date.split(",")[0].split(" ")[2];
	        String displayedYear = datePickerContainer.find(By.cssSelector("div.datepicker-months thead th.picker-switch")).getText();
	        System.out.println(displayedYear);
	        int noOfNext = Integer.valueOf(providedYear) - Integer.valueOf(displayedYear);
	        for(int i = 0; i < noOfNext; i++){
	            displayedYear = datePickerContainer.find(By.cssSelector("div.datepicker-months thead th.picker-switch")).getText();
	            if(!displayedYear.contentEquals(providedYear)){
	                nextYear.click();
	            }
	        }
	    }

	    public void selectDay(String date){
	        String d = date.split(",")[0].split(" ")[1];
	        List<WebElementFacade> dayList = datePickerContainer.thenFindAll(By.cssSelector("div.datepicker-days tbody tr td[class='day']"));
	        for(WebElementFacade day : dayList){
	            if(day.getText().contentEquals(StringHelpers.cleanZeroLeadingStrings(d))){
	                day.click();
	                break;
	            }
	        }
	    }

	    public void selectHour(String hour){
	        List<WebElementFacade> hourList = hourContainer.thenFindAll(By.cssSelector("ul li"));
	        for(WebElementFacade h : hourList){
	            if(h.getText().contains(hour)){
	                h.click();
	                break;
	            }
	        }
	    }
	
}
