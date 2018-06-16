package com.steps;

import com.pages.CategoryPage;
import com.pages.CreateBookingPage;
import com.pages.CreateCategoryPage;
import com.pages.CreateItemPage;
import com.pages.DictionaryPage;
import com.pages.HeaderPage;
import com.pages.HomePage;
import com.pages.ItemsPage;

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
	
	public ItemsPage getItemPage() {
		switch (System.getProperty("runPlatform")) {
		case "desktop":
			return getPages().currentPageAt(ItemsPage.class);
		case "mobile":
			// mobile page object to be returned here
			return getPages().currentPageAt(ItemsPage.class);
		default:
			return null;
		}
	}
	
	public CreateCategoryPage getCreateCategoryPage() {
		switch (System.getProperty("runPlatform")) {
		case "desktop":
			return getPages().currentPageAt(CreateCategoryPage.class);
		case "mobile":
			// mobile page object to be returned here
			return getPages().currentPageAt(CreateCategoryPage.class);
		default:
			return null;
		}
	}
	
	public CreateItemPage getCreateItemPage() {
		switch (System.getProperty("runPlatform")) {
		case "desktop":
			return getPages().currentPageAt(CreateItemPage.class);
		case "mobile":
			// mobile page object to be returned here
			return getPages().currentPageAt(CreateItemPage.class);
		default:
			return null;
		}
	}
	
	public CategoryPage getCategoryPage() {
		switch (System.getProperty("runPlatform")) {
		case "desktop":
			return getPages().currentPageAt(CategoryPage.class);
		case "mobile":
			// mobile page object to be returned here
			return getPages().currentPageAt(CategoryPage.class);
		default:
			return null;
		}
	}
	
	public CreateBookingPage getCreateBookingPage() {
		switch (System.getProperty("runPlatform")) {
		case "desktop":
			return getPages().currentPageAt(CreateBookingPage.class);
		case "mobile":
			// mobile page object to be returned here
			return getPages().currentPageAt(CreateBookingPage.class);
		default:
			return null;
		}
	}
	
}
