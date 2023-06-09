package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    static final int TIMEOUT = 10; // 2 seconds
    WebDriver driver;
    WebDriverWait wait;
    By productTitle = By.cssSelector("#productTitle");
    By priceText = By.cssSelector(".priceToPay");
    By availabilityDate = By.cssSelector("#availability");
    By addToCartButton = By.cssSelector("input#add-to-cart-button");
    By nonMerciButton = By.cssSelector("input[class='a-button-input']" +
            "[aria-labelledby='attachSiNoCoverage-announce']");
    By openCartButton = By.cssSelector("input[class='a-button-input']" +
            "[aria-labelledby='attach-sidesheet-view-cart-button-announce']");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public String getTitle() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(productTitle)).getText();
    }
    public  String getPrice() {
        return driver.findElement(priceText).getText().replace('\n', '.');
    }
    public String getAvailableDate() {
        return driver.findElement(availabilityDate).getText();
    }
    public ProductPage addToCart() {
            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
            return this;
    }
    public ProductPage notAcceptInsurance() {
        wait.until(ExpectedConditions.elementToBeClickable(nonMerciButton)).click();
        return this;
    }

    public  CartPage openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(openCartButton)).click();
        return new CartPage(driver);
    }
}
