package com.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPage extends PageObject {
    
	public List<WebElement> waitForElementsByCssLocator(String cssLocator) {
        return (new WebDriverWait(getDriver(), 20))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssLocator)));
    }

    public void waitForPageToLoad() {
        int retry = 0;
        String response = "";
        do {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            response = String.valueOf(((JavascriptExecutor) getDriver()).executeScript("return document.readyState"));
            System.out.println("response: " + response);
            retry++;
        } while (retry <= 4 && response.equals("complete") != true);
    }
}
