package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.HomePage;

public class SearchFieldTests {

    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://timecenterfsd.com/");
    }

    @Test
    public void invalidSearchTest() {
        HomePage home = new HomePage(driver);
        var searchField = home.clickSearchIcon();
        searchField.clickSearchField();
        searchField.enterInvalidTextInSearchField();
    }

    @Test
    public void validSearchTest() {
        HomePage home = new HomePage(driver);
        var searchField = home.clickSearchIcon();
        searchField.clickSearchField();
        searchField.enterValidTextInSearchField();
    }

    @Test
    public void emptySearchTest(){
        HomePage home = new HomePage(driver);
        var searchField = home.clickSearchIcon();
        searchField.clickSearchField();
        searchField.enterEmptySearchField();
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }


}}
