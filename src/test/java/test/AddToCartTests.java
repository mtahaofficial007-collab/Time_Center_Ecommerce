package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import extensions.UiElementsExtension.*;
import static extensions.UiElementsExtension.waitForSeconds;

public class AddToCartTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://timecenter.vercel.app/");
    }

    @Test
    public void addSingleProduct(){
        HomePage home = new HomePage(driver);
        var searchField = home.clickSearchIcon();
        searchField.clickSearchField();
        var addToCart = searchField.searchProduct();
        waitForSeconds(5);
        addToCart.clickAddToCartBtn();
        waitForSeconds(5);
        addToCart.clickCheckoutBtn();
        waitForSeconds(5);
    }

    @Test
    public void addSingleProductDirect(){
        HomePage home = new HomePage(driver);
        var searchField = home.clickSearchIcon();
        searchField.clickSearchField();
        var addToCart = searchField.searchProduct();
        waitForSeconds(5);
        addToCart.clickBuyNowBtn();
        waitForSeconds(5);
    }

    @Test
    public void increaseProductQuantityInCart(){
        HomePage home = new HomePage(driver);
        var searchField = home.clickSearchIcon();
        searchField.clickSearchField();
        var addToCart = searchField.searchProduct();
        waitForSeconds(5);
        addToCart.clickPlusIcon();
        addToCart.clickAddToCartBtn();
        waitForSeconds(3);
    }

    @Test
    public void decreaseProductQuantityInCart(){
        HomePage home = new HomePage(driver);
        var searchField = home.clickSearchIcon();
        searchField.clickSearchField();
        var addToCart = searchField.searchProduct();
        waitForSeconds(5);
        addToCart.clickPlusIcon();
        waitForSeconds(3);
        addToCart.clickMinusIcon();
        waitForSeconds(3);
    }

    @Test
    public void deleteProductInCart(){
        HomePage home = new HomePage(driver);
        var searchField = home.clickSearchIcon();
        searchField.clickSearchField();
        var addToCart = searchField.searchProduct();
        waitForSeconds(5);
        addToCart.clickAddToCartBtn();
        waitForSeconds(3);
        addToCart.clickDeleteIcon();
        waitForSeconds(3);
    }

    @Test
    public void continueShoppingAfterAddingProduct(){
        HomePage home = new HomePage(driver);
        var searchField = home.clickSearchIcon();
        searchField.clickSearchField();
        var addToCart = searchField.searchProduct();
        waitForSeconds(5);
        addToCart.clickAddToCartBtn();
        waitForSeconds(5);
        addToCart.clickContinueShoppingBtn();
        waitForSeconds(5);
    }


    @AfterMethod
    public void quit() {
        driver.quit();
    }

}
