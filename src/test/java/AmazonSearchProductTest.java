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
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @Test
    public void searchProductTest() {
        /**
         * Search iphone 13
         */
        HomePage home = new HomePage(driver);
        ProductPage productPage = home.closeCookiesPopup()
                        .search("iphone 13")
                                .getProduct(0);

        Assert.assertEquals(productPage.getTitle(),"Apple iPhone 13 (128 Go) - Vert",
                "the product title is not correct");
        String price = productPage.getPrice();
        Assert.assertEquals(price, "799.00€", "The price has changed");

        CartPage cartPage = productPage.addToCart()
                .addToCart()//.notAcceptInsurance()
                .openCart();

        Assert.assertEquals(cartPage.getProductTitle(0), "Apple iPhone 13 (128 Go) - Vert",
                "The product you added is not that ou are ordering");
    }

    @Test
    public void loginTest() {
        HomePage home = new HomePage(driver);
        home.closeCookiesPopup().login();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}