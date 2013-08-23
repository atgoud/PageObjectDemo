package com.gmail.lifeofreilly.pageobjects.selection;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

/**
 * Defines a Page Object for the Google search results.
 *
 * @author Seth Reilly
 * @version 1.0, August 2013
 */
public class GoogleSearchResults extends AbstractSelection {
    private WebDriver driver;

    //Use annotations to locate elements.
    @FindBy(id = "search")
    private WebElement searchResults;

    /**
     * Sole Constructor
     *
     * @param driver the web driver
     */
    public GoogleSearchResults(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Service: Get search results as text.
     *
     * @return the search result text.
     */
    public String getSearchResultText() {
        return searchResults.getText();
    }

}