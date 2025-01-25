package specification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationTests {

    // Request Specification: Common properties for API requests
    private RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("http://api.zippopotam.us")
            .setContentType("application/json")
            .build();

    // Response Specification: Expected common response properties
    private ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200) // Expected status code
            .expectContentType("application/json")
            .expectResponseTime(lessThan(20000L)) // Response time less than 2 seconds
            .build();

    @Test
    public void verifyStatusCode() {
        // Verify the status code for a valid API request
        given()
                .spec(requestSpecification)
                .when()
                .get("/us/90210") // Endpoint with path parameter
                .then()
                .spec(responseSpecification);
    }

    @Test
    public void verifyCountryDetails() {
        // Verify specific country details in the API response
        given()
                .spec(requestSpecification)
                .when()
                .get("/us/90210") // Endpoint with path parameter
                .then()
                .spec(responseSpecification)
                .body("country", equalTo("United States")) // Validate country field
                .body("'country abbreviation'", equalTo("US")) // Validate country abbreviation
                .body("'post code'", equalTo("90210")); // Validate post code
    }

    @Test
    public void verifyPlaceDetails() {
        // Verify details about places in the API response
        given()
                .spec(requestSpecification)
                .when()
                .get("/us/90210") // Endpoint with path parameter
                .then()
                .spec(responseSpecification)
                .body("places[0].state", equalTo("California")) // Validate state
                .body("places[0].longitude", equalTo("-118.4065")) // Validate longitude
                .body("places[0].'state abbreviation'", equalTo("CA")); // Validate state abbreviation
    }

    @Test
    public void verifyNegativeTest() {
        // Verify response for an invalid endpoint (negative test case)
        given()
                .spec(requestSpecification)
                .when()
                .get("/us/99999") // Invalid path parameter
                .then()
                .statusCode(404); // Expect 404 Not Found for invalid request
    }

    @Test
    public void verifyResponseType() {
        // Verify the response content type
        given()
                .spec(requestSpecification)
                .when()
                .get("/us/90210") // Endpoint with path parameter
                .then()
                .spec(responseSpecification)
                .contentType(equalTo("application/json")); // Validate content type
    }
}
