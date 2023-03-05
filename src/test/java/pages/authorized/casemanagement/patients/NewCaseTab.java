package pages.authorized.casemanagement.patients;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NewCaseTab {
    private final SelenideElement saveFileButton = $("#saveRequestBtn");
    private final SelenideElement patientDob = $("#patient_dob");

    public NewCaseTab checkThatOpen(){
        saveFileButton.shouldBe(visible);
        return this;
    }

    public NewCaseTab checkDobDisplays(String dobOnTable){
        patientDob.shouldBe(visible);
        Assertions.assertTrue(patientDob.getText().contains(dobOnTable));
        return this;
    }

}
