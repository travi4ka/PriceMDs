package pages.authorized.reporting.globalAdmin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Reporting_GlobalAdminPage {
    final SelenideElement
            button = $(byText("Report - Facility Utilization"));

    @Step("Check that we are on the Global Admin page")
    public Reporting_GlobalAdminPage checkPageIsOpen() {
        button.shouldBe(Condition.visible);
        return this;
    }
}
