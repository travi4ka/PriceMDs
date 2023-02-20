package tests.Tests.authorized;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static tests.testData.TestData.userRole.CLIENT_SERVICE;

@Tag("ClientService")
@DisplayName("Client Service tests")
public class ClientServiceTests extends TestBase {

    @Test
    @Tag("Smoke")
    @DisplayName("Check menu items")
    void checkMenuForAllRoles() {
        user.createUsersWithRole(CLIENT_SERVICE);
        mainPage
                .openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen()
                .checkMenu(CLIENT_SERVICE);
        user.deleteUser();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Check that table has column days/weeks/months")
    void checkMenuHasColumnDaysWeeksMonth() {
        user.createUsersWithRole(CLIENT_SERVICE);
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
    @Tag("Regression")
    @Disabled
    @DisplayName("Check that table can be sorted by days/weeks/months (ASC)")
    void checkMenuCanBeSortedByDaysWeeksMonthAsc() {
        //todo
        mainPage
                .openPage()
                .enterCredentialsForMainAdmin()
              //  .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen()
                .clickDaysWeeksMonthsColumn()
                .checkThatColumnIsSortedByAsc();
    }

    @Test
    @Tag("Regression")
    @Disabled
    @DisplayName("Check that table can be sorted by days/weeks/months (DESC)")
    void checkMenuCanBeSortedByDaysWeeksMonthDesc() {
        //todo
        mainPage
                .openPage()
                .enterCredentialsForMainAdmin()
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen()
                .clickDaysWeeksMonthsColumn()
                .clickDaysWeeksMonthsColumn();
        dashboardPage.checkThatColumnIsSortedByDesc();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Check all pages can be open for Client Service")
    void checkAllPAgesCanBeOpenForClientService() {
        user.createUsersWithRole(CLIENT_SERVICE);
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
        user.deleteUser();
    }

}
