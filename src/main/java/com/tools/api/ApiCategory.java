package com.tools.api;

import com.entities.Category;
import com.factories.CategoryFactory;
import com.steps.api.AbstractApiSteps;
import com.tools.constants.ApiRequestPath;
import com.tools.constants.SessionConstants;
import com.tools.utils.SessionUtils;

public class ApiCategory extends AbstractApiSteps{
	
	 public void createCategory() {
	        Category categoryRequest = CategoryFactory.getCategoryInstance();
	        Category categoryResponse = createResource(ApiRequestPath.CATEGORIES, categoryRequest, Category.class);
	        categoryRequest.setId(categoryResponse.getId());
	        SessionUtils.putOnSession(SessionConstants.ACTUAL_CATEGORY, categoryResponse);
	        SessionUtils.putOnSession(SessionConstants.EXPECTED_CATEGORY, categoryRequest);
	    }

}
