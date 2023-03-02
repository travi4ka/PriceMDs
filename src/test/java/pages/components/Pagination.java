package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Pagination {
    private final SelenideElement nextButton = $("ul.pagination")
            .$(byText("Next")).parent();
    private final SelenideElement previousButton = $("ul.pagination")
            .$(byText("Previous")).parent();

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
    @Step(value = "Check that pagination is presented")
    public Pagination checkThatPaginationIsPresented(){
        nextButton.shouldBe(visible);
        previousButton.shouldBe(visible);
        return this;
    }
}
