package entities;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import pages.components.Menu;
import pages.unauthorized.mainPage.MainPage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.restassured.RestAssured.given;
import static tests.testData.TestData.*;
import static tests.testData.TestData.roleRoleId.roleRoleId;
import static tests.testData.TestData.userRole.*;

public class User {
    Faker faker = new Faker();

    private final String
            firstName,
            lastName,
            password,
            email;

    public User() {
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.password = "Travi4ka1!";
        this.email = "AQA_" + faker.random().nextInt(1, 10000) + "_" + faker.internet().emailAddress();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Step("Create user")
    public User createUsersWithRole(String role) {
        for (String[] line : roleRoleId) {
            if (role.equals(line[0])) {
                Map<String, String> map = new HashMap<>();
                map.put("registerNewUser", "ADD|USER|1");
                map.put("lastName", lastName);
                map.put("titleUserId", "0");
                map.put("userTitle", "Select Job Title");
                map.put("company", "667");
                map.put("companyText", "PriceMDs");
                map.put("tel", "");
                map.put("cell", "");
                map.put("address1", "");
                map.put("address2", "");
                map.put("stateId", "0");
                map.put("zip", "");
                map.put("userEmail", email);
                map.put("pwd", password);
                map.put("pwd2", password);
                map.put("firstName", firstName);
                map.put("userRole", line[1]);
                map.put("stateText", "Select State");

                given()
                        .baseUri(MAIN_URL + "ajaxControl.php")
                        .header("cookie", "PHPSESSID=" + getTokenForAdmin())
                        .formParams(map)
                        .when()
                        .post()
                        .then()
                        .statusCode(200);
            }
        }
        return this;
    }

    @Step("Delete user")
    public User deleteUser() {
        MainPage mainPage = new MainPage();
        Menu menu = new Menu();
        mainPage
                .openPage()
                .enterCredentialsForMainAdmin()
                .clickSignInButton();
        menu
                .clickAdministrator()
                .clickAdministrator_userManagement();
        $("input[type='search']").setValue(email);
        $$("td").findBy(text(email)).shouldBe(visible).parent().$("button[value^='DELETE']").click();
        $("#delBtnModal").click();
        return this;
    }

    String getTokenForAdmin() {
        Map<String, String> map = new HashMap<>();
        map.put("loginValue", "1");
        map.put("userEmail", MAIN_ADMIN_EMAIL);
        map.put("pwd", MAIN_ADMIN_PASSWORD);
        return
                given()
                        .baseUri(MAIN_URL + "doLoginNow.php")
                        .formParams(map)
                        .when()
                        .post()
                        .then()
                        .statusCode(200)
                        .extract()
                        .cookie("PHPSESSID");

    }

    @Step("Select random role")
    String selectRandomRole() {
        return faker.options().option(NURSE, ADMIN, CARE_COORDINATOR, CLIENT_ADMIN, CLIENT_SERVICE, NET_DEV_DIR);
    }

    @Step("Create random user")
    public User createRandomUser() {
        createUsersWithRole(selectRandomRole());
        return this;
    }
}
