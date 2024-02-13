package seminar3;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
public class ProfilePageS3 {
    @FindBy(xpath = "//h2[@class='mdc-typography--headline6 svelte-vyyzan']")
    private SelenideElement h2fullName;
    @FindBy(xpath = "//h3/following-sibling::div" +
            "//div[contains(text(), 'Full name')]/following-sibling::div")
    private SelenideElement fullName;
    private final SelenideElement dateOfBirth = $x("//div[contains(text(), " +
            "'Date of birth')]/following-sibling::div");
    private final SelenideElement editProfile = $("button[title='More options']");
    private final SelenideElement newAvatarImageInput = $("input[type='file']");
    //или локатор $x("//form[@id='update-item']//span[contains(text(), 'New Avatar')]/following-sibling::input")
    // этот вариант говорит, что искомый элемент находится внутри другой вновь открывшейся формы
    private final SelenideElement saveProfileUpdateData = $("button[type='submit']");
    private final SelenideElement newBirthDayDateInput = $("input[type='date']");
    private final SelenideElement closeWidowEditingProfile = $("button[data-mdc-dialog-action='close']");

    public String getH2FullNameTextS3 () {
        return h2fullName.shouldBe(visible).text();
    }

    public String getFullNameTextS3 () {
        return fullName.shouldBe(visible).text();
    }

    public String getDayOfBirthTextS3() {return dateOfBirth.shouldBe(visible).text();}

    public void clickEditProfileS3 () {
        editProfile.shouldBe(visible).click();
    }
    public void uploadNewAvatarImageS3 (String pathToFile) {
        newAvatarImageInput.shouldBe(visible).uploadFile(new File(pathToFile));
    }
    public String getUploadFileNameS3 () {
        return newAvatarImageInput.getValue();
    }
    public void uploadnewBirthDayDateS3(String date) {
        newBirthDayDateInput.shouldBe(visible).setValue(date);}
    public void clickSaveProfileUpdateDataS3 () {
        saveProfileUpdateData.shouldBe(visible, Duration.ofMillis(2000L)).click();
    }
    public void clickCloseWidowEditingProfileS3() {
        closeWidowEditingProfile.shouldBe(visible).click();
    }

}

