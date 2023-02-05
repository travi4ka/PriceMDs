package pages.authorized.reporting.client;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Reporting_ClientPage {
    final SelenideElement
            button = $(byText("Report - Facility Utilization"));

    @Step("Check that we are on the Care Coordination page")
    public Reporting_ClientPage checkPageIsOpen() {
        button.shouldBe(Condition.visible);
        return this;
    }
}
