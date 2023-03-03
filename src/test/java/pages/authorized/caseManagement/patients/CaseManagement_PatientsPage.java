package pages.authorized.caseManagement.patients;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import entities.Patient;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class CaseManagement_PatientsPage {
    private final String url = "case/patients.php";

    private final SelenideElement
            table = $("#demo-dt-basic"),
            addPatientButton = $x("//button[text()='Add Patient']"),
            dob = $x("(//table[@id='demo-dt-basic']//tr)[2]/td[4]"),
            firstOpenFileButton = $x("(//*[@data-original-title='Open file'])[1]"),
            searchField = $(".dataTables_filter").$("input");


    public AddPatientForm addPatientForm = new AddPatientForm();
    public NewCaseTab newCaseTab = new NewCaseTab();

    @Step("Check that we are on the Patients page")
    public CaseManagement_PatientsPage checkPageIsOpen() {
        table.shouldBe(Condition.visible);
        return this;
    }

    @Step(value = "Click first Open File button")
    public CaseManagement_PatientsPage clickFirstOpenFileButton() {
        firstOpenFileButton.click();
        return this;
    }

    @Step(value = "Remember value of dob")
    public String getDobOfFirstElementOnTheTable() {
        return dob.getText();
    }

    @Step("Click add patient button")
    public CaseManagement_PatientsPage clickAddPatientButton() {
        addPatientButton.click();
        return this;
    }

    public CaseManagement_PatientsPage enterFirstNameOfCreatedPatient(Patient patient) {
        searchField.setValue(patient.getFirstName() + " " + patient.getLastName());
        return this;
    }

    @Step("Open page")
    public CaseManagement_PatientsPage openPage() {
        open(url);
        checkPageIsOpen();
        return this;
    }
}
