package pages.authorized.groups.affiliateGroups;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Groups_AffiliateGroupsPage {
    final SelenideElement
            button = $(byText("Add Affiliate Group"));

    @Step("Check that we are on the Affiliate Groups page")
    public Groups_AffiliateGroupsPage checkPageIsOpen() {
        button.shouldBe(Condition.visible);
        return this;
    }
}
