package ui;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.entities.Category;
import com.entities.Item;
import com.steps.CategorySteps;
//github.com/horialex/APIAutomation.git
import com.steps.HomePageSteps;
import com.steps.ItemSteps;
import com.steps.LoginSteps;
import com.steps.api.ApiCategorySteps;
import com.steps.api.ApiItemSteps;
import com.steps.api.ApiLoginSteps;
import com.steps.api.flow_steps.ApiCreateItemFlowSteps;
import com.steps.ui.flow_steps.ItemBookingSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test04_UI_BookItem extends BaseTest {

	@Steps
	public ApiLoginSteps apiLoginSteps;
	@Steps
	public ApiCategorySteps apiCategorySteps;
	@Steps
	public ApiItemSteps apiItemSteps;
	@Steps
	public HomePageSteps homePageSteps;
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public ItemSteps itemSteps;
	@Steps
	public ItemBookingSteps itemBookingSteps;
	@Steps
	public CategorySteps categorySteps;
	@Steps
	public ApiCreateItemFlowSteps apiCreateItemFlowSteps;

	@Before
	public void setUp() {
		apiCreateItemFlowSteps.createItem();
	}

	@Test
	public void test04_UT_createBookingRequest() {
		loginSteps.login();
		itemBookingSteps.bookItem();
		itemBookingSteps.validateBooking();
	}
}
