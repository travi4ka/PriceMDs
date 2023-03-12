package pages.authorized.procedurespecialities;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProcedureSpeciality_CptSpecialityPage {
    final SelenideElement
            description = $(byText("CPT Code Management"));

    @Step("Check that we are on the CPT & Specialty page")
    public ProcedureSpeciality_CptSpecialityPage checkPageIsOpen() {
        description.shouldBe(Condition.visible);
        return this;
    }
}
