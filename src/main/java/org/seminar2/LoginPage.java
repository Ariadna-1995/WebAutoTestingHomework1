package org.seminar2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage {
    private final WebDriverWait wait;
    @FindBy(xpath = "//*[@type='text']")
    private WebElement login;
    @FindBy(xpath = "//*[@type='password']")
    private WebElement password;
    @FindBy(xpath = "//button[@form='login']")
    private WebElement loginButton;
    @FindBy(linkText = "edit")
    private WebElement editProfileButton;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }
    public void loginInSystem(String log, String pass) {
        login.sendKeys(log);
        password.sendKeys(pass);
        loginButton.click();
    }
    public void loginWithOutAuthorization() {
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
    }
    public void getToProfilePage(){
        wait.until(ExpectedConditions.visibilityOf(editProfileButton)).click();
    }
}

