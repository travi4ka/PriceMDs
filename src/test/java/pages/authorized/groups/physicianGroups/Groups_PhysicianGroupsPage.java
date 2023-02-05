package pages.authorized.groups.physicianGroups;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Groups_PhysicianGroupsPage {
    final SelenideElement
            button = $(byText("Add Physician Group"));

    @Step("Check that we are on the Physician Groups page")
    public Groups_PhysicianGroupsPage checkPageIsOpen() {
        button.shouldBe(Condition.visible);
        return this;
    }
}
