package tests.Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.TestBase;

import static tests.testData.TestData.userRole.*;


public class Tests extends TestBase {
    @org.junit.Test
    @DisplayName("Check menu items")
    @ParameterizedTest(name = "Check menu items for {0} role")
    @CsvSource({ADMIN, NURSE, CLIENT_ADMIN, CARE_COORDINATOR, DEVELOPER, NET_DEV_DIR, CLIENT_SERVICE})
    void checkMenuForAllRoles(String role) {
        mainPage
                .openPage()
                .enterUserCredentials(role)
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen()
                .checkMenu(role);
    }

    @Test
    @DisplayName("Check all pages can be open for Admin")
    void checkAllPAgesCanBeOpenForAdmin() {
        mainPage
                .openPage()
                .enterUserCredentials(ADMIN)
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen();
        menu
                .clickSearchFacilities();
        searchFacilityPage
                .checkPageIsOpen();
        menu
                .clickCaseManagement()
                .clickCaseManagement_careCoordination();
        caseManagement_careCoordinationPage
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
        clientManagement_clientsPage
                .checkPageIsOpen();
        menu
                .clickClientManagement()
                .clickClientManagement_addNewEmpGroup();
        clientManagement_clientsPage
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
        menu
                .clickAdministrator()
                .clickAdministrator_userManagement();
        administrator_userManagementPage
                .checkPageIsOpen();
        menu
                .clickAdministrator()
                .clickAdministrator_caseAssign();
        administrator_caseAssignPage
                .checkPageIsOpen();
        menu
                .clickAdministrator()
                .clickAdministrator_globalView();
        administrator_globalViewPage
                .checkPageIsOpen();
        menu
                .clickAdministrator()
                .clickAdministrator_archive();
        administrator_archivePage
                .checkPageIsOpen();
        menu
                .clickAdministrator()
                .clickAdministrator_messaging();
        administrator_messagingPage
                .checkPageIsOpen();
    }

    @Test
    @DisplayName("Check all pages can be open for Nurse")
    void checkAllPAgesCanBeOpenForNurse() {
        mainPage
                .openPage()
                .enterUserCredentials(NURSE)
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
    }

    @Test
    @DisplayName("Check all pages can be open for Client Service")
    void checkAllPAgesCanBeOpenForClientService() {
        mainPage
                .openPage()
                .enterUserCredentials(CLIENT_SERVICE)
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen();
        menu
                .clickSearchFacilities();
        searchFacilityPage
                .checkPageIsOpen();
        menu
                .clickClientManagement()
                .clickClientManagement_clients();
        clientManagement_clientsPage
                .checkPageIsOpen();
        menu
                .clickClientManagement()
                .clickClientManagement_addNewClient();
        clientManagement_clientsPage
                .checkPageIsOpen();
        menu
                .clickClientManagement()
                .clickClientManagement_addNewEmpGroup();
        clientManagement_clientsPage
                .checkPageIsOpen();
        menu
                .clickReporting()
                .clickReporting_client();
        reporting_clientPage
                .checkPageIsOpen();
    }

    @Test
    @DisplayName("Check all pages can be open for Care Coordinator")
    void checkAllPAgesCanBeOpenForCareCoordinator() {
        mainPage
                .openPage()
                .enterUserCredentials(CARE_COORDINATOR)
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
        clientManagement_clientsPage
                .checkPageIsOpen();
        menu
                .clickClientManagement()
                .clickClientManagement_addNewEmpGroup();
        clientManagement_clientsPage
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
    }

    @Test
    @DisplayName("Check all pages can be open for Net Dev Dir")
    void checkAllPAgesCanBeOpenForNetDevDir() {
        mainPage
                .openPage()
                .enterUserCredentials(NET_DEV_DIR)
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen();
        menu
                .clickReporting()
                .clickReporting_client();
        reporting_clientPage
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
    }

    @Test
    @DisplayName("Check all pages can be open for Client Admin")
    void checkAllPAgesCanBeOpenForClientAdmin() {
        mainPage
                .openPage()
                .enterUserCredentials(CLIENT_ADMIN)
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen();
        menu
                .clickClientAdmin_client();
        clientPage
                .checkPageIsOpen();
        menu
                .clickClientAdmin_clientReport();
        clientReportPage
                .checkPageIsOpen();
        menu
                .clickClientAdmin_chartReport();
        chartReportPage
                .checkPageIsOpen();

    }

    @Test
    @DisplayName("Check all pages can be open for Developer")
    void checkAllPAgesCanBeOpenForDeveloper() {
        mainPage
                .openPage()
                .enterUserCredentials(DEVELOPER)
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen();
        menu
                .clickSearchFacilities();
        searchFacilityPage
                .checkPageIsOpen();
        menu
                .clickCaseManagement()
                .clickCaseManagement_careCoordination();
        caseManagement_careCoordinationPage
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
        clientManagement_clientsPage
                .checkPageIsOpen();
        menu
                .clickClientManagement()
                .clickClientManagement_addNewEmpGroup();
        clientManagement_clientsPage
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
    }

    @org.junit.Test
    @DisplayName("Check absence of CPT input field")
    @ParameterizedTest(name = "Check absence of CPT input field for {0} role")
    @CsvSource({NURSE, CARE_COORDINATOR})
    void checkAbsenceOfCptField(String role) {
        mainPage
                .openPage()
                .enterUserCredentials(role)
                .clickSignInButton();
        menu
                .clickSearchFacilities();
        searchFacilityPage
                .checkPageIsOpen()
                .checkAbsenceOfCptInputField();
    }

    @org.junit.Test
    @DisplayName("Check that DOB of patient displays on the patients case page")
    @ParameterizedTest(name = "Check that DOB of patient displays on the patients case page for {0} role")
    @CsvSource({NURSE, CARE_COORDINATOR, ADMIN, DEVELOPER})
    void checkDobShows(String role) {
        mainPage
                .openPage()
                .enterUserCredentials(role)
                .clickSignInButton();
        menu
                .clickCaseManagement()
                .clickCaseManagement_patients();
        caseManagement_patientsPage
                .checkPageIsOpen()
                .checkDobDisplays();
    }
}
