package pages.unauthorized.mainpage;

import com.codeborne.selenide.SelenideElement;
import entities.User;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ForgotPasswordPage {
    final SelenideElement
            description = $(byText("Enter your email address to recover your password.")),
            resetPasswordButton = $$("button").findBy(text("Reset Password")),
            successMessage = $(byText("Password reset and sent to your email address, check your email for details.")),
            emailInput = $("input#email");

    @Step("Page opens")
    public ForgotPasswordPage checkPageIsOpen() {
        description.shouldBe(visible);
        return this;
    }

    @Step("Enter user's email")
    public ForgotPasswordPage enterEmail(User user) {
        emailInput.setValue(user.getEmail());
        return this;
    }

    @Step("Click reset password button")
    public ForgotPasswordPage clickResetPasswordButton() {
        resetPasswordButton.click();
        return this;
    }

    @Step("Check success message appears")
    public ForgotPasswordPage checkSuccessMessageAppears() {
        successMessage.shouldBe(visible);
        return this;
    }
}
