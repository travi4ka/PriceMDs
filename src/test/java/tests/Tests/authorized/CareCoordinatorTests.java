package tests.Tests.authorized;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static tests.testData.TestData.userRole.*;

@Tag("CareCoordinator")
@DisplayName("Care Coordinator tests")
public class CareCoordinatorTests extends TestBase {

    @Test
    @Tag("Smoke")
    @DisplayName("Check menu items")
    void checkMenuForAllRoles() {
        user.createUsersWithRole(CARE_COORDINATOR);
        mainPage
                .openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen()
                .checkMenu(CARE_COORDINATOR);
        user.deleteUser();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Check all pages can be open for Care Coordinator")
    void checkAllPAgesCanBeOpenForCareCoordinator() {
        user.createUsersWithRole(CARE_COORDINATOR);
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
                .clickClientManagement()
                .clickClientManagement_clients();
        clientManagement_clientsPage
                .checkPageIsOpen();
        menu
                .clickClientManagement()
                .clickClientManagement_addNewClient();
        clientManagement_addNewClientPage
                .checkPageIsOpen();
        menu
                .clickProcedureSpecialties()
                .clickProcedureSpecialties_cpt();
        procedureSpeciality_cptSpecialityPage
                .checkPageIsOpen();
        menu
                .clickReporting()
                .clickReporting_client();
        reporting_clientPage
                .checkPageIsOpen();
        menu
                .clickReporting()
                .clickReporting_globalAdmin();
        reporting_globalAdminPage
                .checkPageIsOpen();
        menu
                .clickReporting()
                .clickReporting_charts();
        reporting_chartsPage
                .checkPageIsOpen();
        menu
                .clickFacilityPhysicians()
                .clickFacilityPhysicians_Facility();
        facilityPhysicians_facilityPage
                .checkPageIsOpen();
        menu
                .clickFacilityPhysicians()
                .clickFacilityPhysicians_Physicians();
        facilityPhysicians_physiciansPage
                .checkPageIsOpen();
        menu
                .clickGroups()
                .clickGroups_affiliateGroups();
        groups_affiliateGroupsPage
                .checkPageIsOpen();
        menu
                .clickGroups()
                .clickGroups_physiciansGroups();
        groups_physicianGroupsPage
                .checkPageIsOpen();
        menu
                .clickGroups()
                .clickGroups_surgicalGroups();
        groups_surgicalGroupsPage
                .checkPageIsOpen();
        menu
                .clickGroups()
                .clickGroups_Groups();
        groups_groupsPage
                .checkPageIsOpen();
        user.deleteUser();
    }

    @Tag("Smoke")
    @Test
    @DisplayName("Check absence of CPT input field")
    void checkAbsenceOfCptField() {
        user.createUsersWithRole(CARE_COORDINATOR);
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
        user.createUsersWithRole(CARE_COORDINATOR);
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
        user.createUsersWithRole(CARE_COORDINATOR);
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
        user.createUsersWithRole(CARE_COORDINATOR);
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
        user.createUsersWithRole(CARE_COORDINATOR);
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