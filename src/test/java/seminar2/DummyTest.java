package seminar2;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.seminar2.*;


public class DummyTest extends AbstractTest2 {



    @Test

    void loginPageSuccessfulAccessTest() throws InterruptedException {

        driver.get("https://test-stand.gb.ru/login");
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginInSystem("GB202307470f719", "b9a870f47f");
        WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[@class='svelte-1rc85o5']")));
        Assertions.assertEquals("Home", search.getText());

        //ProfilePage profilePage = new ProfilePage(driver, wait);
        //profilePage.editFirstName();
        //WebElement searchFirstName = wait.until(ExpectedConditions.presenceOfElementLocated(
                //By.xpath("//input[@type='text']")));
        //Assertions.assertEquals("Катя", searchFirstName.getText());
    }



    @Test

    void dummyEditTest() throws InterruptedException {
        driver.get("https://test-stand.gb.ru/login");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginInSystem("GB202306611b512", "a5c6730434");
        StudentPage studentPage = new StudentPage(driver, wait);
        studentPage.editStudent("20003");

        WebElement searchId = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(" //span[@slot='title']")));
        Assertions.assertEquals("Editing Dummy 20003", searchId.getText());
        String newName = "Peter";

        EditingDummyProfile editingDummyPage = new EditingDummyProfile(driver, wait);
        editingDummyPage.ChangeDummyFirstName(newName);

        String checkName = studentPage.getStudentNameByid("20003");
        Assertions.assertNotEquals(newName, checkName);
    }
    @Test
    void credentialsWindowTest() throws InterruptedException {
        driver.get("https://test-stand.gb.ru/login");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginInSystem("GB202306611b512", "a5c6730434");
        StudentPage studentPage = new StudentPage(driver, wait);
        studentPage.checkStudent("20003");
        WebElement checkTitle = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(" //h2[@id='simple-title']")));
        Assertions.assertEquals("Dummy credentials", checkTitle.getText());
        WebElement checkLoginAndPW = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(" //div[@id='simple-content']")));
        Assertions.assertTrue((checkLoginAndPW.getText().contains("BIGIVAN")));
        Assertions.assertTrue((checkLoginAndPW.getText().contains("9a60c5e1a0")));

    }
    }
