import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AmazonFirefox {
    public static void main(String[] args) {
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://www.amazon.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains("Amazon"));

            String title = driver.getTitle();
            System.out.println("Заголовок Amazon: " + title);

            List<WebElement> navItems = driver.findElements(
                    By.cssSelector("#nav-xshop a")
            );

            for (WebElement item : navItems) {
                if (!item.getText().isEmpty()) {
                    System.out.println("- " + item.getText());
                }
            }

            WebElement todayDealsCSS = driver.findElement(
                    By.cssSelector("a[href*='deals']")
            );
            todayDealsCSS.click();
            Thread.sleep(2000);

            driver.navigate().back();
            WebElement customerServiceXPath = driver.findElement(
                    By.xpath("//a[contains(text(), 'Customer Service')]")
            );
            customerServiceXPath.click();
            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}