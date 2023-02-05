package pages.authorized.administrator.messaging;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Administrator_MessagingPage {
    final SelenideElement
            button = $(byText("Get Messages"));

    @Step("Check that we are on the Messaging page")
    public Administrator_MessagingPage checkPageIsOpen() {
        button.shouldBe(Condition.visible);
        return this;
    }
}
