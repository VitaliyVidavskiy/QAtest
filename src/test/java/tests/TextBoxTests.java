package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "800x600";
    }

    @Test
    void successFillTest() {
        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));

        $("#userName").setValue("Alex");
        $("#userEmail").setValue("alex@company.com");
        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Other address 2");
        $("#submit").click();

        $("#output").shouldHave(text("Alex"), text("alex@company.com"),
                text("Some address 1"), text("Other address 2"));

        $("#name").shouldHave(text("Alex"));

        $("#currentAddress", 1).shouldHave(text("Some address 1"));
        $("#output").$("#currentAddress").shouldHave(text("Some address 1"));
        $("#output #currentAddress").shouldHave(text("Some address 1"));
    }
}