package pages.authorized.administrator.userManagement;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Administrator_UserManagementPage {
    final SelenideElement
            description = $(byText("Registered Users"));

    @Step("Check that we are on the User Management page")
    public Administrator_UserManagementPage checkPageIsOpen() {
        description.shouldBe(Condition.visible);
        return this;
    }
}
