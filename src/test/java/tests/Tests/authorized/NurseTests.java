package tests.Tests.authorized;

import io.qameta.allure.Story;
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
                .checkPageIsOpen();
        String firstDOBOnTable = caseManagement_patientsPage.getDobOfFirstElementOnTheTable();
        caseManagement_patientsPage
                .clickFirstOpenFileButton();
        caseManagement_patientsPage.newCaseTab
                .checkThatOpen()
                .checkDobDisplays(firstDOBOnTable);
        user.deleteUser();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Check that table has column days/weeks/months")
    void checkMenuHasColumnDaysWeeksMonth() {
        user.createUsersWithRole(NURSE);
        mainPage
                .openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen()
                .checkDaysMonthsWeeksColumn();
        user.deleteUser();
    }

    @Test
    @Tag("Smoke")
    @Story("PRMD-35")
    @DisplayName("Check that table can be sorted by days/weeks/months (ASC)")
    void checkMenuCanBeSortedByDaysWeeksMonthAsc() {
        user.createUsersWithRole(NURSE);
        mainPage
                .openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen()
                .clickDaysWeeksMonthsColumn()
                .checkThatColumnIsSortedByAsc();
        user.deleteUser();
    }

    @Test
    @Tag("Smoke")
    @Story("PRMD-35")
    @DisplayName("Check that table can be sorted by days/weeks/months (DESC)")
    void checkMenuCanBeSortedByDaysWeeksMonthDesc() {
        user.createUsersWithRole(NURSE);
        mainPage
                .openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen()
                .clickDaysWeeksMonthsColumn()
                .clickDaysWeeksMonthsColumn();
        dashboardPage.checkThatColumnIsSortedByDesc();
        user.deleteUser();
    }
}
