package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage {

    private WebDriver driver;

    private By searchInput = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");
    private By cartButton = By.id("nav-cart");
    private By logo = By.id("nav-logo-sprites");
    private By dealsLink = By.cssSelector("a[href*='deals']");

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.amazon.com/");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void search(String text) {
        driver.findElement(searchInput).sendKeys(text);
        driver.findElement(searchButton).click();
    }

    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public void openCart() {
        driver.findElement(cartButton).click();
    }

    public void openDeals() {
        driver.findElement(dealsLink).click();
    }
}