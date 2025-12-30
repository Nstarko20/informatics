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
    private String mainTitle = "Amazon";

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

        Assert.assertTrue(title.contains(mainTitle));
    }

    @Test(groups = {"positive"})
    public void testSearchProduct() {
        AmazonHomePage home = new AmazonHomePage(driver);
        AmazonSearchResultsPage results = new AmazonSearchResultsPage(driver);
        final String SEARCH_TEST_WORD = "laptop";

        home.open();
        home.search(SEARCH_TEST_WORD);

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
        final String SEARCH_EMPTY = "";

        home.open();
        home.search(SEARCH_EMPTY);

        Assert.assertFalse(driver.getTitle().isEmpty());
    }

    @Test(groups = {"positive"})
    public void testOpenCart() {
        AmazonHomePage home = new AmazonHomePage(driver);
        final String URL_CART = "cart";

        home.open();
        home.openCart();

        Assert.assertTrue(driver.getCurrentUrl().contains(URL_CART));
    }

    @Test(groups = {"positive"})
    public void testOpenDealsPage() {
        AmazonHomePage home = new AmazonHomePage(driver);
        final String URL_DEALS = "deals";

        home.open();
        home.openDeals();

        Assert.assertTrue(driver.getCurrentUrl().contains(URL_DEALS));
    }

    @Test(groups = {"negative"})
    public void testSearchInvalidQuery() {
        AmazonHomePage home = new AmazonHomePage(driver);
        final String SEARCH_WRONG = "////";

        home.open();
        home.search(SEARCH_WRONG);

        Assert.assertTrue(driver.getTitle().contains(mainTitle));
    }

    @Test(groups = {"positive"})
    public void testSearchResultsTitle() {
        AmazonHomePage home = new AmazonHomePage(driver);
        final String SEARCH_WORD = "phone";

        home.open();
        home.search(SEARCH_WORD);

        Assert.assertTrue(driver.getTitle().toLowerCase().contains(SEARCH_WORD));
    }
}
