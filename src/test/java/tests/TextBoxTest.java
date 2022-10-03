package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void beforeall() {
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize="1920x1080";
    }

    @Test
    void successFillTest() {
       open("/text-box");
       $(".main-header").shouldHave(text("Text Box"));

        $("#userName").setValue("Boris");
        $("#userEmail").setValue("boris@gmail.com");
        $("#currentAddress").setValue("address 1");
        $("#permanentAddress").setValue("some adress 2");
        $("#submit").click();

        $("#output").shouldHave(text("Boris"), text("boris@gmail.com"),
                text("address 1"), text("some adress 2"));


      }

}
