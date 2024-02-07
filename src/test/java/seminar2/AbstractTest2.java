package seminar2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class AbstractTest2 {
    static WebDriver driver;
    static WebDriverWait wait;
    String log = "GB202307470f719";
    String pass = "b9a870f47f";
    @BeforeAll
    static void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); // режим полного экрана
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://test-stand.gb.ru/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterAll
    static void close() {

        driver.quit();
    }
}
