package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.HomePage;

public class SearchFieldTest {

    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeMethod
    public void setup()
    {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://timecenter.vercel.app/");
    }

    @Test
    public void invalidSearchTest(){
        HomePage home = new HomePage(driver);
        home.clickSearchIcon();
        home.clickSearchField();
        home.enterInvalidTextInSearchField();
    }

    @Test
    public void validSearchTest(){
       HomePage home = new HomePage(driver);
       home.clickSearchIcon();
       home.clickSearchField();
       home.enterValidTextInSearchField();
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }


}
