package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    static final int TIMEOUT = 10; // 2 seconds
    WebDriver driver;
    WebDriverWait wait;
    By ordersTitle = By.cssSelector(".a-truncate-cut");
    By cartItemsBy = By.cssSelector("");
    By cartButton = By.cssSelector("input[class='a-button-input']" +
            "[aria-labelledby='attach-sidesheet-view-cart-button-announce']");
    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
    }
    public  String getProductTitle(int index) {
//        WebElement cardItem = driver.findElements(cartItemsBy).get(index);
//        return cardItem.findElement(ordersTitle).getText();
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ordersTitle)).get(index).getText();
    }
}
