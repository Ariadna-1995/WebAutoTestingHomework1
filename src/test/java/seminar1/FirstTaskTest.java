package seminar1;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
public class FirstTaskTest {
    WebDriver driver;
    String log = "GB202307470f719";
    String pass = "b9a870f47f";
    @BeforeEach
    void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); // режим полного экрана
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://test-stand.gb.ru/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    void CheckDummyTitleTest() throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement login = driver.findElement(By.xpath("//*[@type='text']"));
        WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@form='login']"));
        login.sendKeys(log);
        password.sendKeys(pass);
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement plusButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[id='create-btn']")));
        plusButton.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@type='text']"));
        firstName.sendKeys("Евлампия");
        WebElement dummyLogin = driver.findElement(By.xpath("//div[@class='field'][5]//input[@class='mdc-text-field__input']"));
        dummyLogin.sendKeys("Ginger1903");
        WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
        saveButton.click();
        Thread.sleep(2000L);
        List<WebElement> searchList = driver.findElements(By.xpath("//td[@class='mdc-data-table__cell']"));
        Assertions.assertEquals("Евлампия", searchList.get(0).getText());
        Thread.sleep(2000L);
        System.out.println("Проверка прошла");
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/resources/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @AfterEach
    void close() {
        driver.quit();
    }
}
