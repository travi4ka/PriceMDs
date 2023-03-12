package pages.authorized.clientmanagement;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.Pagination;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.testdata.TestData.userRole.CLIENT_ADMIN;

public class ClientManagement_ClientsPage {
    private final SelenideElement filterByStatusButton = $(byText("Filter by Status"));
    private final SelenideElement statusDropdown = $("#client_state");
    private final SelenideElement addClientButton = $(byText("Add Client"));
    private final SelenideElement numberOfElementsPerPageElement = $("#clientsData_length");
    private final SelenideElement searchInput = $(byText("Search:")).$("input");
    private final SelenideElement clientsTable = $("#clientsData");
    private final SelenideElement clientsTable_StatusColumn = clientsTable.$$("th")
            .find(text("Status"));


    private Pagination pagination = new Pagination();


    @Step("Set filter value to {0}")
    public ClientManagement_ClientsPage setFilterValueTo(String value) {
        statusDropdown.click();
        statusDropdown.$(byText(value))
                .click();
        filterByStatusButton.click();
        return this;
    }

    @Step("Check that we are on the Clients page")
    public ClientManagement_ClientsPage checkPageIsOpen() {
        filterByStatusButton.shouldBe(visible);
        return this;
    }

    @Step("Open page")
    public ClientManagement_ClientsPage openPage() {
        open("clients/");
        return this;
    }

    @Step("Check elements on the page")
    public ClientManagement_ClientsPage checkElementsOnThePage(String role) {
        if (!role.equals(CLIENT_ADMIN)) {
            filterByStatusButton.shouldBe(visible);
            statusDropdown.shouldBe(visible);
            addClientButton.shouldBe(visible);
            numberOfElementsPerPageElement.shouldBe(visible);
            searchInput.shouldBe(visible);
            clientsTable.shouldBe(visible);
            pagination.checkThatPaginationIsPresented();
        }
        else {
            filterByStatusButton.shouldBe(visible);
            statusDropdown.shouldBe(visible);
            addClientButton.shouldNot(exist);
            numberOfElementsPerPageElement.shouldBe(visible);
            searchInput.shouldBe(visible);
            clientsTable.shouldBe(visible);
            pagination.checkThatPaginationIsPresented();
        }
        return this;
    }

    @Step("Check there is no other clients except {0}")
    public ClientManagement_ClientsPage checkThatStatusColumnContainsOnlyStatus(String value) {
        setFilterValueTo(value);
        int StatusColumnIndex = Integer.parseInt(clientsTable_StatusColumn.getAttribute("cellIndex"));
        for (int i = 1; i <= pagination.getNumberOfPages(); i++) {
            $$("tr td:nth-child(" + (StatusColumnIndex + 1) + ")").filter(not(text(value)))
                    .shouldHave(size(0));
            pagination.clickNextButton();
        }
        return this;
    }
}
