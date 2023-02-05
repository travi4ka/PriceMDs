package pages.authorized.caseManagement.patients;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.*;

public class CaseManagement_PatientsPage {
    final SelenideElement
            table = $("#demo-dt-basic"),
            dob = $x("//tr[@id='1']/td[4]"),
            firstOpenFileButton = $x("(//*[@data-original-title='Open file'])[1]"),
            patientDob = $("#patient_dob");

    @Step("Check that we are on the Patients page")
    public CaseManagement_PatientsPage checkPageIsOpen() {
        table.shouldBe(Condition.visible);
        return this;
    }
    @Step
    public CaseManagement_PatientsPage checkDobDisplays() {
        String dobValue = dob.getText();
        firstOpenFileButton.click();
        patientDob.shouldBe(Condition.visible);
        Assertions.assertTrue(patientDob.getText().contains(dobValue));
        return this;
    }
}
