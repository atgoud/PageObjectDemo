package com.gmail.lifeofreilly.pageobjects.page;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.gmail.lifeofreilly.pageobjects.selection.GoogleTopNav;
import com.gmail.lifeofreilly.pageobjects.selection.GoogleSearchResults;

/**
 * Defines a Page Object that represents the standard Google search page e.g. Search, Image, Maps, Play, News.
 *
 * @author Seth Reilly
 * @version 1.0, August 2013
 */
public class GoogleSearchPage extends AbstractPage {
    
    private WebDriver driver;

    public static final String URL = "http://www.google.com/";

    //Use annotations to locate elements.
    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnG")
    private WebElement searchButton;

    /**
     * Sole Constructor
     *
     * @param driver the web driver
     */
    public GoogleSearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Returns the page URL.
     *
     * @return String representation of the URL.
     */
    @Override
    public String getPageURL() {
        return URL;
    }

    /**
     * Service: Get top navigation bar.
     *
     * @return the top navigation bar.
     */
    public GoogleTopNav getTopNav() {
        return new GoogleTopNav(driver);
    }

    /**
     * Service: Perform search.
     *
     * @param text the search term.
     * @return the search result page object.
     */
    public GoogleSearchResults searchFor(String text) {
        searchBox.sendKeys(text);
        searchBox.submit();
        searchButton.click();
        return new GoogleSearchResults(driver);
    }

}