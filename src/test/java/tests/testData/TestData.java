package tests.testData;

import static tests.testData.TestData.userRole.*;

public class TestData {

    public class userRole {
        public static final String
                ADMIN = "ADMIN",
                NURSE = "NURSE",
                CLIENT_SERVICE = "CLIENT_SERVICE",
                CARE_COORDINATOR = "CARE_COORDINATOR",
                NET_DEV_DIR = "NET_DEV_DIR",
                CLIENT_ADMIN = "CLIENT_ADMIN",
                DEVELOPER = "DEVELOPER";

    }

    public static class roleCredentials {
        public static final String[][]
                roleCredentials =
                {
                        {ADMIN, "travatravi4ka+4@gmail.com", "Travi4ka1!"},
                        {NURSE, "travatravi4ka+1@gmail.com", "Travi4ka1!"},
                        {CLIENT_SERVICE, "travatravi4ka+2@gmail.com", "Travi4ka1!"},
                        {CARE_COORDINATOR, "travatravi4ka+3@gmail.com", "Travi4ka1!"},
                        {NET_DEV_DIR, "travatravi4ka+5@gmail.com", "Travi4ka1!"},
                        {CLIENT_ADMIN, "travatravi4ka+6@gmail.com", "Travi4ka1!"},
                        {DEVELOPER, "travatravi4ka+813@gmail.com", "Travi4ka1!"}
                };
    }

    public static class roleMenu {
        public static final String[][]
                roleMenu =
                {
                        {ADMIN, "Dashboard, PriceMDs Directory Search, Case Management, Care Coordination, Patients, Client Management, Clients, Add New Client, Add New Employer Group, Procedure & Specialties, CPT & Specialty, Reporting, Client, Global Admin, Charts, Facility & Physicians, Facility, Physicians, Download Facilities, Groups, Affiliate Groups, Physician Groups, Surgical Groups, Groups, Administrator, User Management, Case Assign, Global View, Archive, Messaging"},
                        {NURSE, "Dashboard, PriceMDs Directory Search, Case Management, Patients, Reporting, Client, Charts"},
                        {CLIENT_SERVICE, "Dashboard, PriceMDs Directory Search, Client Management, Clients, Add New Client, Add New Employer Group, Reporting, Billing, Client, Employer Groups"},
                        {CARE_COORDINATOR, "Dashboard, PriceMDs Directory Search, Case Management, Patients, Client Management, Clients, Add New Client, Add New Employer Group, Procedure & Specialties, CPT & Specialty, Reporting, Client, Global Admin, Charts, Facility & Physicians, Facility, Physicians, Groups, Affiliate Groups, Physician Groups, Surgical Groups, Groups"},
                        {NET_DEV_DIR, "Dashboard, PriceMDs Directory Search, Reporting, Client, Admin, Facility & Physicians, Facility, Physicians, Groups, Affiliate Groups, Physician Groups, Surgical Groups, Groups"},
                        {CLIENT_ADMIN, "Dashboard, Client, Client Report, Charts Report"},
                        {DEVELOPER, "Dashboard, PriceMDs Directory Search, Case Management, Care Coordination, Patients, Client Management, Clients, Add New Client, Add New Employer Group, Procedure & Specialties, CPT & Specialty, Reporting, Billing, Client, Employer Groups, Facility & Physicians, Facility, Physicians, Groups, Affiliate Groups, Physician Groups, Surgical Groups, Groups"}
                };
    }
}
