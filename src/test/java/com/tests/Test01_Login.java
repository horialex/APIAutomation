package com.tests;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.entities.Category;
import com.steps.api.ApiCategorySteps;
import com.steps.api.ApiItemSteps;
import com.steps.api.ApiLoginSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test01_Login extends BaseTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public ApiLoginSteps apiLoginSteps;
	@Steps
	public ApiCategorySteps apiCategorySteps;
	@Steps
	public ApiItemSteps apiItemSteps;

	@Test
	@Ignore
	public void test01_Login() {
		apiLoginSteps.loginAsAdmin();
	}

	@Test
	public void test02_CreateCategory() {
		apiLoginSteps.loginAsAdmin();
		Category category = apiCategorySteps.createCategory();
		apiCategorySteps.addImageToCategory(category);
//		apiCategorySteps.deleteCategory(category);
	}

	@Test
	@Ignore
	public void test03_CreateItem() {
		apiLoginSteps.loginAsAdmin();
		Category category = apiCategorySteps.createCategory();
		apiItemSteps.createItem(category);
	}
}