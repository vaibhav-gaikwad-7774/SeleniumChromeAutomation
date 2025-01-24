package crud;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;

public class ApiTest {
    public static void main(String[] args) {
        RestAssured.given()
                .baseUri("https://api.example.com/v2")
                .when()
                .get("/pet/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1));
    }
}
