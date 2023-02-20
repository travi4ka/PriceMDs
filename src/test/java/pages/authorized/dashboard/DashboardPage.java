package pages.authorized.dashboard;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.components.Menu;
import pages.components.Pagination;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    Menu sideLeftMenu = new Menu();
    final SelenideElement
            table = $("#dash1"),
            daysWeeksMonthsColumn = table.$(byText("Days / Weeks / Months"));

    private Pagination pagination = new Pagination();
    private int indexOfDWMColumn;
    private List<String> listOfValuesDaysWeeksMonths = new ArrayList<>();
    private List<String> valuesOfDWMOnTheTable = new ArrayList<>();
    private List<Integer> listOfValuesDaysWeeksMonthsDaysOnly;

    @Step(value = "Check that we are on the Dashboard page")
    public DashboardPage checkThatPageIsOpen() {
        table.shouldBe(visible);
        return this;
    }

    @Step(value = "Check menu items for this role")
    public DashboardPage checkMenu(String role) {
        sideLeftMenu.checkMenu(role);
        return this;
    }

    @Step(value = "Click column days/weeks/month")
    public DashboardPage clickDaysWeeksMonthsColumn() {
        daysWeeksMonthsColumn.click();
        return this;
    }

    @Step(value = "Check that table has column days/weeks/month")
    public DashboardPage checkDaysMonthsWeeksColumn() {
        daysWeeksMonthsColumn.shouldBe(visible);
        return this;
    }

    @Step(value = "Get list of all days/weeks/month")
    public DashboardPage toGetListOfAllDWM() {
        indexOfDWMColumn = Integer.parseInt(daysWeeksMonthsColumn.getAttribute("cellIndex"));
        for (int i = 1; i <= pagination.getNumberOfPages(); i++) {
            valuesOfDWMOnTheTable = table.$$("tr td:nth-child(" + (indexOfDWMColumn + 1) + ")").texts();
            listOfValuesDaysWeeksMonths.addAll(valuesOfDWMOnTheTable);
            pagination.clickNextButton();
        }
        listOfValuesDaysWeeksMonths = listOfValuesDaysWeeksMonths.stream().map(qw -> qw.substring(0, qw.indexOf("/"))).collect(Collectors.toList());
        listOfValuesDaysWeeksMonthsDaysOnly = listOfValuesDaysWeeksMonths.stream().map(Integer::parseInt).collect(Collectors.toList());
        return this;
    }

    @Step(value = "Check that days/weeks/month column is sorted by asc")
    public DashboardPage checkThatColumnIsSortedByAsc() {
        toGetListOfAllDWM();
        Assertions.assertEquals(listOfValuesDaysWeeksMonthsDaysOnly.stream().sorted().collect(Collectors.toList()), listOfValuesDaysWeeksMonthsDaysOnly);
        return this;
    }

    @Step(value = "Check that days/weeks/month column is sorted by desc")
    public DashboardPage checkThatColumnIsSortedByDesc() {
        toGetListOfAllDWM();
        Assertions.assertEquals(listOfValuesDaysWeeksMonthsDaysOnly.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()), listOfValuesDaysWeeksMonthsDaysOnly);
        return this;
    }
}
