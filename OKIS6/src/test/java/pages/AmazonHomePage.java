package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonHomePage {

    private WebDriverWait wait;
    private WebDriver driver;

    private By searchInput = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");
    private By cartButton = By.id("nav-cart");
    private By logo = By.id("nav-logo-sprites");
    private By dealsLink = By.cssSelector("a[href*='deals']");

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://www.amazon.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void search(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).clear();
        driver.findElement(searchInput).sendKeys(text);
        driver.findElement(searchButton).click();
    }

    public boolean isLogoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
    }

    public void openDeals() {
        wait.until(ExpectedConditions.elementToBeClickable(dealsLink)).click();
    }
}