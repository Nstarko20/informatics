import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class TestNGElements {
    public static void main(String[] args) {
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://testng.org/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains("TestNG"));

            List<WebElement> Items = driver.findElements(
                    By.cssSelector("div.toc li a, .toc li a, li a")
            );

            System.out.println("Table of Contents сайта TestNG:");
            int itemCount = 0;
            for (WebElement item:Items) {
                String text = item.getText();
                if (!text.isEmpty() && text.length() < 100) {
                    itemCount++;
                    System.out.println(itemCount + ". " + text);
                }
            }
            System.out.println("Всего найдено элементов: " + itemCount);

            WebElement elementCSS = driver.findElement(
                    By.cssSelector("a[href*='introduction']")
            );
            elementCSS.click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(1000);
            WebElement elementXPath = driver.findElement(
                    By.xpath("//a[contains(text(), 'Introduction')]")
            );
            elementXPath.click();
            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}