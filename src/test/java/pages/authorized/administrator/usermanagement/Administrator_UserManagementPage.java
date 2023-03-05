package pages.authorized.administrator.usermanagement;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.authorized.administrator.usermanagement.tabs.ClientsAndEmployerGroupsTab;
import pages.authorized.administrator.usermanagement.tabs.UsersTab;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Administrator_UserManagementPage {
    final String url = "admin/usersAdmin.php";

    final SelenideElement clientsAndEGTab = $(byText("Clients & Employer Groups"));

    public UsersTab usersTab = new UsersTab();
    public ClientsAndEmployerGroupsTab clientsAndEmployerGroupsTab = new ClientsAndEmployerGroupsTab();

    @Step("Open page")
    public Administrator_UserManagementPage openPage() {
        open(url);
        pageIsOpen();
        return this;
    }

    @Step("Click Clients & Employer Groups tab")
    public Administrator_UserManagementPage clickClientsAndEGTab() {
        clientsAndEGTab.click();
        return this;
    }

    @Step("Page is open")
    public Administrator_UserManagementPage pageIsOpen() {
        usersTab.checkPageIsOpen();
        return this;
    }
}
