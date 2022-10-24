package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstname = "viktor";

   @BeforeAll
   static void beforeAll() {
         Configuration.baseUrl = "https://demoqa.com";
         Configuration.browserSize = "800x600";
        }

    @Test
    void successFillTest() {
        registrationPage
              .openPage()
              .setFirstName("firstname")
              .setLastName("jonson");
        $("#userEmail").setValue("VJ@gmail.com");
        $(by("for","gender-radio-3")).click();
        $("#userNumber").setValue("+390934045812");
        registrationPage.setBirthDate( "24", "April", "1993");
        $(".subjects-auto-complete__input").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $(by("for","hobbies-checkbox-2")).click();
        $(by("for","hobbies-checkbox-3")).click();
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/image.png"));
        $("#currentAddress").setValue("some adress");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        registrationPage
                .checkForm("Student Name", firstname + "jonson")
                .checkForm("Student Email", "VJ@gmail.com")
                .checkForm("Gender", "Other");

    }

}
