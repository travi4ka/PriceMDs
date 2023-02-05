package pages.authorized.reporting.charts;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Reporting_ChartsPage {
    final SelenideElement
            description = $(byText("Administrative Reporting"));

    @Step("Check that we are on the Charts page")
    public Reporting_ChartsPage checkPageIsOpen() {
        description.shouldBe(Condition.visible);
        return this;
    }
}
