package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static tests.testData.TestData.roleMenu.roleMenu;

public class Menu {
    final SelenideElement
            sideLeftMenu = $("#mainnav-menu"),
            dashboard = sideLeftMenu.$(byText("Dashboard")),
            searchFacility = sideLeftMenu.$(byText("PriceMDs Directory Search")),
            caseManagement = sideLeftMenu.$(byText("Case Management")),
            caseManagement_careCoordination = sideLeftMenu.$(byText("Care Coordination")),
            caseManagement_patients = sideLeftMenu.$(byText("Patients")),
            clientManagement = sideLeftMenu.$(byText("Client Management")),
            clientManagement_clients = sideLeftMenu.$(byText("Clients")),
            clientManagement_addNewClient = sideLeftMenu.$(byText("Add New Client")),
            clientManagement_addNewEmployerGroup = sideLeftMenu.$(byText("Add New Employer Group")),
            procedureSpecialties = sideLeftMenu.$(byText("Procedure & Specialties")),
            procedureSpecialties_cptSpecialties = sideLeftMenu.$(byText("CPT & Specialty")),
            reporting = sideLeftMenu.$(byText("Reporting")),
            reporting_client = sideLeftMenu.$(byText("Client")),
            reporting_globalAdmin = sideLeftMenu.$(byText("Global Admin")),
            reporting_charts = sideLeftMenu.$(byText("Charts")),
            facilityPhysicians = sideLeftMenu.$(byText("Facility & Physicians")),
            facilityPhysicians_facility = sideLeftMenu.$(byText("Facility")),
            facilityPhysicians_physicians = sideLeftMenu.$(byText("Physicians")),
            facilityPhysicians_downloadFacilities = sideLeftMenu.$(byText("Download Facilities")),
            groups = sideLeftMenu.$(byText("Groups")),
            groups_affiliateGroups = sideLeftMenu.$(byText("Affiliate Groups")),
            groups_physicianGroups = sideLeftMenu.$(byText("Physician Groups")),
            groups_surgicalGroups = sideLeftMenu.$(byText("Surgical Groups")),
            groups_groups = sideLeftMenu.$("a[href='../admin/groups.php']"),
            administrator = sideLeftMenu.$(byText("Administrator")),
            administrator_userManagement = sideLeftMenu.$(byText("User Management")),
            administrator_caseAssign = sideLeftMenu.$(byText("Case Assign")),
            administrator_globalView = sideLeftMenu.$(byText("Global View")),
            administrator_archive = sideLeftMenu.$(byText("Archive")),
            administrator_messaging = sideLeftMenu.$(byText("Messaging")),
            clientAdmin_client = $("a[href='../admin/clientAdministrator.php']"),
            clientAdmin_clientReport = $("a[href='../reporting/clientAdminReports.php']"),
            clientAdmin_chartReport = $("a[href='../reporting/AdministrationChartReporting.php']");

    @Step("Click ClientAdmin_client")
    public Menu clickClientAdmin_client() {
        clientAdmin_client.click();
        return this;
    }

    @Step("Click ClientAdmin_clientReport")
    public Menu clickClientAdmin_clientReport() {
        clientAdmin_clientReport.click();
        return this;
    }

    @Step("Click ClientAdmin_chartReport")
    public Menu clickClientAdmin_chartReport() {
        clientAdmin_chartReport.click();
        return this;
    }

    @Step("Click Administrator")
    public Menu clickAdministrator() {
        administrator.click();
        return this;
    }

    @Step("Click Administrator -> Archive")
    public Menu clickAdministrator_archive() {
        administrator_archive.click();
        return this;
    }

    @Step("Click Administrator -> Case Assign")
    public Menu clickAdministrator_caseAssign() {
        administrator_caseAssign.click();
        return this;
    }

    @Step("Click Administrator -> Global View")
    public Menu clickAdministrator_globalView() {
        administrator_globalView.click();
        return this;
    }

    @Step("Click Administrator -> User Management")
    public Menu clickAdministrator_userManagement() {
        administrator_userManagement.click();
        return this;
    }

