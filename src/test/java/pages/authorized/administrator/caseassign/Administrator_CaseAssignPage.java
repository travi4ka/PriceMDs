package pages.authorized.administrator.caseassign;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Administrator_CaseAssignPage {
    final SelenideElement
            table = $("#demo-dt-basic");

    @Step("Check that we are on the Case Assign page")
    public Administrator_CaseAssignPage checkPageIsOpen() {
        table.shouldBe(Condition.visible);
        return this;
    }
}
