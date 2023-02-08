package tests.Tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static tests.testData.TestData.userRole.ADMIN;
import static tests.testData.TestData.userRole.DEVELOPER;

@Tag("Developer")
public class DeveloperTests extends TestBase {
    ParamTests paramTests = new ParamTests();

    @Test
    @Tag("Smoke")
    @Disabled
    @DisplayName("Check menu items")
    void checkMenuForAllRoles() {
        paramTests.checkMenuForAllRoles(DEVELOPER);
    }

    @Test
    @Tag("Smoke")
    @Disabled
    @DisplayName("Check all pages can be open for Developer")
    void checkAllPAgesCanBeOpenForDeveloper() {
        user.createUsersWithRole(DEVELOPER);
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
        user.deleteUser();
    }

    @Tag("Smoke")
    @Test
    @Disabled
    @DisplayName("Check that DOB of patient displays on the patients case page")
    void checkDobShows() {
        paramTests.checkDobShows(ADMIN);
    }
}
