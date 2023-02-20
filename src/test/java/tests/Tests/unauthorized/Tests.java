package tests.Tests.unauthorized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

@DisplayName("Unauthorized tests")
public class Tests extends TestBase {

    @Test
    @Tag("Smoke")
    @DisplayName("Check forgot password flow with valid data")
    void checkForgotPasswordFlowWithValidData() {
        user.createRandomUser();
        mainPage
                .openPage()
                .clickForgotPassword();
        forgotPasswordPage
                .checkPageIsOpen()
                .enterEmail(user)
                .clickResetPasswordButton()
                .checkSuccessMessageAppears();
        user.deleteUser();
    }
}
