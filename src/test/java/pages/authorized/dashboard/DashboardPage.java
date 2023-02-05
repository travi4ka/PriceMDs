package pages.authorized.dashboard;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.authorized.components.Menu;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    Menu sideLeftMenu = new Menu();
    final SelenideElement table = $("#dash1");

    @Step(value = "Check that we are on the Dashboard page")
    public DashboardPage checkThatPageIsOpen() {
        table.shouldBe(visible);
        return this;
    }
    public DashboardPage checkMenu(String role){
        sideLeftMenu.checkMenu(role);
        return this;
    }
}
