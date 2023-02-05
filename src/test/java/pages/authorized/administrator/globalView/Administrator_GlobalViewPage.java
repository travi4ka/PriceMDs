package pages.authorized.administrator.globalView;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Administrator_GlobalViewPage {
    final SelenideElement
            description = $(byText("Administrator Global View"));

    @Step("Check that we are on the Global View page")
    public Administrator_GlobalViewPage checkPageIsOpen() {
        description.shouldBe(Condition.visible);
        return this;
    }
}
