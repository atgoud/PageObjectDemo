PageObjectDemo
==============

A set of Selenium tests that take advantage of the Page Object pattern. The tests are executed against www.google.com.

Prerequisites:
-------------------------

* JDK 1.5 or higher
* Maven
* Firefox
* For aditional dependecny information refer to pom.xml

Build Instructions:
-------------------------

Execute the tests
> mvn test

Execute the tests & build placeholder application as a stand-alone executable jar
> mvn package

Usage:
-------------------------

The focus of this demo is the tests, which can be executed using using mvn test phase.
There is a placeholder application in ./src/main, which could be substituted for applicaiton under test.

A test execution log can be found at: ./logs/testexecution.log

Implementation Notes:
-------------------------

Example based on sample code and guidelines from: https://code.google.com/p/selenium/wiki/PageObjects

Guidelines for Page Object pattern
* A PageObject need not represent an entire page. It may represent a section that appears many times within a site or page.
* The public methods represent the services that the page offers.
* Try not to expose the internals of the page.
* The tests, not the PageObjects, should be responsible for making assertions about the state of a page. Exception: Verify that the WebDriver is on the correct page when we instantiate the target PageObject.
* Methods return other PageObjects.
* Different results for the same action are modelled as different methods.

The PageFactory - https://code.google.com/p/selenium/wiki/PageFactory
* Javadoc: http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/support/PageFactory.html
* There is a PageFactory in the support package that provides support for this pattern.
* It helps remove some boiler-plate code from your Page Objects.
* Declare some fields on a PageObject that are WebElements or List<WebElement>.
* Initialise the PageObject using initElements(...).

Annotations
* The PageFactory will search for an element on the page that matches the field NAME of the WebElement in the class.
* Someone who's not familiar with the source of the page may not know that the name of the field is.
* You can pick a meaningful name and change the strategy used to look the element up using an annotation.

License
-------------------------
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
