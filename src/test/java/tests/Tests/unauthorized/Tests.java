package tests.Tests.unauthorized;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.refresh;

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

    @Test
   @Disabled
    void qwe() {
//        todo
        Configuration.holdBrowserOpen = true;
        mainPage
                .openPage()
                .checkThatPageIsOpen()
                .enterCredentialsForMainAdmin()
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen();
        menu
                .clickCaseManagement()
                .clickCaseManagement_patients();
        caseManagement_patientsPage
                .checkPageIsOpen()
                .clickAddPatientButton();
        caseManagement_patientsPage.addPatientForm
                .enterFirstName(patient.getFirstName())
                .enterLastName(patient.getLastName())
                .clickSaveChangesButton();
        refresh();
        caseManagement_patientsPage
                .enterFirstNameOfCreatedPatient(patient)
                .clickFirstOpenFileButton();
    }
}
