package api;

import com.codeborne.selenide.Selenide;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static tests.testData.TestData.roleCredentials.roleCredentials;

public class ApiTest {
 //   @Test
        public void loginApi() {
            ExtractableResponse<Response> response;
        for (String[] line : roleCredentials) {
            if ("ADMIN".equals(line[0])) {
                Map<String, String> map = new HashMap<>();
                map.put("loginValue", "1");
                map.put("userEmail", line[1]);
                map.put("pwd", line[2]);
                response = given()
                        .baseUri("https://stage.pricemds.com/doLoginNow.php")
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .formParams(map)
                        .when().post()
                        .then()
                        .statusCode(200)
                                .extract();
         //       ss=response.
                       // .cookie("PHPSESSID");
            //    System.out.println(cookieToken);
              //  Selenide.executeJavaScript("document.cookie = 'PHPSESSID=" + cookieToken+"'");
            }
        }
    }


  //  @Test
    public void loginApi2() {
        for (String[] line : roleCredentials) {
            if ("NURSE".equals(line[0])) {
                Map<String, String> map = new HashMap<>(){
                };
                map.put("registerNewUser", "ADD|USER|1");
                map.put("lastName", line[0]);
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
                map.put("userEmail", "travatravi4ka+4445@gmail.com");
                map.put("pwd", "Travi4ka1!");
                map.put("pwd2", "Travi4ka1!");
                map.put("firstName", line[0]);
                map.put("userRole", "1");
                map.put("stateText", "Select State");


                String cookieToken = given()
                        .baseUri("https://stage.pricemds.com/ajaxControl.php")
                        .header("cookie","PHPSESSID=f1940aa2a72bf104de255b3f4900e4e6")
                        .formParams(map)
                        .when().post()
                        .then()
                        .statusCode(200)
                        .extract()
                        .asPrettyString();
                // .cookie("PHPSESSID");
                System.out.println(cookieToken);
                //  Selenide.executeJavaScript("document.cookie = 'PHPSESSID=" + cookieToken+"'");
            }
        }
    }
}
