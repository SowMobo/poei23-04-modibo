import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.ProductPage;
import PageObjects.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonSearchProductTest {
    WebDriver driver;
    HomePage home;
    SearchResultPage searchResultPage;
    ProductPage productPage;
    CartPage cartPage;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        home = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

        /**
         * Acceder au site "amazon.fr"
         */
        String sutUrl = "https://amazon.fr";
        driver.get(sutUrl);

        /**
         * Accepter les cookies
         */
        driver.findElement(By.cssSelector("input#sp-cc-accept")).click();
    }

    @Test
    public void searchProductTest() {
        /**
         * Search iphone 13
         */
        home.search("iphone 13");
        searchResultPage.getProduct(0);
        Assert.assertEquals(productPage.getTitle(),"Apple iPhone 13 (128 Go) - Vert",
                "the product title is not correct");
        String price = productPage.getPrice().replace('\n', '.');
        Assert.assertEquals(price, "799.00€", "The price has changed");
        productPage.addToCart();
        productPage.notAcceptInsurance();
        cartPage.openCart();
        Assert.assertEquals(cartPage.getProductTitle(0), "Apple iPhone 13 (128 Go) - Vert",
                "The product you added is not that ou are ordering");
    }


    @AfterTest
    public void teardown() {
        driver.quit();
    }
}