package com.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

import net.thucydides.core.annotations.Step;

public class EndUserSteps extends AbstractSteps{

	private static final long serialVersionUID = 1L;

    @Step
    public void enters(String keyword) {
    	getHeaderPage().enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
    	getHeaderPage().lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(getHeaderPage().getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
    	getHeaderPage().open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}