package pages_new;

import com.codeborne.selenide.SelenideElement;
import entities.User;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.testData.TestData.*;

public class MainPage {
    final SelenideElement emailInput = $("#input-1");
    final SelenideElement passwordInput = $("#input-3");
    final SelenideElement sigInButton = $$("button").findBy(text("Sign In"));
    final SelenideElement forgotPasswordLink = $(byText("Forgot pwd?"));
    final SelenideElement logo = $("img[src='/assets/images/logos/logo-horizontal.png']");
    final SelenideElement elementToCheckThatPageIsOpen = $(byText("Sign In to your account"));

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

    public pages.unauthorized.mainPage.MainPage enterUserCredentials(User user) {
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        return this;
    }

    public pages.unauthorized.mainPage.MainPage enterCredentialsForMainAdmin() {
        enterEmail(MAIN_ADMIN_EMAIL);
        enterPassword(MAIN_ADMIN_PASSWORD);
        return this;
    }
}
