package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static extensions.UiElementsExtension.*;

import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatalogPage {

    private WebDriver driver;
    private WebDriverWait wait;


    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    //Locators of Catalog Page

    @FindBy(xpath = "//select[@aria-label='Filter by availability']")
    private WebElement availabilityDropDown;

    @FindBy(xpath = "//select[@aria-label='Filter by price range']")
    private WebElement priceDropDown;

    @FindBy(xpath = "//select[@aria-label='Sort products']")
    private WebElement sortDropDown;

    @FindBy(xpath = "//div[contains(@class,'grid') and contains(@class,'gap-6')]")
    private WebElement resultsContainer;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div[3]/div[1]/a/div[2]")
    private List<WebElement> productNameElements;

    //Method of Catalog Page

    public CatalogPage selectInstockFromDropdown(){
        performDropDownSelectByValue(availabilityDropDown,"in-stock");
        return new CatalogPage(driver);
    }

    public CatalogPage selectOutOfstockFromDropdown(){
        performDropDownSelectByValue(availabilityDropDown,"out-of-stock");
        return new CatalogPage(driver);
    }

    public CatalogPage selectUnderFiftyFromDropDown(){
        performDropDownSelectByValue(priceDropDown,"under-5000");
        return new CatalogPage(driver);
    }

    public CatalogPage selectBetweenFiftyAndSeventyFromDropDown(){
        performDropDownSelectByValue(priceDropDown,"5000-7000");
        return new CatalogPage(driver);
    }

    public CatalogPage selectSortByIndex0(){
      performDropDownSelectByIndex(sortDropDown,0);
      return new CatalogPage(driver);
    }

    public CatalogPage selectSortByIndex1(){
        performDropDownSelectByIndex(sortDropDown,1);
        return new CatalogPage(driver);
    }

    public CatalogPage selectSortByIndex2(){
        performDropDownSelectByIndex(sortDropDown,2);
        return new CatalogPage(driver);
    }

    public CatalogPage selectSortByIndex3(){
        performDropDownSelectByIndex(sortDropDown,3);
        return new CatalogPage(driver);
    }

    public CatalogPage selectSortByIndex4(){
        performDropDownSelectByIndex(sortDropDown,4);
        return new CatalogPage(driver);
    }


    public CatalogPage selectSortByIndex5(){
        performDropDownSelectByIndex(sortDropDown,5);
        return new CatalogPage(driver);
    }

    public CatalogPage selectSortByIndex6(){
        performDropDownSelectByIndex(sortDropDown,6);
        return new CatalogPage(driver);
    }

    public CatalogPage selectSortByIndex7(){
        performDropDownSelectByIndex(sortDropDown,7);
        return new CatalogPage(driver);
    }

    public String getResultsContainerText() {
        return resultsContainer.getText();
    }

    public List<Integer> extractPricesFromResults(String text) {
        List<Integer> prices = new ArrayList<>();
        Pattern pattern = Pattern.compile("Rs\\s?(\\d{1,3}(?:,\\d{3})*)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String priceText = matcher.group(1).replace(",", "");
            prices.add(Integer.parseInt(priceText));
        }
        return prices;
    }

    public List<String> getProductNames() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElements(productNameElements));

        List<String> names = new ArrayList<>();
        for (WebElement element : productNameElements) {
            names.add(element.getText().trim());
        }
        return names;
    }

    public void waitForResultsToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for the results container to refresh
        wait.until(ExpectedConditions.visibilityOf(resultsContainer));
        List<WebElement> productElements = driver.findElements(By.cssSelector(".product-name"));
        if (!productElements.isEmpty()) {
            wait.until(ExpectedConditions.visibilityOfAllElements(productElements));
        }
    }

    public List<String> getAllProductNamesFromResults() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(resultsContainer));
        List<WebElement> productCards = resultsContainer.findElements(By.xpath(".//div[contains(@class,'watch-card')]"));
        List<String> productNames = new ArrayList<>();
        for (WebElement card : productCards) {
            try {
                WebElement nameElement = card.findElement(By.xpath(".//h3"));
                String name = nameElement.getText().trim();
                if (!name.isEmpty()) {
                    productNames.add(name);
                }
            } catch (NoSuchElementException ignored) {}
        }
        System.out.println("Fetched Products: " + productNames);
        return productNames;
    }


}
