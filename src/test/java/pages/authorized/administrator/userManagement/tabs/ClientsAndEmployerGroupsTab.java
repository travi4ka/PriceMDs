package pages.authorized.administrator.userManagement.tabs;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class ClientsAndEmployerGroupsTab {
    final SelenideElement addCompanyButton = $x("//button[contains(text(),'Add Company')]");
    final SelenideElement statusColumn = $$("th").findBy(exactText("Status"));
    final SelenideElement startDateColumn = $$("th").findBy(exactText("Start Date"));
    final SelenideElement terminationDateColumn = $$("th").findBy(exactText("Termination Date"));


    @Step("Check that tab is open")
    public ClientsAndEmployerGroupsTab tabIsOpen() {
        addCompanyButton.shouldBe(visible);
        return this;
    }

    @Step("Status / Start Date / Termination Date columns are in the table")
    public ClientsAndEmployerGroupsTab checkColumns() {
        statusColumn.shouldBe(visible);
        startDateColumn.shouldBe(visible);
        terminationDateColumn.shouldBe(visible);
        return this;
    }
}
