package xml;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class XMLTests {

    @Test
    public void testJSONData() {
        given()
                .baseUri("https://petstore.swagger.io/v2/pet")
        .when()
                .get("/pet/9223372036854760000")
        .then()
                .statusCode(200);
    }

    @Test
    public void testXMLData() {
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .accept("application/xml")
        .when()
                .get("/pet/9223372036854760000")
        .then()
                .statusCode(200)
                .body("Pet.status", equalTo("pending"));
    }
}