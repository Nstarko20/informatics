import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestNGChrome {
    public static void main(String[] args) {

        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testng.org/");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains("TestNG"));
            String pageTitle = driver.getTitle();
            System.out.println("Заголовок страницы: " + pageTitle);
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}