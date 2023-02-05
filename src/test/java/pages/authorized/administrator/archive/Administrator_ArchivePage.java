package pages.authorized.administrator.archive;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Administrator_ArchivePage {
    final SelenideElement
            table = $("#dash4");

    @Step("Check that we are on the Archive page")
    public Administrator_ArchivePage checkPageIsOpen() {
        table.shouldBe(Condition.visible);
        return this;
    }
}
