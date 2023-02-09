package tests.Tests.authorized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static tests.testData.TestData.userRole.NET_DEV_DIR;

@Tag("NetDevDir")
@DisplayName("Network Development Director tests")
public class NetDevDirTests extends TestBase {

    @Test
    @Tag("Smoke")
    @DisplayName("Check menu items")
    void checkMenuForAllRoles() {
        user.createUsersWithRole(NET_DEV_DIR);
        mainPage
                .openPage()
                .enterUserCredentials(user)
                .clickSignInButton();
        dashboardPage
                .checkThatPageIsOpen()
                .checkMenu(NET_DEV_DIR);
        user.deleteUser();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Check all pages can be open for Net Dev Dir")
    void checkAllPAgesCanBeOpenForNetDevDir() {
        user.createUsersWithRole(NET_DEV_DIR);
        mainPage
                .openPage()
                .enterUserCredentials(user)
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
        user.deleteUser();
    }
}
