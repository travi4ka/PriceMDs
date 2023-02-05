package pages.authorized.groups.groups;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Groups_GroupsPage {
    final SelenideElement
            description = $(byText("Physicians Group"));

    @Step("Check that we are on the Groups page")
    public Groups_GroupsPage checkPageIsOpen() {
        description.shouldBe(Condition.visible);
        return this;
    }
}
