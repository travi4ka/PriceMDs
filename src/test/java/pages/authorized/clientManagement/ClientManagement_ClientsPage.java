package pages.authorized.clientManagement;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ClientManagement_ClientsPage {
    final SelenideElement filterByStatusButton = $(byText("Filter by Status"));

    @Step("Check that we are on the Clients page")
    public ClientManagement_ClientsPage checkPageIsOpen() {
        filterByStatusButton.shouldBe(Condition.visible);
        return this;
    }
}
