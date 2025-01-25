package datadriven;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class DataDrivenTests {

    private RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("http://api.zippopotam.us")
            .setContentType("application/json")
            .build();

    private ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType("application/json")
            .expectResponseTime(lessThan(20000L))
            .build();

    @Test
    public void verifyState1() {
        // http://api.zippopotam.us/us/90210

        given()
                .spec(requestSpecification)
        .when()
                .get("/us/90210")
        .then()
                .spec(responseSpecification)
                .body("places[0].state", equalTo("California"));
    }

    @Test
    public void verifyState2() {
        // http://api.zippopotam.us/us/12345

        given()
                .spec(requestSpecification)
        .when()
                .get("/us/12345")
        .then()
                .spec(responseSpecification)
                .body("places[0].state", equalTo("New York"));
    }

    @Test
    public void verifyState3() {
        // http://api.zippopotam.us/us/24848

        given()
                .spec(requestSpecification)
        .when()
                .get("/us/24848")
        .then()
                .spec(responseSpecification)
                .body("places[0].state", equalTo("West Virginia"));
    }

    @Test
    public void verifyState4() {
        // http://api.zippopotam.us/in/500049

        given()
                .spec(requestSpecification)
        .when()
                .get("/in/500049")
        .then()
                .spec(responseSpecification)
                .body("places[0].state", equalTo("Andhra Pradesh"));
    }

    @Test(dataProvider = "zipCodeData")
    public void verifyStates(String countryCode, String zipCode, String state) {
        given().
                spec(requestSpecification)
                .pathParam("countryCode", countryCode)
                .pathParam("zipCode", zipCode)
        .when()
                .get("/{countryCode}/{zipCode}")
        .then()
                .spec(responseSpecification)
                .body("places[0].state", equalTo(state));
    }

    // preparing the test data using data-provider in testNG
    @DataProvider(name = "zipCodeData")
    public Object[][] getZipCodes() {
        return new Object[][] {
                {"us", "90210", "California"},
                {"us", "12345", "New York"},
                {"us", "24848", "West Virginia"},
                {"in", "500049", "Andhra Pradesh"}
        };
    }
}