package org.seminar2;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class EditingDummyProfile {
    private final WebDriverWait wait;
    @FindBy(xpath = "//form[@id='upsert-item']/div[1]/label/input")
    private WebElement firstNameField;

    @FindBy(css = "button[form='upsert-item']")
    private WebElement saveButton;

    public EditingDummyProfile(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public void ChangeDummyFirstName(String name) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(firstNameField)).clear();
        wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }
}
