package org.seminar2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
public class ProfilePage {
    private final WebDriverWait wait;

    //@FindBy(xpath = "//input[@type='text']")
    //private WebElement firstName;
    //@FindBy(xpath = "//div[@class='mdc-button__ripple']")
    //private WebElement saveButton;


    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }



}
