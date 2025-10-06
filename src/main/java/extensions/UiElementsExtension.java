package extensions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UiElementsExtension {

    public static void performClick(WebElement locator){
        locator.click();
    }

    public static void performEnterText(WebElement locator, String value){
        locator.sendKeys(value);
    }

    public static void performDropDownSelectByText(WebElement locator,String dropDownText){
        Select select = new Select(locator);
        select.selectByVisibleText(dropDownText);
    }

    public static void performDropDownSelectByIndex(WebElement locator, int dropDownIndex){
        Select select = new Select(locator);
        select.selectByIndex(dropDownIndex);
    }

    public static void performDropDownSelectByValue(WebElement locator, String dropDownValue){
        Select select = new Select(locator);
        select.selectByValue(dropDownValue);
    }
}
