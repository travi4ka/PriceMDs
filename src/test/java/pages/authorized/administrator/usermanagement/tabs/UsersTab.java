package pages.authorized.administrator.usermanagement.tabs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class UsersTab {

    final SelenideElement description = $(byText("Registered Users"));

    @Step("Check that page open")
    public UsersTab checkPageIsOpen() {
        description.shouldBe(Condition.visible);
        return this;
    }

}
