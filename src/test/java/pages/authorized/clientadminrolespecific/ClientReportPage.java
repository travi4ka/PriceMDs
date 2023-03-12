package pages.authorized.clientadminrolespecific;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ClientReportPage {
    final SelenideElement
            description = $(byText("Client Reporting -PriceMDs"));

    @Step("Check that we are on the Client Report page (Client Admin)")
    public ClientReportPage checkPageIsOpen() {
        description.shouldBe(Condition.visible);
        return this;
    }
}
