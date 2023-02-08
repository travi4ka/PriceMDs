package tests.Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

@Tag("Param")
public class ParamTests extends TestBase {

    @Test()
    @DisplayName("Check menu items")
    void checkMenuForAllRoles(String role) {
        user.createUsersWithRole(role);
        mainPage
                .openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen()
                .checkMenu(role);
        user.deleteUser();
    }

    @Test
    @DisplayName("Check absence of CPT input field")
    void checkAbsenceOfCptField(String role) {
        user.createUsersWithRole(role);
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

    @Test
    @DisplayName("Check that DOB of patient displays on the patients case page")
    void checkDobShows(String role) {
        user.createUsersWithRole(role);
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
