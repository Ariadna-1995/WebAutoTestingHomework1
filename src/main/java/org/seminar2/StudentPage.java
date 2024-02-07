package org.seminar2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
public class StudentPage {
    private final WebDriverWait wait;
    @FindBy(xpath = "//li[@class='svelte-1rc85o5 mdc-menu-surface--anchor']/a")
    private WebElement userButton;
    @FindBy(xpath =  "//ul[@role='menu']/li")
    private WebElement profileButton;

    @FindBy(xpath = "//tbody[@class='mdc-data-table__content']/tr")
    private List<WebElement> StudentsTable;

    public StudentPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }
    public void editStudent(String id) throws InterruptedException {
        getStudentRowById(id).clickEditButtonInRow();
        Thread.sleep(2000L);
    }
    public void checkStudent(String id) throws InterruptedException {
        getStudentRowById(id).clickCredentialButtonInRow();
        Thread.sleep(2000L);
    }
    public String getStudentNameByid(String id) throws InterruptedException {
        Thread.sleep(2000L);
        return getStudentRowById(id).getNameStudent();
    }
    private StudentTableRow getStudentRowById(String id) throws InterruptedException {
        Thread.sleep(3000L);
        return StudentsTable.stream()
                .map(root -> new StudentTableRow(root, wait))
                .filter(row -> row.getIdStudent().equals(id)).findFirst().orElseThrow();
    }
    private List<StudentTableRow> getStudentListRow() {
        return StudentsTable.stream()
                .map(root -> new StudentTableRow(root, wait)).toList();
    }

}
