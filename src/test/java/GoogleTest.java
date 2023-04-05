import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
        WebDriver driver;
        @BeforeMethod
        public void setup() {
            driver = new ChromeDriver(new ChromeOptions());
        }

//        @Test
        public void searchOnGoogleTest() {
            driver.get("https://www.google.com/");
            driver.findElements(By.cssSelector(".QS5gu.sy4vM")).get(1).click();
            String keyword = "Banana";
            driver.findElement(By.cssSelector("input[name='q']")).sendKeys(keyword, Keys.ENTER);
        }

        @AfterMethod
        public void teardown() {
            driver.quit();
        }

}
