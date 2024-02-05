package seminar1;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class SecondTaskTest {
    static WebDriver driver;
    static Actions action;
    static WebDriverWait wait;

    @BeforeAll
    static void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized"); // режим полного экрана
        driver = new ChromeDriver(chromeOptions);
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    @Test
    void dragAndDropTest() {
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[@class='demo-frame lazyloaded']")));
        WebElement picture = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//img[@src='images/high_tatras2_min.jpg']")));

        WebElement trash = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@id='trash']")));

        action.dragAndDrop(picture, trash).build().perform();
        WebElement pictureInTrash = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@id='trash']//img[@src='images/high_tatras2_min.jpg']")));
        Assertions.assertEquals("The chalet at the Green mountain lake",pictureInTrash.getAttribute("alt"));
    }

    @AfterAll
    static void close() {
        driver.quit();
    }
}
