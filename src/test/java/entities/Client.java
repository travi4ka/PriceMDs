package entities;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static tests.testdata.TestData.MAIN_URL;

public class Client {
    private Faker faker = new Faker();
    private final String name, email;
    private int id;

    public Client() {
        this.name = "AQA_" + faker.random().nextInt(1, 9999) + "_" + faker.company().name();
        this.email = "AQA_" + faker.random().nextInt(1, 9999) + "_" + faker.internet().emailAddress();
    }

    private User user = new User();

    @Step("Create client")
    public Client createClient() {
        Map<String, String> map = new HashMap<>();
        map.put("clientData[accId]", "0");
        map.put("clientData[startDateEG]", "");
        map.put("id", "");
        map.put("name", this.name);
        map.put("acronym", "");
        map.put("address1", "");
        map.put("address2", "");
        map.put("city", "");
        map.put("stateId", "1");
        map.put("zip", "");
        map.put("phone", "");
        map.put("extPhone", "");
        map.put("email", this.email);
        map.put("website", "");
        map.put("entityTypeId", "1");
        map.put("accId", "0");
        map.put("state", "1");
        map.put("startDateEG", "");
        map.put("termed_date", "");
        map.put("client_notes", "");

        id = given().baseUri(MAIN_URL + "clients/create")
                .header("cookie", "PHPSESSID=" + user.getTokenForAdmin())
                .formParams(map)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id");
        return this;
    }


    @Step("Delete client")
    public Client deleteClient() {
        given().baseUri(MAIN_URL + "admin/usersAdminAjax2.php")
                .header("cookie", "PHPSESSID=" + user.getTokenForAdmin())
                .formParams("deleteSegment", "DELETE|COMPANY|" + id)
                .when()
                .post()
                .then()
                .statusCode(200);
        return this;
    }
}
