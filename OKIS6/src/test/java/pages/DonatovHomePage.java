package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DonatovHomePage {

    private WebDriver driver;

    private By supportLink = By.cssSelector("a[href*='support']");
    private By reviewsLink = By.xpath("//a[contains(text(),'Отзывы')]");
    private By header = By.tagName("h1");

    public DonatovHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://donatov.net/");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void openSupport() {
        driver.findElement(supportLink).click();
    }

    public void openReviews() {
        driver.findElement(reviewsLink).click();
    }

    public boolean isHeaderDisplayed() {
        return driver.findElement(header).isDisplayed();
    }
}