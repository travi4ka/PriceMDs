package pages.authorized.casemanagement.carecoordination;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CaseManagement_CareCoordinationPage {
    final SelenideElement
            table = $("#ccTbl");

    @Step("Check that we are on the Care Coordination page")
    public CaseManagement_CareCoordinationPage checkPageIsOpen() {
        table.shouldBe(Condition.visible);
        return this;
    }
}
