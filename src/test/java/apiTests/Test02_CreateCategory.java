package apiTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.entities.Category;
import com.steps.api.ApiCategorySteps;
import com.steps.api.ApiLoginSteps;
import com.tests.BaseTest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test02_CreateCategory extends BaseTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public ApiLoginSteps apiLoginSteps;
	@Steps
	public ApiCategorySteps apiCategorySteps;

	@Test
	public void test02_CreateCategory() {
		apiLoginSteps.loginAsAdmin();
		Category category = apiCategorySteps.createCategory();
		apiCategorySteps.addImageToCategory(category);
		apiCategorySteps.deleteCategory(category);
	}}
