import PageObjects.GamesAndConsolesPage;
import PageObjects.HomePage;
import PageObjects.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonBestGamesAndConsolesSearchTest {
    WebDriver driver;
    HomePage homePage;
    GamesAndConsolesPage gamesAndConsolesPage;
    ProductPage productPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        /**
         * Acceder au site "amazon.fr"
         */
        String sutUrl = "https://amazon.fr";
        driver.get(sutUrl);
        homePage = new HomePage(driver);
        gamesAndConsolesPage = new GamesAndConsolesPage(driver);
        productPage = new ProductPage(driver);

        /**
         * Accepter les cookies
         */
        driver.findElement(By.cssSelector("input#sp-cc-accept")).click();
    }

//    @Test
    public void bestGamesAndConsolesSellTest(){
        homePage.goToGamesAndConsolesPage();
        gamesAndConsolesPage.openBestSeller(0);
        Assert.assertEquals(productPage.getTitle(),
                "The Legend of Zelda : Tears of the Kingdom",
                "the product title is not correct");
        String price = productPage.getPrice().replace('\n', '.');
        Assert.assertEquals(price, "54.99€", "The price has changed");
        Assert.assertEquals(productPage.getAvailableDate(),
                "Cet article paraîtra le 12 mai 2023.\n" +
                        "Précommandez dès aujourd’hui.",
                "The available date has changed");
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
