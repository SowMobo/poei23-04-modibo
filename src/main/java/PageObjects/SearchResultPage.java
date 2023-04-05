package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPage {

    static final int TIMEOUT = 5; // 2 seconds
    WebDriver driver;
    WebDriverWait wait;
    By productList = By.cssSelector(".a-section.aok-relative.s-image-square-aspect");
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public ProductPage getProduct(int index) {
       wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productList)).get(index).click();
       return new ProductPage(driver);
    }
}
