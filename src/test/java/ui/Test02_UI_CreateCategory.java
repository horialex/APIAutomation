package ui;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.entities.Category;
import com.steps.CategorySteps;
import com.steps.HeaderSteps;
//github.com/horialex/APIAutomation.git
import com.steps.HomePageSteps;
import com.steps.LoginSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test02_UI_CreateCategory extends BaseTest {
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public CategorySteps categorySteps;
	@Steps
	public HeaderSteps headerSteps;
	
	@Test
	public void test02_UI_CreateCategory() {
		loginSteps.login();
		headerSteps.goTo("ITEMS");
		Category category = categorySteps.createCategory();
		categorySteps.verifyCategoryPresence(category, true);
	}
}
