package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static extensions.UiElementsExtension.performClick;
import static extensions.UiElementsExtension.performEnterText;

public class SearchFieldPopUpPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchFieldPopUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    }

    @FindBy(xpath = "//input[@placeholder='Search products...']")
    private WebElement searchField;

    @FindBy(xpath = "//div[contains(text(),'No products found')]")
    private WebElement noProductFoundMsg;

    @FindBy(xpath = "//div[contains(text(),'No suggestions found')]")
    private WebElement noSuggestionsFoundMsg;

    @FindBy(xpath = "//div[@class='jsx-48e1aa9aa03351c7 p-4 text-gray-400']")
    private WebElement startTypingForSuggestion;

    @FindBy(xpath = "//a[@class='jsx-48e1aa9aa03351c7 flex items-center p-4 hover:bg-gray-700/50 text-white transition-all duration-200 rounded-lg hover:shadow-md']//img[@alt='Tissot Model 561']")
    private WebElement productResult;

    private WebElement searchKeyword;


    public SearchFieldPopUpPage clickSearchField() {
        performClick(searchField);
        return this;
    }

    public SearchFieldPopUpPage enterInvalidTextInSearchField() {
        performEnterText(searchField, "@/.]-=>");
        wait.until(ExpectedConditions.visibilityOf((noProductFoundMsg)));
        Assert.assertTrue("Results are found", (noProductFoundMsg.isDisplayed()));
        Assert.assertTrue("Suggestions are found", (noSuggestionsFoundMsg.isDisplayed()));
        return this;
    }

    public SearchFieldPopUpPage enterValidTextInSearchField() {
        String keyword = "Tissot Model 561";
        performEnterText(searchField, keyword);
        wait.until(ExpectedConditions.visibilityOf(productResult));
        Assert.assertTrue(
                "Expected product result for '" + keyword + "' is not visible.",
                productResult.isDisplayed()
        );
        return this;
    }

    public SearchFieldPopUpPage enterEmptySearchField() {
        String keyword = "";
        performEnterText(searchField, keyword);
        wait.withTimeout(Duration.ofSeconds(10));
        Assert.assertTrue(
                "Search results should not appear for an empty search.",
                startTypingForSuggestion.isDisplayed());
        return this;
    }

    public AddToCartPage searchProduct(){
        String keyword = "Tissot";
        performEnterText(searchField,keyword);
        wait.until(ExpectedConditions.visibilityOf(productResult));
        performClick(productResult);
        return new AddToCartPage(driver);
    }

}
