package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewFormTest {

    @BeforeAll
    static void beforeall() {
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize="800x600";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("viktor");
        $("#lastName").setValue("jonson");
        $("#userEmail").setValue("VJ@gmail.com");
        $(by("for","gender-radio-3")).click();
        $("#userNumber").setValue("+390934045812");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(3);
        $(".react-datepicker__year-select").selectOption("1993");
        $(by("aria-label", "Choose Saturday, April 24th, 1993")).click();
        //$(".subjects-auto-complete__input").setValue("Ma").pressEnter();

        $(by("for","hobbies-checkbox-2")).click();
        $(by("for","hobbies-checkbox-3")).click();
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/image.png"));
        $("#currentAddress").setValue("some adress");
        //$("#state").scrollTo().click();
        //$(byText("NCR")).click();
        //$("#city").click();
        //$(byText("Delhi")).click();
        //$("#submit").click();
    }

}
