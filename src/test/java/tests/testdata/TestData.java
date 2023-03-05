package tests.testdata;

import static tests.testdata.TestData.userRole.*;

public class TestData {
    public static final String
            MAIN_URL = System.getProperty("baseUrl", "https://stage.pricemds.com/"),
            MAIN_ADMIN_EMAIL = "sergey.zhiharev@mbicycle.com",
            MAIN_ADMIN_PASSWORD = "Travi4ka1!";

    public static class userRole {
        public static final String
                ADMIN = "ADMIN",
                NURSE = "NURSE",
                CLIENT_SERVICE = "CLIENT_SERVICE",
                CARE_COORDINATOR = "CARE_COORDINATOR",
                NET_DEV_DIR = "NET_DEV_DIR",
                CLIENT_ADMIN = "CLIENT_ADMIN",
                DEVELOPER = "DEVELOPER";
    }

    public static class roleRoleId {
        public static final String[][]
                roleRoleId =
                {
                        {ADMIN, "4"},
                        {NURSE, "1"},
                        {CLIENT_SERVICE, "2"},
                        {CARE_COORDINATOR, "3"},
                        {NET_DEV_DIR, "5"},
                        {CLIENT_ADMIN, "6"},
                        {DEVELOPER, "813"}
                };
    }

    public static class roleMenu {
        public static final String[][]
                roleMenu =
                {
                        {ADMIN, "Dashboard, PriceMDs Directory Search, Case Management, Care Coordination, Patients, Client Management, Clients, Add New Client, Procedure & Specialties, CPT & Specialty, Reporting, Client, Global Admin, Charts, Facility & Physicians, Facility, Physicians, Download Facilities, Groups, Affiliate Groups, Physician Groups, Surgical Groups, Groups, Administrator, User Management, Case Assign, Global View, Archive, Messaging"},
                        {NURSE, "Dashboard, PriceMDs Directory Search, Case Management, Patients, Reporting, Client, Charts"},
                        {CLIENT_SERVICE, "Dashboard, PriceMDs Directory Search, Client Management, Clients, Add New Client, Reporting, Billing, Client, Employer Groups"},
                        {CARE_COORDINATOR, "Dashboard, PriceMDs Directory Search, Case Management, Patients, Client Management, Clients, Add New Client, Procedure & Specialties, CPT & Specialty, Reporting, Client, Global Admin, Charts, Facility & Physicians, Facility, Physicians, Groups, Affiliate Groups, Physician Groups, Surgical Groups, Groups"},
                        {NET_DEV_DIR, "Dashboard, PriceMDs Directory Search, Reporting, Client, Admin, Facility & Physicians, Facility, Physicians, Groups, Affiliate Groups, Physician Groups, Surgical Groups, Groups"},
                        {CLIENT_ADMIN, "Dashboard, Client, Client Report, Charts Report"},
                        {DEVELOPER, "Dashboard, PriceMDs Directory Search, Case Management, Care Coordination, Patients, Client Management, Clients, Add New Client, Procedure & Specialties, CPT & Specialty, Reporting, Billing, Client, Employer Groups, Facility & Physicians, Facility, Physicians, Groups, Affiliate Groups, Physician Groups, Surgical Groups, Groups"}
                };
    }
}
