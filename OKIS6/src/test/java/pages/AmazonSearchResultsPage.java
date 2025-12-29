package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonSearchResultsPage {

    private WebDriver driver;

    private By results = By.cssSelector("div.s-main-slot div[data-component-type='s-search-result']");
    private By firstItem = By.cssSelector("div.s-main-slot div[data-component-type='s-search-result'] h2 a");

    public AmazonSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean hasResults() {
        return driver.findElements(results).size() > 0;
    }

    public void openFirstItem() {
        driver.findElement(firstItem).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}