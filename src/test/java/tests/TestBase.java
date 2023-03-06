package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverProvider;
import entities.Client;
import entities.Patient;
import entities.User;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.authorized.administrator.archive.Administrator_ArchivePage;
import pages.authorized.administrator.caseassign.Administrator_CaseAssignPage;
import pages.authorized.administrator.globalview.Administrator_GlobalViewPage;
import pages.authorized.administrator.messaging.Administrator_MessagingPage;
import pages.authorized.administrator.usermanagement.Administrator_UserManagementPage;
import pages.authorized.casemanagement.carecoordination.CaseManagement_CareCoordinationPage;
import pages.authorized.casemanagement.patients.CaseManagement_PatientsPage;
import pages.authorized.clientadminrolespecific.ChartReportPage;
import pages.authorized.clientadminrolespecific.ClientReportPage;
import pages.authorized.clientmanagement.ClientManagement_AddNewClientPage;
import pages.authorized.clientmanagement.ClientManagement_ClientsPage;
import pages.authorized.dashboard.DashboardPage;
import pages.authorized.facilityphysicians.facility.FacilityPhysicians_FacilityPage;
import pages.authorized.facilityphysicians.physicians.FacilityPhysicians_PhysiciansPage;
import pages.authorized.groups.affiliategroups.Groups_AffiliateGroupsPage;
import pages.authorized.groups.groups.Groups_GroupsPage;
import pages.authorized.groups.physiciangroups.Groups_PhysicianGroupsPage;
import pages.authorized.groups.surgicalgroups.Groups_SurgicalGroupsPage;
import pages.authorized.procedurespecialities.ProcedureSpeciality_CptSpecialityPage;
import pages.authorized.reporting.charts.Reporting_ChartsPage;
import pages.authorized.reporting.client.Reporting_ClientPage;
import pages.authorized.reporting.globaladmin.Reporting_GlobalAdminPage;
import pages.authorized.searchfacility.SearchFacilityPage;
import pages.components.Menu;
import pages.unauthorized.mainpage.ForgotPasswordPage;
import pages.unauthorized.mainpage.MainPage;

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
    public ClientReportPage clientReportPage = new ClientReportPage();
    public ChartReportPage chartReportPage = new ChartReportPage();
    public User user = new User();
    public ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    public Patient patient = new Patient();
    public ClientManagement_AddNewClientPage clientManagement_addNewClientPage = new ClientManagement_AddNewClientPage();
    public Client client = new Client();

    @BeforeAll
    public static void beforeAll() {
        new WebDriverProvider();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        WebDriverRunner.clearBrowserCache();
        Selenide.clearBrowserCookies();
        Selenide.sessionStorage()
                .clear();
        Selenide.localStorage()
                .clear();
    }
}
