package pages.components;

import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComonent {
    public RegistrationPage setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $("[aria-label$= '" + month + " " + day + " " + year + "']").click();
    }
}
