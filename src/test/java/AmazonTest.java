import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonTest {
    static final int TIMEOUT = 5;
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    @Test

    public void amazonTest(){
        /**
         * Acceder au site "amazon.fr"
         */
        String sutUrl = "https://amazon.fr";
        driver.get(sutUrl);

        /**
         * Accepter les cookies
         */
        driver.findElement(By.cssSelector("input#sp-cc-accept")).click();
        /**
         * Open tous les menus
         */
        driver.findElement((By.cssSelector("#nav-hamburger-menu"))).click();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}