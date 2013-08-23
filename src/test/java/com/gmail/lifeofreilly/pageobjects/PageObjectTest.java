package com.gmail.lifeofreilly.pageobjects;

import org.apache.log4j.Logger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gmail.lifeofreilly.pageobjects.page.GoogleSearchPage;
import com.gmail.lifeofreilly.pageobjects.selection.GoogleSearchResults;
import com.gmail.lifeofreilly.pageobjects.selection.GoogleTopNav;

/**
 * A set of Selenium tests that take advantage of the Page Object pattern.
 * Example based on https://code.google.com/p/selenium/wiki/PageObjects
 *
 * @author Seth Reilly
 * @version 1.0, August 2013
 */
public class PageObjectTest extends TestCase {

    private final static Logger log = Logger.getLogger(PageObjectTest.class);

    private WebDriver driver = null;

    /**
     * Constructs a test case with the given name.
     *
     * @param testName name of the test case.
     */
    public PageObjectTest(String testName) {
        super(testName);
        log.debug("Generating Test Case: " + testName);
    }

    /**
     * Construct a test suite for this class.
     *
     * @return the suite of tests.
     */
    public static Test suite() {
        return new TestSuite(PageObjectTest.class);
    }

    /*
     * setUp: Create a new instance of the FireFox driver.
     */
    @Override
    public void setUp() {
        driver = new FirefoxDriver();
    }

    /*
     * tearDown: Shutdown the driver.
     */
    @Override
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Verify title of home page.
     * Demonstrates use of GoogleSearchPage.
     */
    public void test_Se_Google_PageTitle_HomePage() {
        GoogleSearchPage homePage = new GoogleSearchPage(driver);
        driver.get(homePage.getPageURL());
        assertEquals("Google", driver.getTitle());
    }

    /**
     * Verify search functionality.
     * Demonstrates use of GoogleSearchPage and GoogleSearchResults page objects.
     */
    public void test_Se_Google_Search_Results() {
        GoogleSearchPage homePage = new GoogleSearchPage(driver);
        driver.get(homePage.getPageURL());
        GoogleSearchResults searchResults = homePage.searchFor("adventure");
        assertTrue(searchResults.getSearchResultText().contains("adventure"));
    }

    /**
     * Verify top navigation.
     * Demonstrates use of GoogleSearchPage and GoogleTopNav page objects.
     */
    public void test_Se_Google_TopNav_Navigate() {
        GoogleSearchPage homePage = new GoogleSearchPage(driver);
        driver.get(homePage.getPageURL());
        GoogleTopNav topNav = homePage.getTopNav();
        GoogleSearchPage newsPage = topNav.navigateToNews();
        assertEquals("Google News", driver.getTitle());
    }

}