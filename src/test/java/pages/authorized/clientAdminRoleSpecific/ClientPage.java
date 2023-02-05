package pages.authorized.clientAdminRoleSpecific;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ClientPage {
    final SelenideElement
            description = $(byText("Client Administration"));

    @Step("Check that we are on the Client page (Client Admin)")
    public ClientPage checkPageIsOpen() {
        description.shouldBe(Condition.visible);
        return this;
    }
}
