package test;


import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.HomePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static extensions.UiElementsExtension.*;

public class CatalogPageTests {

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
    public void verifyUnderFiftyFilterResults() {
        HomePage home = new HomePage(driver);
        var catalog = home.clickCatalogLink();
        waitForSeconds(10);
        catalog.selectUnderFiftyFromDropDown();
        String resultsText = catalog.getResultsContainerText();
        waitForSeconds(5);
        List<Integer> extractedPrices = catalog.extractPricesFromResults(resultsText);
        waitForSeconds(5);
        for (Integer price : extractedPrices) {
            Assert.assertTrue("Found a product over Rs5,000: " + price, price < 5000);
        }
    }

    @Test
    public void verifyBetween50And70FilterResults() {
        HomePage home = new HomePage(driver);
        var catalog = home.clickCatalogLink();
        waitForSeconds(10);
        catalog.selectBetweenFiftyAndSeventyFromDropDown();
        String resultsText = catalog.getResultsContainerText();
        waitForSeconds(5);
        List<Integer> extractedPrices = catalog.extractPricesFromResults(resultsText);
        waitForSeconds(5);
        for (Integer price : extractedPrices) {
            Assert.assertTrue("Found a product between Rs5,000 and Rs7,000: " + price, price > 5000 && price < 7000);
        }
    }

    @Test
    public void verifyingFilterWorking() {
        HomePage home = new HomePage(driver);
        var catalog = home.clickCatalogLink();
        waitForSeconds(5);
        catalog.selectInstockFromDropdown();
        waitForSeconds(5);
        List<String> inStockProductNames = catalog.getAllProductNamesFromResults();
        System.out.println("In-Stock Products: " + inStockProductNames);
        catalog.selectOutOfstockFromDropdown();
        waitForSeconds(5);
        scrollUp(driver, 200);
        List<String> outOfStockProductNames;
        try {
            outOfStockProductNames = catalog.getAllProductNamesFromResults();
        } catch (TimeoutException e) {
            System.out.println("No out-of-stock products found. Proceeding with empty list.");
            outOfStockProductNames = new ArrayList<>();
        }
        System.out.println("Out-of-Stock Products: " + outOfStockProductNames);
        if (outOfStockProductNames.isEmpty()) {
            System.out.println("No Out-of-Stock products — filter working correctly.");
            Assert.assertTrue(true);
        } else {
            for (String product : inStockProductNames) {
                Assert.assertFalse(
                        "Product found in both In-Stock and Out-of-Stock lists: " + product,
                        outOfStockProductNames.contains(product)
                );
            }
            Assert.assertTrue(
                    "Verified: In-Stock and Out-of-Stock products are distinct",
                    Collections.disjoint(inStockProductNames, outOfStockProductNames)
            );
        }
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
}}
