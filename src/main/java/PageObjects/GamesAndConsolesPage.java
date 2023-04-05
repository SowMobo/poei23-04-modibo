package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GamesAndConsolesPage {
    static final int TIMEOUT = 5; // 2 seconds
    WebDriver driver;
    WebDriverWait wait;
    //locators
    By topSellProduct = By.cssSelector(".apb-browse-col-pad-left > div:nth-child(9) li");
    public GamesAndConsolesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }
//    public String getTitle(int index) {
//        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//                topSellProduct)).get(index).getAttribute("title");
//    }
    public ProductPage openBestSeller(int index) {
        /**
         * Open the best sell product
         */
       wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                topSellProduct)).get(index).click();
       return new ProductPage(driver);
    }
}
