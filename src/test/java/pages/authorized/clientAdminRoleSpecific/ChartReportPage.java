package pages.authorized.clientAdminRoleSpecific;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ChartReportPage {
    final SelenideElement
            description = $(byText("Client Administrator Reporting"));

    @Step("Check that we are on the Chart Report page (Client Admin)")
    public ChartReportPage checkPageIsOpen() {
        description.shouldBe(Condition.visible);
        return this;
    }
}
