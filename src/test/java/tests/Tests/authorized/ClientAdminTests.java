package tests.Tests.authorized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static tests.testData.TestData.userRole.CLIENT_ADMIN;

@Tag("ClientAdmin")
@DisplayName("Client Admin tests")
public class ClientAdminTests extends TestBase {

    @Test
    @Tag("Smoke")
    @DisplayName("Check menu items")
    void checkMenuForAllRoles() {
        user.createUsersWithRole(CLIENT_ADMIN);
        mainPage
                .openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen()
                .checkMenu(CLIENT_ADMIN);
        user.deleteUser();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Check all pages can be open for Client Admin")
    void checkAllPAgesCanBeOpenForClientAdmin() {
        user.createUsersWithRole(CLIENT_ADMIN);
        mainPage
                .openPage()
                .enterUserCredentials(user)
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
        user.deleteUser();
    }
}
