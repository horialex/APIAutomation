package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.entities.Category;
import com.steps.HomePageSteps;
import com.steps.ItemSteps;
import com.steps.LoginSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test02_UI_CreateCategory extends BaseTest {
	
	@Steps
	public HomePageSteps homePageSteps;
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public ItemSteps itemSteps;
	
	@Test
	public void test02_UI_CreateCategory() {
		loginSteps.loginAsAdmin();
		homePageSteps.navigateToItemsPage();
		Category category = itemSteps.createCategory();
		webdriver.navigate().refresh();
		itemSteps.verifyCategoryExists(category);
	}

}
