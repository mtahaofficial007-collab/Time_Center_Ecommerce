package test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.HomePage;
import extensions.UiElementsExtension.*;
import pages.SearchFieldPopUpPage;

import static extensions.UiElementsExtension.waitForSeconds;

public class AddToCartTests {

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
    public void addSingleProduct() {
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
    public void addSingleProductDirect() {
        HomePage home = new HomePage(driver);
        var searchField = home.clickSearchIcon();
        searchField.clickSearchField();
        var addToCart = searchField.searchProduct();
        waitForSeconds(5);
        addToCart.clickBuyNowBtn();
        waitForSeconds(5);
    }

    @Test
    public void increaseProductQuantityInCart() {
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
    public void decreaseProductQuantityInCart() {
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
    public void deleteProductInCart() {
        HomePage home = new HomePage(driver);
        var searchField = home.clickSearchIcon();
        searchField.clickSearchField();
        var addToCart = searchField.searchProduct();
        waitForSeconds(5);
        addToCart.clickAddToCartBtn();
        waitForSeconds(3);
        addToCart.clickDeleteIcon();
        waitForSeconds(3);
        String message = "Your cart is empty";
        Assert.assertEquals("Your cart is empty",message);
    }

    @Test
    public void continueShoppingAfterAddingProduct() {
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

    @Test
    public void verifyProductDetailsAfterAddToCart() {
        HomePage home = new HomePage(driver);
        var searchField = home.clickSearchIcon();
        searchField.clickSearchField();
        var addToCart = searchField.searchProduct();
        waitForSeconds(5);
        addToCart.clickAddToCartBtn();
        waitForSeconds(3);
        String productName = addToCart.getProductName();
        int cartCount = addToCart.getCartItemCount();
        System.out.println("Product Added: " + productName);
        System.out.println("Cart Count: " + cartCount);
        Assert.assertTrue("Incorrect product name in cart!", productName.contains("Tissot"));
        Assert.assertTrue("Cart count should be greater than zero!", cartCount > 0);
    }

    @Test
    public void verifyCartCountRemainsSameAfterRefresh() {
        HomePage home = new HomePage(driver);
        var searchField = home.clickSearchIcon();
        searchField.clickSearchField();
        var addToCart = searchField.searchProduct();
        waitForSeconds(5);
        addToCart.clickPlusIcon();
        addToCart.clickAddToCartBtn();
        waitForSeconds(3);
        int initialCartCount = addToCart.getCartItemCount();
        System.out.println("Initial Cart Count: " + initialCartCount);
        waitForSeconds(3);
        driver.navigate().refresh();
        waitForSeconds(5);
        int refreshedCartCount = addToCart.getCartItemCount();
        System.out.println("Cart Count After Refresh: " + refreshedCartCount);
        Assert.assertEquals("Cart count changed after refreshing the page!", refreshedCartCount, initialCartCount);
        System.out.println("Cart count remains the same after page refresh.");
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }}

}
