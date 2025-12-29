package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DonatovHomePage;

public class DonatovTests {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(groups = {"positive"})
    public void testTitle() {
        DonatovHomePage page = new DonatovHomePage(driver);

        page.open();

        Assert.assertTrue(page.getTitle().contains("Donatov"));
    }

    @Test(groups = {"positive"})
    public void testSupportPage() {
        DonatovHomePage page = new DonatovHomePage(driver);

        page.open();
        page.openSupport();

        Assert.assertTrue(driver.getCurrentUrl().contains("support"));
    }

    @Test(groups = {"positive"})
    public void testReviewsPage() {
        DonatovHomePage page = new DonatovHomePage(driver);

        page.open();
        page.openReviews();

        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("review"));
    }
}
