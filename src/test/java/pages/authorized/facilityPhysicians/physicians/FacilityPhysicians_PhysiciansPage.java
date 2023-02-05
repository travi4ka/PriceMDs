package pages.authorized.facilityPhysicians.physicians;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FacilityPhysicians_PhysiciansPage {
    final SelenideElement
            button = $(byText("Add Physician"));

    @Step("Check that we are on the Physicians page")
    public FacilityPhysicians_PhysiciansPage checkPageIsOpen() {
        button.shouldBe(Condition.visible);
        return this;
    }
}
