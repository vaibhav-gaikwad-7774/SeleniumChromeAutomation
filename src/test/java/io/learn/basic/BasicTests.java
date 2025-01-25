package io.learn.basic;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class BasicTests {

    @Test
    public void verifyStatusCode() {
        // Verify the status code for the API request
        given()
                .baseUri("http://api.zippopotam.us") // Base URI
                .when()
                .get("/us/90210") // Endpoint with path parameter
                .then()
                .assertThat()
                .statusCode(200); // Expected status code
        
    }

    @Test
    public void verifyCountryDetails() {
        // Verify the country details in the response
        given()
                .baseUri("http://api.zippopotam.us") // Base URI
                .when()
                .get("/us/90210") // Endpoint with path parameter
                .then()
                .assertThat()
                .statusCode(200) // Verify status code
                .and()
                .body("country", equalTo("United States")) // Validate country field
                .body("'country abbreviation'", equalTo("US"))
        
        		.body("'post code'", equalTo("90210"));
//        		
        
    }
    
    
    @Test
    public void verifyPlaceDetails() {
        // Verify the country details in the response
        given()
                .baseUri("http://api.zippopotam.us") // Base URI
                .when()
                .get("/us/90210") // Endpoint with path parameter
                .then()
                .assertThat()
                .statusCode(200) // Verify status code
                .body("places[0].state", equalTo ("California"))
                .body("places[0].longitude", equalTo ("-118.4065"))
                .body("places[0].state", equalTo ("California"))
                .body("places[0].'state abbreviation'", equalTo ("CA"));
//   24 min done     		
        
    }
    
    @Test
    public void varifyNegativeTest() {
        // Verify the status code for the API request
        given()
                .baseUri("http://api.zippopotam.us") // Base URI
                .when()
                .get("/us/99999") // Endpoint with path parameter
                .then()
                .assertThat()
                .statusCode(404); // Expected status code
        
    }
    
    @Test
    public void varifyResponseType() {
        // Verify the status code for the API request
        given()
                .baseUri("http://api.zippopotam.us") // Base URI
                .when()
                .get("/us/90210") // Endpoint with path parameter
                .then()
                .assertThat()
                .statusCode(200) // Expected status code
        		.contentType(equalTo("application/json"));
        
    }
}
