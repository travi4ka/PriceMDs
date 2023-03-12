package pages.authorized.clientmanagement;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ClientManagement_AddNewClientPage {
    private final SelenideElement hintCheckBoxes = $(byText("Turn \"ON\" if agreements are signed,completed, and active."));

    @Step("Add New Client Page page is open")
    public ClientManagement_AddNewClientPage checkPageIsOpen() {
        hintCheckBoxes.shouldBe(Condition.visible);
        return this;
    }
}
