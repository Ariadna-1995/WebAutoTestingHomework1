package seminar3;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seminar3.LoginPageS3;
import seminar3.ProfilePageS3;
import seminar3.StudentPageS3;
import seminar3.*;

import static com.codeborne.selenide.Selenide.page;

public class Homework4SelenideTest extends AbstractTestS3 {
    @Test
    void changeBirthDayInProfileSelenideTest () {

        LoginPageS3 loginPageS3 = page(LoginPageS3.class);
        loginPageS3.loginInSystemS3("GB202307470f719", "b9a870f47f");

        StudentPageS3 studentPageS3 = page(StudentPageS3.class);
        studentPageS3.openProfileS3();

        ProfilePageS3 profilePageS3 = page(ProfilePageS3.class);
        profilePageS3.clickEditProfileS3();
        profilePageS3.uploadnewBirthDayDateS3("01.01.2001");
        profilePageS3.clickSaveProfileUpdateDataS3();
        profilePageS3.clickCloseWidowEditingProfileS3();

        Assertions.assertEquals("01.01.2001",profilePageS3.getDayOfBirthTextS3());
        Selenide.sleep(5000L);
    }

}
