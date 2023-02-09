package tests.Tests.authorized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static tests.testData.TestData.userRole.NURSE;

@Tag("Nurse")
@DisplayName("Nurse tests")
public class NurseTests extends TestBase {

    @Test
    @Tag("Smoke")
    @DisplayName("Check menu items")
    void checkMenuForAllRoles() {
        user.createUsersWithRole(NURSE);
        mainPage
                .openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen()
                .checkMenu(NURSE);
        user.deleteUser();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Check all pages can be open for Nurse")
    void checkAllPAgesCanBeOpenForNurse() {
        user.createUsersWithRole(NURSE);
        mainPage
                .openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen();
        menu
                .clickSearchFacilities();
        searchFacilityPage
                .checkPageIsOpen();
        menu
                .clickCaseManagement()
                .clickCaseManagement_patients();
        caseManagement_patientsPage
                .checkPageIsOpen();
        menu
                .clickReporting()
                .clickReporting_client();
        reporting_clientPage
                .checkPageIsOpen();
        menu
                .clickReporting()
                .clickReporting_charts();
        reporting_chartsPage
                .checkPageIsOpen();
        user.deleteUser();
    }

    @Tag("Smoke")
    @Test
    @DisplayName("Check absence of CPT input field")
    void checkAbsenceOfCptField() {
        user.createUsersWithRole(NURSE);
        mainPage
                .openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        menu
                .clickSearchFacilities();
        searchFacilityPage
                .checkPageIsOpen()
                .checkAbsenceOfCptInputField();
        user.deleteUser();
    }

    @Tag("Smoke")
    @Test
    @DisplayName("Check that DOB of patient displays on the patients case page")
    void checkDobShows() {
        user.createUsersWithRole(NURSE);
        mainPage
                .openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        menu
                .clickCaseManagement()
                .clickCaseManagement_patients();
        caseManagement_patientsPage
                .checkPageIsOpen()
                .checkDobDisplays();
        user.deleteUser();
    }
}
