package tests.Tests.authorized;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static tests.testData.TestData.userRole.ADMIN;

@Tag("Admin")
@DisplayName("Admin tests")
public class AdminTests extends TestBase {

    @Test
    @Tag("Smoke")
    @DisplayName("Check menu items")
    void checkMenuForAllRoles() {
        user.createUsersWithRole(ADMIN);
        mainPage.openPage().enterUserCredentials(user).clickSignInButton();
        dashboardPage.checkThatPageIsOpen().checkMenu(ADMIN);
        user.deleteUser();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Check all pages can be open for Admin")
    void checkAllPAgesCanBeOpenForAdmin() {
        user.createUsersWithRole(ADMIN);
        mainPage.openPage().enterUserCredentials(user).clickSignInButton();
        dashboardPage.checkThatPageIsOpen();
        menu.clickSearchFacilities();
        searchFacilityPage.checkPageIsOpen();
        menu.clickCaseManagement().clickCaseManagement_careCoordination();
        caseManagement_careCoordinationPage.checkPageIsOpen();
        menu.clickCaseManagement().clickCaseManagement_patients();
        caseManagement_patientsPage.checkPageIsOpen();
        menu.clickClientManagement().clickClientManagement_clients();
        clientManagement_clientsPage.checkPageIsOpen();
        menu.clickClientManagement().clickClientManagement_addNewClient();
        clientManagement_addNewClientPage.checkPageIsOpen();
        menu.clickProcedureSpecialties().clickProcedureSpecialties_cpt();
        procedureSpeciality_cptSpecialityPage.checkPageIsOpen();
        menu.clickReporting().clickReporting_client();
        reporting_clientPage.checkPageIsOpen();
        menu.clickReporting().clickReporting_globalAdmin();
        reporting_globalAdminPage.checkPageIsOpen();
        menu.clickReporting().clickReporting_charts();
        reporting_chartsPage.checkPageIsOpen();
        menu.clickFacilityPhysicians().clickFacilityPhysicians_Facility();
        facilityPhysicians_facilityPage.checkPageIsOpen();
        menu.clickFacilityPhysicians().clickFacilityPhysicians_Physicians();
        facilityPhysicians_physiciansPage.checkPageIsOpen();
        menu.clickGroups().clickGroups_affiliateGroups();
        groups_affiliateGroupsPage.checkPageIsOpen();
        menu.clickGroups().clickGroups_physiciansGroups();
        groups_physicianGroupsPage.checkPageIsOpen();
        menu.clickGroups().clickGroups_surgicalGroups();
        groups_surgicalGroupsPage.checkPageIsOpen();
        menu.clickGroups().clickGroups_Groups();
        groups_groupsPage.checkPageIsOpen();
        menu.clickAdministrator().clickAdministrator_userManagement();
        administrator_userManagementPage.checkPageIsOpen();
        menu.clickAdministrator().clickAdministrator_caseAssign();
        administrator_caseAssignPage.checkPageIsOpen();
        menu.clickAdministrator().clickAdministrator_globalView();
        administrator_globalViewPage.checkPageIsOpen();
        menu.clickAdministrator().clickAdministrator_archive();
        administrator_archivePage.checkPageIsOpen();
        menu.clickAdministrator().clickAdministrator_messaging();
        administrator_messagingPage.checkPageIsOpen();
        user.deleteUser();
    }

    @Tag("Smoke")
    @Test
    @DisplayName("Check that DOB of patient displays on the patients case page")
    void checkDobShows() {
        user.createUsersWithRole(ADMIN);
        mainPage.openPage().enterUserCredentials(user).clickSignInButton();
        menu.clickCaseManagement().clickCaseManagement_patients();
        caseManagement_patientsPage.checkPageIsOpen();
        String firstDOBOnTable = caseManagement_patientsPage.getDobOfFirstElementOnTheTable();
        caseManagement_patientsPage.clickFirstOpenFileButton();
        caseManagement_patientsPage.newCaseTab.checkThatOpen().checkDobDisplays(firstDOBOnTable);
        user.deleteUser();
    }

    @Tag("Smoke")
    @Story("PRMD-7")
    @Test
    @DisplayName("Check elements on the Clients page")
    void checkElementsOnTheClientsPage() {
        user.createUsersWithRole(ADMIN);
        mainPage.openPage().enterUserCredentials(user).clickSignInButton();
        dashboardPage.checkThatPageIsOpen();
        clientManagement_clientsPage.openPage().checkElementsOnThePage();
        user.deleteUser();
    }

    @Test
    @Story("PRMD-7")
    @Tag("Smoke")
    @DisplayName("Check That Status Column Contains Only Active status")
    void checkThatStatusColumnContainsOnlyActive() {
        user.createUsersWithRole(ADMIN);
        mainPage.openPage().enterUserCredentials(user).clickSignInButton();
        dashboardPage.checkThatPageIsOpen();
        clientManagement_clientsPage.openPage()
                .checkThatStatusColumnContainsOnlyStatus("Active");
        user.deleteUser();
    }

    @Test
    @Story("PRMD-7")
    @Tag("Smoke")
    @DisplayName("Check That Status Column Contains Only Termed status")
    void checkThatStatusColumnContainsOnlyTermed() {
        user.createUsersWithRole(ADMIN);
        mainPage.openPage().enterUserCredentials(user).clickSignInButton();
        dashboardPage.checkThatPageIsOpen();
        clientManagement_clientsPage.openPage()
                .checkThatStatusColumnContainsOnlyStatus("Termed");
        user.deleteUser();
    }
    @Test
    void koko(){
        open("");
        client.createClient();
        client.deleteClient();
    }
}
