package apiTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.entities.Category;
import com.entities.Item;
import com.steps.api.ApiCategorySteps;
import com.steps.api.ApiItemSteps;
import com.steps.api.ApiLoginSteps;
import com.tests.BaseTest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test03_CreateItem extends BaseTest{
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public ApiLoginSteps apiLoginSteps;
	@Steps
	public ApiCategorySteps apiCategorySteps;
	@Steps
	public ApiItemSteps apiItemSteps;
	
	@Test
	public void test03_CreateItem() {
		apiLoginSteps.loginAsAdmin();
		Category category = apiCategorySteps.createCategory();
		Item item = apiItemSteps.createItem(category);
		apiItemSteps.deleteItem(item);
	}
}
