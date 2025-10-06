package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageBasicTests {


    private WebDriver driver;
    private WebDriverWait wait;


     @BeforeTest
     public void setup()
        {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://timecenter.vercel.app/");
        }


     @Test
     public void clickCatalogPage(){
         HomePage home = new HomePage(driver);
         var catalog = home.clickCatalogLink();
     }

    @Test
    public void clickMenPage(){
        HomePage home = new HomePage(driver);
        var men = home.clickMenLink();
    }

    @Test
    public void clickWomenPage(){
        HomePage home = new HomePage(driver);
        var men = home.clickWomenLink();
    }

    @Test
    public void clickBestSellersPage(){
        HomePage home = new HomePage(driver);
        var men = home.clickBestSellersLink();
    }

    @Test
    public void clickContactPage(){
        HomePage home = new HomePage(driver);
        var men = home.clickContactLink();
    }

    @Test
    public void clickWatchCatalogBtn(){
        HomePage home = new HomePage(driver);
        var catalogBtn = home.clickWatchCatalogButton();
    }

    @Test
    public void clickExploreBtn(){
         HomePage home = new HomePage(driver);
         var exploreBtn = home.clickExploreCollectionButton();
    }

    @Test
    public void clickHomeLnk(){
         HomePage home = new HomePage(driver);
         home.clickHomeLnk();
    }




    @AfterTest
    public void quit(){
        driver.quit();
     }
}
