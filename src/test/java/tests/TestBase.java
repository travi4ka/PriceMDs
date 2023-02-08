package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import entities.user.User;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.authorized.administrator.archive.Administrator_ArchivePage;
import pages.authorized.administrator.caseAssign.Administrator_CaseAssignPage;
import pages.authorized.administrator.globalView.Administrator_GlobalViewPage;
import pages.authorized.administrator.messaging.Administrator_MessagingPage;
import pages.authorized.administrator.userManagement.Administrator_UserManagementPage;
import pages.authorized.caseManagement.careCoordination.CaseManagement_CareCoordinationPage;
import pages.authorized.caseManagement.patients.CaseManagement_PatientsPage;
import pages.authorized.clientAdminRoleSpecific.ChartReportPage;
import pages.authorized.clientAdminRoleSpecific.ClientPage;
import pages.authorized.clientAdminRoleSpecific.ClientReportPage;
import pages.authorized.clientManagement.clients.ClientManagement_ClientsPage;
import pages.authorized.components.Menu;
import pages.authorized.dashboard.DashboardPage;
import pages.authorized.facilityPhysicians.facility.FacilityPhysicians_FacilityPage;
import pages.authorized.facilityPhysicians.physicians.FacilityPhysicians_PhysiciansPage;
import pages.authorized.groups.affiliateGroups.Groups_AffiliateGroupsPage;
import pages.authorized.groups.groups.Groups_GroupsPage;
import pages.authorized.groups.physicianGroups.Groups_PhysicianGroupsPage;
import pages.authorized.groups.surgicalGroups.Groups_SurgicalGroupsPage;
import pages.authorized.procedureSpecialities.cptSpeciality.ProcedureSpeciality_CptSpecialityPage;
import pages.authorized.reporting.charts.Reporting_ChartsPage;
import pages.authorized.reporting.client.Reporting_ClientPage;
import pages.authorized.reporting.globalAdmin.Reporting_GlobalAdminPage;
import pages.authorized.searchFacility.SearchFacilityPage;
import pages.unauthorized.mainPage.MainPage;

import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static tests.testData.TestData.MAIN_URL;

public class TestBase {

    public Menu menu = new Menu();
    public MainPage mainPage = new MainPage();
    public DashboardPage dashboardPage = new DashboardPage();
    public SearchFacilityPage searchFacilityPage = new SearchFacilityPage();
    public CaseManagement_CareCoordinationPage caseManagement_careCoordinationPage = new CaseManagement_CareCoordinationPage();
    public CaseManagement_PatientsPage caseManagement_patientsPage = new CaseManagement_PatientsPage();
    public ClientManagement_ClientsPage clientManagement_clientsPage = new ClientManagement_ClientsPage();
    public ProcedureSpeciality_CptSpecialityPage procedureSpeciality_cptSpecialityPage = new ProcedureSpeciality_CptSpecialityPage();
    public Reporting_ClientPage reporting_clientPage = new Reporting_ClientPage();
    public Reporting_GlobalAdminPage reporting_globalAdminPage = new Reporting_GlobalAdminPage();
    public Reporting_ChartsPage reporting_chartsPage = new Reporting_ChartsPage();
    public FacilityPhysicians_FacilityPage facilityPhysicians_facilityPage = new FacilityPhysicians_FacilityPage();
    public FacilityPhysicians_PhysiciansPage facilityPhysicians_physiciansPage = new FacilityPhysicians_PhysiciansPage();
    public Groups_AffiliateGroupsPage groups_affiliateGroupsPage = new Groups_AffiliateGroupsPage();
    public Groups_PhysicianGroupsPage groups_physicianGroupsPage = new Groups_PhysicianGroupsPage();
    public Groups_GroupsPage groups_groupsPage = new Groups_GroupsPage();
    public Groups_SurgicalGroupsPage groups_surgicalGroupsPage = new Groups_SurgicalGroupsPage();
    public Administrator_ArchivePage administrator_archivePage = new Administrator_ArchivePage();
    public Administrator_CaseAssignPage administrator_caseAssignPage = new Administrator_CaseAssignPage();
    public Administrator_GlobalViewPage administrator_globalViewPage = new Administrator_GlobalViewPage();
    public Administrator_MessagingPage administrator_messagingPage = new Administrator_MessagingPage();
    public Administrator_UserManagementPage administrator_userManagementPage = new Administrator_UserManagementPage();
    public ClientPage clientPage = new ClientPage();
    public ClientReportPage clientReportPage = new ClientReportPage();
    public ChartReportPage chartReportPage = new ChartReportPage();
    public User user = new User();

    @BeforeEach
    public void beforeAll() {
        Configuration.baseUrl = MAIN_URL;
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.timeout = 10_000;
        Configuration.browser = "chrome";
       // Configuration.browserVersion = "15.0";
        //       Configuration.browser = System.getProperty("browser","chrome");
//        switch (Configuration.browser) {
//            case "chrome": Configuration.browserVersion = "100.0"; break;
//            case "opera": Configuration.browserVersion = "85.0"; break;
//            case "safari": Configuration.browserVersion = "15.0"; break;
//            case "firefox": Configuration.browserVersion = "98.0"; break;
//        }
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
      //  Configuration.remote = "http://localhost:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", false
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        screenshotAs();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] screenshotAs() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}