package tests.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static tests.testData.TestData.userRole.ADMIN;

public class PRMD_9 extends TestBase {
    @Test
    @Tag("Smoke")
    @Tag("Prod")
    @DisplayName("Check that Status / Start Date / Termination Date columns are in the table")
    void checkPresenceOfStatusStartDateTerminationDateColumns() {
        user.createUsersWithRole(ADMIN);
        mainPage.openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage.checkThatPageIsOpen();
        administrator_userManagementPage.openPage()
                .clickClientsAndEGTab();
        administrator_userManagementPage.clientsAndEmployerGroupsTab.tabIsOpen()
                .checkColumns();
        user.deleteUser();
    }


}
