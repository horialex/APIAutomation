package com.steps.api.flow_steps;

import com.steps.api.ApiCategorySteps;
import com.steps.api.ApiItemSteps;
import com.steps.api.ApiLoginSteps;
import net.thucydides.core.annotations.Steps;

public class ApiCreateItemFlowSteps {
    @Steps
    ApiLoginSteps apiLoginStepsSteps;
    @Steps
    ApiCategorySteps apiCategoryStepsSteps;
    @Steps
    ApiItemSteps apiItemSteps;

    public void createItem(){
        apiLoginStepsSteps.loginAdmin();
        apiCategoryStepsSteps.createCategory();
        apiItemSteps.createCategoryItem();
    }
}
