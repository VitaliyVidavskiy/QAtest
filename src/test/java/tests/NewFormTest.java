package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewFormTest {

    @BeforeAll
    static void beforeall() {
        Configuration.baseUrl="https://demoqa.com";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("viktor");
        $("#lastName").setValue("jonson");
        $("#userEmail").setValue("VJ@gmail.com");
        //пропустив гендер

        $("#userNumber").setValue("+390934045812");
        //пропустив дату
        $("#subjectsContainer").setValue("table");
        //Hobbies
        //Picture
        $("#currentAddress").setValue("some adress");
        //State and City
        $("#submit").click();

    }

}
