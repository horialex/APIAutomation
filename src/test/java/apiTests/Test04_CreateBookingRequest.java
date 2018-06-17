package apiTests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.entities.Booking;
import com.entities.Category;
import com.entities.Item;
import com.entities.User;
import com.steps.api.ApiBookingSteps;
import com.steps.api.ApiCategorySteps;
import com.steps.api.ApiItemSteps;
import com.steps.api.ApiLoginSteps;
import com.tests.BaseTest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test04_CreateBookingRequest extends BaseTest{
	
	@Steps
	public ApiLoginSteps apiLoginSteps;
	@Steps
	public ApiCategorySteps apiCategorySteps;
	@Steps
	public ApiItemSteps apiItemSteps;
	@Steps
	public ApiBookingSteps apiBookingSteps;
	
	@Test
	public void test04_CreateBookingRequest() {
		User user = apiLoginSteps.loginAsAdminUser();
		Category category = apiCategorySteps.createCategory();
		Item item = apiItemSteps.createItem(category);
		Booking booking = apiBookingSteps.createBookingRequest(item, user);
		
	}

}
