package pages.authorized.clientManagement.clients;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ClientManagement_ClientsPage {
    final SelenideElement
            selectClientDropdown = $("#clientSelect");

    @Step("Check that we are on the Clients page")
    public ClientManagement_ClientsPage checkPageIsOpen() {
        selectClientDropdown.shouldBe(Condition.visible);
        return this;
    }
}
