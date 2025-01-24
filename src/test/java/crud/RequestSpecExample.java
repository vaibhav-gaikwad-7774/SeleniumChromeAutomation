package crud;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RequestSpecExample {
    public static void main(String[] args) {
        // Set the base URI
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        // Create a reusable Request Specification
        RequestSpecification requestSpec = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer your_token");

        // Use the specification in a GET request
        RestAssured.given()
                .spec(requestSpec)
                .when()
                .get("/pet/1")
                .then()
                .statusCode(200); // Assert the response status
    }
}
