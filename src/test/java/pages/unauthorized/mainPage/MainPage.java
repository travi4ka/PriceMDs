package pages.unauthorized.mainPage;

import com.codeborne.selenide.SelenideElement;
import entities.user.User;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.testData.TestData.*;


public class MainPage {
    final SelenideElement
            emailInput = $("#userEmail"),
            passwordInput = $("#pwd"),
            sigInButton = $$("button").findBy(text("Sign In")),
            forgotPasswordLink = $(byText("Forgot password ?")),
            elementToCheckThatPageIsOpen = $(byText("Sign In to your account"));

    @Step("Click Forgot password")
    public MainPage clickForgotPassword() {
        forgotPasswordLink.click();
        return this;
    }

    @Step("Enter email")
    public MainPage enterEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Enter password")
    public MainPage enterPassword(String value) {
        passwordInput.setValue(value);
        return this;
    }

    @Step("Open main page")
    public MainPage openPage() {
        open(MAIN_URL);
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

    public MainPage enterUserCredentials(User user) {
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        return this;
    }

    public MainPage enterCredentialsForMainAdmin() {
        enterEmail(MAIN_ADMIN_EMAIL);
        enterPassword(MAIN_ADMIN_PASSWORD);
        return this;
    }
}
