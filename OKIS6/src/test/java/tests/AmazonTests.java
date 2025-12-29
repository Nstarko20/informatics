package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import pages.AmazonSearchResultsPage;

public class AmazonTests {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(groups = {"positive"})
    public void testAmazonTitle() {
        AmazonHomePage home = new AmazonHomePage(driver);
        String title;

        home.open();
        title = home.getTitle();

        Assert.assertTrue(title.contains("Amazon"));
    }

    @Test(groups = {"positive"})
    public void testSearchProduct() {
        AmazonHomePage home = new AmazonHomePage(driver);
        AmazonSearchResultsPage results = new AmazonSearchResultsPage(driver);

        home.open();
        home.search("laptop");

        Assert.assertTrue(results.hasResults());
    }

    @Test(groups = {"positive"})
    public void testLogoDisplayed() {
        AmazonHomePage home = new AmazonHomePage(driver);

        home.open();

        Assert.assertTrue(home.isLogoDisplayed());
    }

    @Test(groups = {"negative"})
    public void testEmptySearch() {
        AmazonHomePage home = new AmazonHomePage(driver);

        home.open();
        home.search("");

        Assert.assertFalse(driver.getTitle().isEmpty());
    }

    @Test(groups = {"positive"})
    public void testOpenCart() {
        AmazonHomePage home = new AmazonHomePage(driver);

        home.open();
        home.openCart();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
    }

    @Test(groups = {"positive"})
    public void testOpenDealsPage() {
        AmazonHomePage home = new AmazonHomePage(driver);

        home.open();
        home.openDeals();

        Assert.assertTrue(driver.getCurrentUrl().contains("deals"));
    }

    @Test(groups = {"negative"})
    public void testSearchInvalidQuery() {
        AmazonHomePage home = new AmazonHomePage(driver);

        home.open();
        home.search("////");

        Assert.assertTrue(driver.getTitle().contains("Amazon"));
    }

    @Test(groups = {"positive"})
    public void testSearchResultsTitle() {
        AmazonHomePage home = new AmazonHomePage(driver);

        home.open();
        home.search("phone");

        Assert.assertTrue(driver.getTitle().toLowerCase().contains("phone"));
    }
}
