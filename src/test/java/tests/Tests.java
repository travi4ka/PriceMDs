package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static tests.testData.TestData.userRole.*;

public class Tests extends TestBase {

    @ParameterizedTest
    @Tag("Smoke")
    @Tag("Prod")
    @DisplayName("Check menu items for ")
    @CsvSource({ADMIN, NURSE, CLIENT_SERVICE, CLIENT_ADMIN, CARE_COORDINATOR, NET_DEV_DIR})
    void checkMenuForAllRoles(String role) {
        user.createUsersWithRole(role);
        mainPage.openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage.checkThatPageIsOpen()
                .checkMenu(role);
        user.deleteUser();
    }

    @ParameterizedTest
    @Tag("Smoke")
    @Tag("Prod")
    @DisplayName("Check that DOB of patient displays on the patients case page")
    @CsvSource({ADMIN, NURSE, CARE_COORDINATOR})
    void checkDobShows(String role) {
        user.createUsersWithRole(role);
        mainPage.openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage.checkThatPageIsOpen();
        caseManagement_patientsPage.openPage();
        String firstDOBOnTable = caseManagement_patientsPage.getDobOfFirstElementOnTheTable();
        caseManagement_patientsPage.clickFirstOpenFileButton();
        caseManagement_patientsPage.newCaseTab.checkThatOpen()
                .checkDobDisplays(firstDOBOnTable);
        user.deleteUser();
    }

    @ParameterizedTest
    @Tag("Smoke")
    @Tag("Prod")
    @Story("PRMD-7")
    @DisplayName("Check elements on the Clients page")
    @CsvSource({ADMIN, CLIENT_SERVICE, CLIENT_ADMIN, CARE_COORDINATOR})
    void checkElementsOnTheClientsPage(String role) {
        user.createUsersWithRole(role);
        mainPage.openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage.checkThatPageIsOpen();
        clientManagement_clientsPage.openPage()
                .checkElementsOnThePage(role);
        user.deleteUser();
    }

    @ParameterizedTest
    @Story("PRMD-7")
    @Tag("Smoke")
    @Tag("Prod")
    @DisplayName("Check That Status Column Contains Only Active status")
    @CsvSource({ADMIN, CLIENT_SERVICE, CLIENT_ADMIN, CARE_COORDINATOR})
    void checkThatStatusColumnContainsOnlyActive(String role) {
        user.createUsersWithRole(role);
        mainPage.openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage.checkThatPageIsOpen();
        clientManagement_clientsPage.openPage()
                .checkThatStatusColumnContainsOnlyStatus("Active");
        user.deleteUser();
    }

    @ParameterizedTest
    @Story("PRMD-7")
    @Tag("Smoke")
    @Tag("Prod")
    @DisplayName("Check That Status Column Contains Only Termed status")
    @CsvSource({ADMIN, CLIENT_SERVICE, CLIENT_ADMIN, CARE_COORDINATOR})
    void checkThatStatusColumnContainsOnlyTermed(String role) {
        user.createUsersWithRole(role);
        mainPage.openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage.checkThatPageIsOpen();
        clientManagement_clientsPage.openPage()
                .checkThatStatusColumnContainsOnlyStatus("Termed");
        user.deleteUser();
    }

    @ParameterizedTest
    @Tag("Smoke")
    @Tag("Prod")
    @DisplayName("Check absence of CPT input field")
    @CsvSource({CARE_COORDINATOR, NURSE})
    void checkAbsenceOfCptField(String role) {
        user.createUsersWithRole(role);
        mainPage.openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage.checkThatPageIsOpen();
        searchFacilityPage.openPage()
                .checkAbsenceOfCptInputField();
        user.deleteUser();
    }

    @ParameterizedTest
    @Tag("Smoke")
    @Tag("Prod")
    @DisplayName("Check that table has column days/weeks/months")
    @CsvSource({ADMIN, CLIENT_ADMIN, CARE_COORDINATOR, CLIENT_SERVICE, NET_DEV_DIR, NURSE})
    void checkMenuHasColumnDaysWeeksMonth(String role) {
        user.createUsersWithRole(role);
        mainPage.openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage.checkThatPageIsOpen()
                .checkDaysMonthsWeeksColumn();
        user.deleteUser();
    }

    @ParameterizedTest
    @Tag("Smoke")
    @Tag("Prod")
    @Story("PRMD-35")
    @DisplayName("Check that table can be sorted by days/weeks/months (ASC)")
    @CsvSource({ADMIN, CLIENT_ADMIN, CARE_COORDINATOR, CLIENT_SERVICE, NET_DEV_DIR, NURSE})
    void checkMenuCanBeSortedByDaysWeeksMonthAsc(String role) {
        user.createUsersWithRole(role);
        mainPage.openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage.checkThatPageIsOpen()
                .clickDaysWeeksMonthsColumn()
                .checkThatColumnIsSortedByAsc();
        user.deleteUser();
    }

