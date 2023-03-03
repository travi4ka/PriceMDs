package pages.authorized.searchFacility;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchFacilityPage {
    private final String url = "facility/facilitySearch.php";
    final SelenideElement
            description = $(byText("Search times can vary")),
            cptInputField = $("#parameterCPTDisplay");

    @Step("Check that we are on the Search Facility page")
    public SearchFacilityPage checkPageIsOpen() {
        description.shouldBe(Condition.visible);
        return this;
    }

    @Step("Check that CPT input field doesn't exist")
    public SearchFacilityPage checkAbsenceOfCptInputField() {
        cptInputField.shouldNotBe(Condition.visible);
        return this;
    }

    @Step("Open page")
    public SearchFacilityPage openPage() {
        open(url);
        checkPageIsOpen();
        return this;
    }
}
