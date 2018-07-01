package ui;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.HomePageSteps;
import com.steps.LoginSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test01_UI_Login extends BaseTest {

	@Steps
	public HomePageSteps homePageSteps;
	@Steps
	public LoginSteps loginSteps;

	@Test
	public void test_login_ui() {
		loginSteps.login();
		loginSteps.verifyLoggedIn();
	}
}