    @ParameterizedTest
    @Tag("Smoke")
    @Tag("Prod")
    @Story("PRMD-35")
    @DisplayName("Check that table can be sorted by days/weeks/months (DESC)")
    @CsvSource({ADMIN, CLIENT_ADMIN, CARE_COORDINATOR, CLIENT_SERVICE, NET_DEV_DIR, NURSE})
    void checkMenuCanBeSortedByDaysWeeksMonthDesc(String role) {
        user.createUsersWithRole(role);
        mainPage.openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage.checkThatPageIsOpen()
                .clickDaysWeeksMonthsColumn()
                .clickDaysWeeksMonthsColumn();
        dashboardPage.checkThatColumnIsSortedByDesc();
        user.deleteUser();
    }

    @Test
    @Tag("Smoke")
    @Tag("Prod")
    @DisplayName("Check all pages can be open for Admin")
    void checkAllPAgesCanBeOpenForAdmin() {
        user.createUsersWithRole(ADMIN);
        mainPage.openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage.checkThatPageIsOpen();
        menu.clickSearchFacilities();
        searchFacilityPage.checkPageIsOpen();
        menu.clickCaseManagement()
                .clickCaseManagement_careCoordination();
        caseManagement_careCoordinationPage.checkPageIsOpen();
        menu.clickCaseManagement()
                .clickCaseManagement_patients();
        caseManagement_patientsPage.checkPageIsOpen();
        menu.clickClientManagement()
                .clickClientManagement_clients();
        clientManagement_clientsPage.checkPageIsOpen();
        menu.clickClientManagement()
                .clickClientManagement_addNewClient();
        clientManagement_addNewClientPage.checkPageIsOpen();
        menu.clickProcedureSpecialties()
                .clickProcedureSpecialties_cpt();
        procedureSpeciality_cptSpecialityPage.checkPageIsOpen();
        menu.clickReporting()
                .clickReporting_client();
        reporting_clientPage.checkPageIsOpen();
        menu.clickReporting()
                .clickReporting_globalAdmin();
        reporting_globalAdminPage.checkPageIsOpen();
        menu.clickReporting()
                .clickReporting_charts();
        reporting_chartsPage.checkPageIsOpen();
        menu.clickFacilityPhysicians()
                .clickFacilityPhysicians_Facility();
        facilityPhysicians_facilityPage.checkPageIsOpen();
        menu.clickFacilityPhysicians()
                .clickFacilityPhysicians_Physicians();
        facilityPhysicians_physiciansPage.checkPageIsOpen();
        menu.clickGroups()
                .clickGroups_affiliateGroups();
        groups_affiliateGroupsPage.checkPageIsOpen();
        menu.clickGroups()
                .clickGroups_physiciansGroups();
        groups_physicianGroupsPage.checkPageIsOpen();
        menu.clickGroups()
                .clickGroups_surgicalGroups();
        groups_surgicalGroupsPage.checkPageIsOpen();
        menu.clickGroups()
                .clickGroups_Groups();
        groups_groupsPage.checkPageIsOpen();
        menu.clickAdministrator()
                .clickAdministrator_userManagement();
        administrator_userManagementPage.pageIsOpen();
        menu.clickAdministrator()
                .clickAdministrator_caseAssign();
        administrator_caseAssignPage.checkPageIsOpen();
        menu.clickAdministrator()
                .clickAdministrator_globalView();
        administrator_globalViewPage.checkPageIsOpen();
        menu.clickAdministrator()
                .clickAdministrator_archive();
        administrator_archivePage.checkPageIsOpen();
        menu.clickAdministrator()
                .clickAdministrator_messaging();
        administrator_messagingPage.checkPageIsOpen();
        user.deleteUser();
    }

    @Test
    @Tag("Smoke")
    @Tag("Prod")
    @DisplayName("Check all pages can be open for Care Coordinator")
    void checkAllPAgesCanBeOpenForCareCoordinator() {
        user.createUsersWithRole(CARE_COORDINATOR);
        mainPage.openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage.checkThatPageIsOpen();
        menu.clickSearchFacilities();
        searchFacilityPage.checkPageIsOpen();
        menu.clickCaseManagement()
                .clickCaseManagement_patients();
        caseManagement_patientsPage.checkPageIsOpen();
        menu.clickClientManagement()
                .clickClientManagement_clients();
        clientManagement_clientsPage.checkPageIsOpen();
        menu.clickClientManagement()
                .clickClientManagement_addNewClient();
        clientManagement_addNewClientPage.checkPageIsOpen();
        menu.clickProcedureSpecialties()
                .clickProcedureSpecialties_cpt();
        procedureSpeciality_cptSpecialityPage.checkPageIsOpen();
        menu.clickReporting()
                .clickReporting_client();
        reporting_clientPage.checkPageIsOpen();
        menu.clickReporting()
                .clickReporting_globalAdmin();
        reporting_globalAdminPage.checkPageIsOpen();
        menu.clickReporting()
                .clickReporting_charts();
        reporting_chartsPage.checkPageIsOpen();
        menu.clickFacilityPhysicians()
                .clickFacilityPhysicians_Facility();
        facilityPhysicians_facilityPage.checkPageIsOpen();
        menu.clickFacilityPhysicians()
                .clickFacilityPhysicians_Physicians();
        facilityPhysicians_physiciansPage.checkPageIsOpen();
        menu.clickGroups()
                .clickGroups_affiliateGroups();
        groups_affiliateGroupsPage.checkPageIsOpen();
        menu.clickGroups()
                .clickGroups_physiciansGroups();
        groups_physicianGroupsPage.checkPageIsOpen();
        menu.clickGroups()
                .clickGroups_surgicalGroups();
        groups_surgicalGroupsPage.checkPageIsOpen();
        menu.clickGroups()
                .clickGroups_Groups();
        groups_groupsPage.checkPageIsOpen();
        user.deleteUser();
    }

