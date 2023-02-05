package pages.unauthorized.mainPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.testData.TestData.roleCredentials.roleCredentials;


public class MainPage {
    public static final SelenideElement
            emailInput = $("#userEmail"),
            passwordInput = $("#pwd"),
            sigInButton = $$("button").findBy(text("Sign In")),
            elementToCheckThatPageIsOpen = $(byText("Sign In to your account"));

    @Step("Enter email")
    public MainPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Enter password")
    public MainPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Open main page")
    public MainPage openPage() {
        open("");
        return this;
    }

    @Step("Click Sign In button")
    public MainPage clickSignInButton() {
        sigInButton.click();
        return this;
    }

    @Step("Check that we are on the Main page")
    public MainPage checkThatPageIsOpen() {
        elementToCheckThatPageIsOpen.shouldBe(visible);
        return this;
    }

    public MainPage enterUserCredentials(String role) {
        for (String[] line : roleCredentials) {
            if (line[0].equals(role)) {
                enterEmail(line[1]);
                enterPassword(line[2]);
            }
        }
        return this;
    }
}
