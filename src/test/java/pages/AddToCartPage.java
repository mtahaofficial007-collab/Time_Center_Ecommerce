package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import extensions.UiElementsExtension.*;

import java.time.Duration;
import java.util.logging.XMLFormatter;

import static extensions.UiElementsExtension.performClick;

public class AddToCartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //Add to Cart Page Locators

    @FindBy(xpath = "//div[@class='jsx-e0f0adb119c57f1c flex items-center gap-4']//button[2]//*[name()='svg']")
    private WebElement plusQuantityIcon;

    @FindBy(xpath = "//div[@class='jsx-e0f0adb119c57f1c flex items-center gap-4']//button[1]//*[name()='svg']")
    private WebElement minusQuantityIcon;

    @FindBy(xpath = "//body/div[@class='jsx-e0f0adb119c57f1c min-h-screen bg-product-hero mt-10']/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]//*[name()='svg']")
    private WebElement deleteIcon;

    @FindBy(xpath = "//button[@class='jsx-e0f0adb119c57f1c w-full py-3 bg-primary text-primary-foreground rounded-lg font-semibold hover:bg-primary/90 transition-all duration-300 disabled:opacity-50 text-sm flex items-center justify-center gap-2']")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//button[@class='jsx-e0f0adb119c57f1c w-full py-3 bg-card border-2 border-primary text-primary rounded-lg font-semibold hover:bg-muted transition-all duration-300 disabled:opacity-50 text-sm']")
    private WebElement buyNowBtn;

    @FindBy(xpath = "//div[@class='jsx-e0f0adb119c57f1c min-h-screen bg-product-hero mt-10']//div[2]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//button[2]//*[name()='svg']")
    private WebElement cartPlusQuantityIcon;

    @FindBy(xpath = "//div[@class='jsx-e0f0adb119c57f1c min-h-screen bg-product-hero mt-10']//div[2]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//button[1]//*[name()='svg']//*[name()='path' and contains(@d,'M5 12h14')]")
    private WebElement cartMinusQuantityIcon;

    @FindBy(xpath = "//body/div[@class='jsx-e0f0adb119c57f1c min-h-screen bg-product-hero mt-10']/div[2]/div[2]/div[2]/div[2]/button[1]")
    private WebElement productCheckoutBtn;

    @FindBy(xpath = "//body/div[@class='jsx-e0f0adb119c57f1c min-h-screen bg-product-hero mt-10']/div[2]/div[2]/div[2]/div[2]/button[2]")
    private WebElement continueShoppingBtn;

    //Add To Cart Page Methods

    public AddToCartPage clickPlusIcon(){
        performClick(plusQuantityIcon);
        return this;
    }

    public AddToCartPage clickMinusIcon(){
        performClick(minusQuantityIcon);
        return this;
    }

    public AddToCartPage clickDeleteIcon(){
        performClick(deleteIcon);
        return this;
    }

    public AddToCartPage clickAddToCartBtn(){
        performClick(addToCartBtn);
        return this;
    }

    public CheckoutPage clickCheckoutBtn(){
        performClick(productCheckoutBtn);
        return new CheckoutPage(driver);
    }

    public CheckoutPage clickBuyNowBtn(){
        performClick(buyNowBtn);
        return new CheckoutPage(driver);
    }

    public AddToCartPage clickContinueShoppingBtn(){
        performClick(continueShoppingBtn);
        return new AddToCartPage(driver);
    }








}