    @Test
    @Tag("Smoke")
    @Tag("Prod")
    @DisplayName("Check all pages can be open for Client Admin")
    void checkAllPAgesCanBeOpenForClientAdmin() {
        user.createUsersWithRole(CLIENT_ADMIN);
        mainPage.openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage.checkThatPageIsOpen();
        menu.clickClientAdmin_client();
        clientManagement_clientsPage.checkPageIsOpen();
        menu.clickClientAdmin_clientReport();
        clientReportPage.checkPageIsOpen();
        menu.clickClientAdmin_chartReport();
        chartReportPage.checkPageIsOpen();
        user.deleteUser();
    }

    @Test
    @Tag("Smoke")
    @Tag("Prod")
    @DisplayName("Check all pages can be open for Client Service")
    void checkAllPAgesCanBeOpenForClientService() {
        user.createUsersWithRole(CLIENT_SERVICE);
        mainPage.openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage.checkThatPageIsOpen();
        menu.clickSearchFacilities();
        searchFacilityPage.checkPageIsOpen();
        menu.clickClientManagement()
                .clickClientManagement_clients();
        clientManagement_clientsPage.checkPageIsOpen();
        menu.clickClientManagement()
                .clickClientManagement_addNewClient();
        clientManagement_addNewClientPage.checkPageIsOpen();
        menu.clickReporting()
                .clickReporting_client();
        reporting_clientPage.checkPageIsOpen();
        user.deleteUser();
    }

    @Test
    @Tag("Smoke")
    @Tag("Prod")
    @DisplayName("Check all pages can be open for Net Dev Dir")
    void checkAllPAgesCanBeOpenForNetDevDir() {
        user.createUsersWithRole(NET_DEV_DIR);
        mainPage.openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage.checkThatPageIsOpen();
        menu.clickReporting()
                .clickReporting_client();
        reporting_clientPage.checkPageIsOpen();
        menu.clickFacilityPhysicians()
                .clickFacilityPhysicians_Facility();
        facilityPhysicians_facilityPage.checkPageIsOpen();
        menu.clickFacilityPhysicians()
                .clickFacilityPhysicians_Physicians();
        facilityPhysicians_physiciansPage.checkPageIsOpen();
        menu.clickGroups()
                .clickGroups_affiliateGroups();
        groups_affiliateGroupsPage.checkPageIsOpen();
        menu.clickGroups()
                .clickGroups_physiciansGroups();
        groups_physicianGroupsPage.checkPageIsOpen();
        menu.clickGroups()
                .clickGroups_surgicalGroups();
        groups_surgicalGroupsPage.checkPageIsOpen();
        menu.clickGroups()
                .clickGroups_Groups();
        groups_groupsPage.checkPageIsOpen();
        user.deleteUser();
    }

    @Test
    @Tag("Smoke")
    @Tag("Prod")
    @Tag("qa_guru")
    @DisplayName("Check all pages can be open for Nurse")
    void checkAllPAgesCanBeOpenForNurse() {
        user.createUsersWithRole(NURSE);
        mainPage.openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage.checkThatPageIsOpen();
        menu.clickSearchFacilities();
        searchFacilityPage.checkPageIsOpen();
        menu.clickCaseManagement()
                .clickCaseManagement_patients();
        caseManagement_patientsPage.checkPageIsOpen();
        menu.clickReporting()
                .clickReporting_client();
        reporting_clientPage.checkPageIsOpen();
        menu.clickReporting()
                .clickReporting_charts();
        reporting_chartsPage.checkPageIsOpen();
        user.deleteUser();
    }

    @Test
    @Tag("Smoke")
    @Tag("Prod")
    @DisplayName("Check forgot password flow with valid data")
    void checkForgotPasswordFlowWithValidData() {
        user.createRandomUser();
        mainPage.openPage()
                .clickForgotPassword();
        forgotPasswordPage.checkPageIsOpen()
                .enterEmail(user)
                .clickResetPasswordButton()
                .checkSuccessMessageAppears();
        user.deleteUser();
    }
}
