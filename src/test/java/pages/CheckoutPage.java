package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static extensions.UiElementsExtension.*;

import java.time.Duration;
import java.util.logging.XMLFormatter;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //Locators of CheckoutPage
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='emailUpdates']")
    private WebElement emailUpdatesCheckBoxBtn;

    @FindBy(xpath = "//input[@placeholder='Enter first name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Enter last name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@placeholder='Enter your address']")
    private WebElement addressField;

    @FindBy(xpath = "//input[@placeholder='Enter your city']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@placeholder='Enter postal code']")
    private WebElement postalCodeField;

    @FindBy(xpath = "//input[@placeholder='Enter your phone number']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//input[@name='saveInfo']")
    private WebElement saveInfoForNextOrderCheckBoxBtn;

    @FindBy(xpath = "//input[@value='cod']")
    private WebElement cashOnDeliveryBtn;

    @FindBy(xpath = "//input[@value='bank']")
    private WebElement bankDepositBtn;

    @FindBy(xpath = "//div[@class='space-y-3']//label[1]//input[1]")
    private WebElement sameShippingAddressBtn;

    @FindBy(xpath = "//label[2]//input[1]")
    private WebElement differentShippingAddressBtn;

    @FindBy(xpath = "//button[normalize-space()='Complete Order']")
    private WebElement completeOrderBtn;

    //Methods for Checkout Page
    public CheckoutPage enterEmail(){
        performEnterText(emailField,"m.tahak007@gmail.com");
        return new CheckoutPage(driver);
    }

    public CheckoutPage clickUpdateBtn(){
        performClick(emailUpdatesCheckBoxBtn);
        return new CheckoutPage(driver);
    }

    public CheckoutPage enterName(){
        performEnterText(firstNameField,"Muhammad Taha");
        performEnterText(lastNameField,"Khurram");
        return new CheckoutPage(driver);
    }

    public CheckoutPage enterAddress(){
        performEnterText(addressField,"House no 17/2 Canal Park, Canal Road");
        return new CheckoutPage(driver);
    }

    public CheckoutPage enterCity(){
        performEnterText(cityField,"Faisalabad");
        return new CheckoutPage(driver);
    }

    public CheckoutPage enterPostalCode(){
        performEnterText(postalCodeField,"38000");
        return new CheckoutPage(driver);
    }

    public CheckoutPage enterPhoneNumber(){
        performEnterText(phoneNumberField,"03317904180");
        return new CheckoutPage(driver);
    }

    public CheckoutPage uncheckSameAddressBtn(){
        performClick(sameShippingAddressBtn);
        return new CheckoutPage(driver);
    }

    public CheckoutPage clickCodBtn(){
        performClick(cashOnDeliveryBtn);
        return new CheckoutPage(driver);
    }

    public void clickBankDepositBtnSafely() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", bankDepositBtn);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(bankDepositBtn));
        wait.until(ExpectedConditions.elementToBeClickable(bankDepositBtn));
        try {
            bankDepositBtn.click();
        } catch (ElementClickInterceptedException e) {
            // Fallback to JS click if intercepted
            js.executeScript("arguments[0].click();", bankDepositBtn);
        }
        System.out.println("Bank Deposit button clicked safely.");
    }

    public CheckoutPage clickDiffShippingAddressBtn(){
        performClick(differentShippingAddressBtn);
        return new CheckoutPage(driver);
    }

    public CheckoutPage clickSameShippingAddressBtn(){
        performClick(sameShippingAddressBtn);
        return new CheckoutPage(driver);
    }

    public void clickCompleteOrderBtnSafely() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", completeOrderBtn);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(completeOrderBtn));
        wait.until(ExpectedConditions.elementToBeClickable(completeOrderBtn));
        try {
            completeOrderBtn.click();
        } catch (ElementClickInterceptedException e) {
            // Fallback to JS click if intercepted
            js.executeScript("arguments[0].click();", completeOrderBtn);
        }
        System.out.println("Complete Order button clicked safely.");
    }


}






