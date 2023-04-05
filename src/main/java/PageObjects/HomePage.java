package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    // Class variables
    static final int TIMEOUT = 5; // 2 seconds
    static String sutUrl = "https://amazon.fr";
    // locators
    By accepTCookiesButton = By.cssSelector("input#sp-cc-accept");
    By searchBarLocator = By.cssSelector("input#twotabsearchtextbox");
    By tousMenusButton = By.cssSelector("#nav-hamburger-menu");
    By jeuVideoAndConsolesButton = By.cssSelector(".hmenu.hmenu-visible li");
    By tousJeuxVideoButton = By.cssSelector("ul.hmenu.hmenu-visible li:nth-child(3)");
    By comptesAndListButtonBy = By.cssSelector("#nav-link-accountList");
    By identifyButton = By.cssSelector("#nav-flyout-ya-signin");
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        /**
         * Acceder au site "amazon.fr"
         */
        driver.get(sutUrl);
    }
    public HomePage closeCookiesPopup() {
        /**
         * Accepter les cookies
         */
        driver.findElement(accepTCookiesButton).click();
        return this;
    }

    public SearchResultPage search(String keyword) {
        driver.findElement(searchBarLocator).sendKeys(keyword + Keys.ENTER);
        return new SearchResultPage(driver);
    }

    /**
     * click Toutes,
     * click Jeu video et
     * click tous les jeux video
     */
    public GamesAndConsolesPage goToGamesAndConsolesPage() {
        /**
         * Open tous les menus
         */
        driver.findElement(tousMenusButton).click();
        /**
         * Select Jeux video et consoles
         * locator = ".hmenu-item[data-menu-id='12'] div"
         */
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(jeuVideoAndConsolesButton)).get(18).click();
        /**
         * - Select Tous les jeux video
         * locator = .hmenu.hmenu-visible > li
         */
        wait.until(ExpectedConditions.textToBePresentInElementLocated(tousJeuxVideoButton, "Tous les jeux vidéo"));
        wait.until(ExpectedConditions.elementToBeClickable(tousJeuxVideoButton)).click();
        return new GamesAndConsolesPage(driver);

    }
    public void login() {
        Actions actions = new Actions(driver);

        WebElement buttonAccount = driver.findElement(comptesAndListButtonBy);
        actions.moveToElement(buttonAccount);
        actions.perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(identifyButton)).click();
    }
}
