package com.gmail.lifeofreilly.pageobjects.selection;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.gmail.lifeofreilly.pageobjects.page.GoogleSearchPage;

/**
 * Defines a Page Object for the Google top navigation element.
 *
 * @author Seth Reilly
 * @version 1.0, August 2013
 */
public class GoogleTopNav extends AbstractSelection {
    private WebDriver driver;

    //Use annotations to locate elements.
    @FindBy(id = "gb_5")
    private WebElement newsTab;

    @FindBy(id = "gb_8")
    private WebElement mapsTab;

    /**
     * Sole Constructor
     *
     * @param driver the web driver
     */
    public GoogleTopNav(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Service: Navigate to the News section.
     */
    public GoogleSearchPage navigateToNews() {
        newsTab.click();
        return new GoogleSearchPage(driver);
    }

    /**
     * Service: Navigate to the Maps section.
     */
    public GoogleSearchPage navigateToMaps() {
        mapsTab.click();
        return new GoogleSearchPage(driver);
    }
}