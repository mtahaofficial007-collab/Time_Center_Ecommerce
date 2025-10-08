package extensions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UiElementsExtension {

    public static void performClick(WebElement locator) {
        locator.click();
    }

    public static void performEnterText(WebElement locator, String value) {
        locator.sendKeys(value);
    }

    public static void performDropDownSelectByText(WebElement locator, String dropDownText) {
        Select select = new Select(locator);
        select.selectByVisibleText(dropDownText);
    }

    public static void performDropDownSelectByIndex(WebElement locator, int dropDownIndex) {
        Select select = new Select(locator);
        select.selectByIndex(dropDownIndex);
    }

    public static void performDropDownSelectByValue(WebElement locator, String dropDownValue) {
        Select select = new Select(locator);
        select.selectByValue(dropDownValue);
    }

    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }


}
