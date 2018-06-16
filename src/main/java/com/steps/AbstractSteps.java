package com.steps;

import com.pages.DictionaryPage;
import com.pages.HeaderPage;
import com.pages.HomePage;

import net.thucydides.core.steps.ScenarioSteps;

public class AbstractSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;

	public DictionaryPage getDictionaryPage() {
		switch (System.getProperty("runPlatform")) {
		case "desktop":
			return getPages().currentPageAt(DictionaryPage.class);
		case "mobile":
			// mobile page object to be returned here
			return getPages().currentPageAt(DictionaryPage.class);
		default:
			return null;
		}
	}

	public HomePage getHomePage() {
		switch (System.getProperty("runPlatform")) {
		case "desktop":
			return getPages().currentPageAt(HomePage.class);
		case "mobile":
			// mobile page object to be returned here
			return getPages().currentPageAt(HomePage.class);
		default:
			return null;
		}
	}
	
	public HeaderPage getHeaderPage() {
		switch (System.getProperty("runPlatform")) {
		case "desktop":
			return getPages().currentPageAt(HeaderPage.class);
		case "mobile":
			// mobile page object to be returned here
			return getPages().currentPageAt(HeaderPage.class);
		default:
			return null;
		}
	}
	
}
