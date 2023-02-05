package pages.authorized.groups.surgicalGroups;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Groups_SurgicalGroupsPage {
    final SelenideElement
            button = $(byText("Add Surgical Group"));

    @Step("Check that we are on the Surgical Groups page")
    public Groups_SurgicalGroupsPage checkPageIsOpen() {
        button.shouldBe(Condition.visible);
        return this;
    }
}
