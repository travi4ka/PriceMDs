package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Pagination {
    private SelenideElement nextButton = $("#dash1_next");

    @Step(value = "Click Next button on the pagination component")
    public Pagination clickNextButton() {
        nextButton.$("a").click();
        return this;
    }

    @Step(value = "Get number of all pages on the pagination component")
    public int getNumberOfPages() {
        try {
            return Integer.parseInt(nextButton.preceding(0).$("a").getText());
        } catch (Exception e) {
            return 1;
        }
    }
}
