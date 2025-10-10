package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import static extensions.UiElementsExtension.*;

public class CheckOutTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://timecenter.vercel.app/");
    }

    @Test
    public void completeCheckout(){
        HomePage home = new HomePage(driver);
        var searchField = home.clickSearchIcon();
        searchField.clickSearchField();
        var addToCart = searchField.searchProduct();
        waitForSeconds(3);
        addToCart.clickAddToCartBtn();
        waitForSeconds(3);
        var checkout = addToCart.clickCheckoutBtn();
        waitForSeconds(3);
        checkout.enterEmail();
        checkout.clickUpdateBtn();
        checkout.enterName();
        checkout.enterAddress();
        checkout.enterCity();
        checkout.enterPostalCode();
        checkout.enterPhoneNumber();
        waitForSeconds(3);
        scrollDown(driver,500);
        checkout.clickCompleteOrderBtnSafely();
        waitForSeconds(5);

    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }}