    @Step("Click Administrator -> Messaging")
    public Menu clickAdministrator_messaging() {
        administrator_messaging.click();
        return this;
    }

    @Step("Click Dashboard")
    public Menu clickDashboard() {
        dashboard.click();
        return this;
    }

    @Step("Click PriceMDs Directory Search")
    public Menu clickSearchFacilities() {
        searchFacility.click();
        return this;
    }

    @Step("Click Case Management")
    public Menu clickCaseManagement() {
        caseManagement.click();
        return this;
    }

    @Step("Click Case Management -> Care Coordination")
    public Menu clickCaseManagement_careCoordination() {
        caseManagement_careCoordination.click();
        return this;
    }

    @Step("Click Case Management -> Patients")
    public Menu clickCaseManagement_patients() {
        caseManagement_patients.click();
        return this;
    }

    @Step("Click Client Management")
    public Menu clickClientManagement() {
        clientManagement.click();
        return this;
    }

    @Step("Click Client Management -> Clients")
    public Menu clickClientManagement_clients() {
        clientManagement_clients.click();
        return this;
    }

    @Step("Click Client Management -> Add New Client")
    public Menu clickClientManagement_addNewClient() {
        clientManagement_addNewClient.click();
        return this;
    }

    @Step("Click Client Management -> Add New Employer Group")
    public Menu clickClientManagement_addNewEmpGroup() {
        clientManagement_addNewEmployerGroup.click();
        return this;
    }

    @Step("Click Procedure & Specialties")
    public Menu clickProcedureSpecialties() {
        procedureSpecialties.click();
        return this;
    }

    @Step("Click Procedure & Specialties -> CPT & Specialty")
    public Menu clickProcedureSpecialties_cpt() {
        procedureSpecialties_cptSpecialties.click();
        return this;
    }

    @Step("Click Reporting")
    public Menu clickReporting() {
        reporting.click();
        return this;
    }

    @Step("Click Reporting -> Client")
    public Menu clickReporting_client() {
        reporting_client.click();
        return this;
    }

    @Step("Click Reporting -> Global Admin")
    public Menu clickReporting_globalAdmin() {
        reporting_globalAdmin.click();
        return this;
    }

    @Step("Click Reporting -> Charts")
    public Menu clickReporting_charts() {
        reporting_charts.click();
        return this;
    }

    @Step("Click Facility & Physicians")
    public Menu clickFacilityPhysicians() {
        facilityPhysicians.click();
        return this;
    }

    @Step("Click Facility & Physicians -> Facility")
    public Menu clickFacilityPhysicians_Facility() {
        facilityPhysicians_facility.click();
        return this;
    }

    @Step("Click Facility & Physicians -> Physicians")
    public Menu clickFacilityPhysicians_Physicians() {
        facilityPhysicians_physicians.click();
        return this;
    }

    @Step("Click Groups")
    public Menu clickGroups() {
        groups.click();
        return this;
    }

    @Step("Click Groups -> Affiliate Groups")
    public Menu clickGroups_affiliateGroups() {
        groups_affiliateGroups.click();
        return this;
    }

    @Step("Click Groups -> Physicians Groups")
    public Menu clickGroups_physiciansGroups() {
        groups_physicianGroups.click();
        return this;
    }

    @Step("Click Groups -> Surgical Groups")
    public Menu clickGroups_surgicalGroups() {
        groups_surgicalGroups.click();
        return this;
    }

    @Step("Click Groups -> Groups")
    public Menu clickGroups_Groups() {
        groups_groups.click();
        return this;
    }

    public Menu checkMenu(String role) {
        List<String> menu = new ArrayList<>();
        for (SelenideElement value : sideLeftMenu.findAll("a")) {
            if (value.getText().equals("")) {
                menu.add(value.getOwnText().trim());
            } else menu.add(value.getText().trim());
        }
        String menuActual = menu.toString().replace("[", "").replace("]", "");
        for (String[] line : roleMenu) {
            if (line[0].equals(role)) {
                Assertions.assertEquals(line[1], menuActual);
            }
        }
        return this;
    }
}
