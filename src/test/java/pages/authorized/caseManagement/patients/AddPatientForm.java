package pages.authorized.caseManagement.patients;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AddPatientForm {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement saveChangesButton = $("#patientSaveBtn");

    public AddPatientForm enterFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public AddPatientForm enterLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public AddPatientForm clickSaveChangesButton() {
        saveChangesButton.click();
        return this;
    }
}
