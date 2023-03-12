package pages.authorized.facilityphysicians.facility;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FacilityPhysicians_FacilityPage {
    final SelenideElement
            button = $(byText("Add Facility"));

    @Step("Check that we are on the Facility page")
    public FacilityPhysicians_FacilityPage checkPageIsOpen() {
        button.shouldBe(Condition.visible);
        return this;
    }
}
