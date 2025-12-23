import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class DonatovFirefox {
    public static void main(String[] args) {
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://donatov.net/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains("Donatov"));

            String title = driver.getTitle();
            System.out.println("Заголовок Donatov: " + title);

            List<WebElement> navItems = driver.findElements(
                    By.cssSelector("nav a, header a, .menu a")
            );

            for (WebElement item : navItems) {
                if (!item.getText().isEmpty()) {
                    System.out.println("- " + item.getText());
                }
            }

            WebElement supportCSS = driver.findElement(
                    By.cssSelector("a[href*='support']")
            );
            supportCSS.click();
            Thread.sleep(2000);

            driver.navigate().back();
            WebElement reviewsXPath = driver.findElement(
                    By.xpath("//a[contains(text(), 'Отзывы')]")
            );
            reviewsXPath.click();
            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}