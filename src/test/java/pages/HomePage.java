package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static extensions.UiElementsExtension.performClick;
import static extensions.UiElementsExtension.performEnterText;


public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    //Locators of Home Page

    @FindBy(linkText = "Home")
    private WebElement homePage;

    @FindBy(linkText = "Catalog")
    private WebElement catalogPage;

    @FindBy(linkText = "Men")
    private WebElement menPage;

    @FindBy(linkText = "Women")
    private WebElement womenPage;

    @FindBy(linkText = "Best Sellers")
    private WebElement bestSellersPage;

    @FindBy(linkText = "Contact")
    private WebElement contactPage;

    @FindBy(xpath = "//button[@aria-label='Explore our luxury watch collection']")
    private WebElement exploreCollectionButton;

    @FindBy(xpath = "//button[@aria-label='View our watch catalog']")
    private WebElement watchCatalogButton;

    @FindBy(xpath = "//button[@aria-label='Search']//*[name()='svg']")
    private WebElement searchIcon;

    @FindBy(xpath = "//button[@aria-label='Shopping cart']//*[name()='svg']")
    private WebElement addToCartIcon;


    //Home Page Methods

    public SearchFieldPopUpPage clickSearchIcon() {
        performClick(searchIcon);
        return new SearchFieldPopUpPage(driver);
    }

    public CatalogPage clickCatalogLink() {
        performClick(catalogPage);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Page didn't redirected to the URL, Actual URL: " +
                currentUrl, (currentUrl.equals("https://timecenter.vercel.app/catalog")));
        return new CatalogPage(driver);
    }

    public MenPage clickMenLink() {
        performClick(menPage);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Page didn't redirected to the URL, Actual URL: " +
                currentUrl, (currentUrl.equals("https://timecenter.vercel.app/men")));
        return new MenPage(driver);
    }

    public WomenPage clickWomenLink() {
        performClick(womenPage);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Page didn't redirected to the URL, Actual URL: " +
                currentUrl, (currentUrl.equals("https://timecenter.vercel.app/women")));
        return new WomenPage(driver);
    }

    public BestSellerPage clickBestSellersLink() {
        performClick(bestSellersPage);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Page didn't redirected to the URL, Actual URL: " +
                currentUrl, (currentUrl.equals("https://timecenter.vercel.app/best-sellers")));
        return new BestSellerPage(driver);
    }


    public ContactPage clickContactLink() {
        performClick(contactPage);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Page didn't redirected to the URL, Actual URL: " +
                currentUrl, (currentUrl.equals("https://timecenter.vercel.app/contact")));
        return new ContactPage(driver);
    }


    public CatalogPage clickWatchCatalogButton() {
        performClick(watchCatalogButton);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='text-xl md:text-2xl text-slate-200 max-w-2xl mx-auto text-pretty']")));
        Assert.assertTrue("Catalog page did not load correctly — expected element is not visible.",
                element.isDisplayed());
        return new CatalogPage(driver);
    }

    public CollectionsPage clickExploreCollectionButton() {
        performClick(exploreCollectionButton);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='text-4xl md:text-5xl font-bold text-gray-900 mb-12 text-center font-serif tracking-tight']")));
        Assert.assertTrue("Catalog page did not load correctly — expected element is not visible.",
                element.isDisplayed());
        return new CollectionsPage(driver);
    }

    public HomePage clickHomeLnk() {
        performClick(homePage);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Page didn't redirected to the URL, Actual URL: " +
                currentUrl, (currentUrl.equals("https://timecenter.vercel.app/")));
        return new HomePage(driver);
    }
    
}





