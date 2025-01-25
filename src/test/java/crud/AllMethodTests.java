package crud;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

public class AllMethodTests {

    private String petId; // Store pet ID for reuse across tests

    @BeforeClass
    public void setUp() {
        // Configure base URI and request specification
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "/v2";

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType("application/json")
                .build();
    }

    // POST: Create a new pet
    @Test(priority = 1)
    public void testPOST() {
        String requestBody = """
                {
                    "category": { "id": 1, "name": "dog" },
                    "name": "doggie-restassured",
                    "photoUrls": ["string"],
                    "tags": [{ "id": 0, "name": "string" }],
                    "status": "available"
                }
                """;

        Response response = given()
                .body(requestBody)
                .when()
                .post("/pet");

        response.then()
                .statusCode(200)
                .body("name", equalTo("doggie-restassured"));

        petId = response.path("id").toString();
        System.out.println("New pet created with ID: " + petId);
    }

 // GET: Retrieve the created pet
//    @Test(priority = 2, dependsOnMethods = "testPOST")
//    public void testGET() {
//        get("/pet/" + petId)
//                .then()
//                .statusCode(200)
//                .body("id", equalTo(Long.valueOf(petId).intValue())) // Convert petId to Long and then to int for matching
//                .body("name", equalTo("doggie-restassured"));
//    }
    // PUT: Update the pet's details
    @Test(priority = 3, dependsOnMethods = "testPOST")
    public void testPUT() {
        String requestBody = """
                {
                    "id": %s,
                    "category": { "id": 1, "name": "dog" },
                    "name": "doggie-restassured-updated",
                    "photoUrls": ["string"],
                    "tags": [{ "id": 0, "name": "string" }],
                    "status": "available"
                }
                """.formatted(petId);

        Response response = given()
                .body(requestBody)
                .when()
                .put("/pet");

        response.then()
                .statusCode(200)
                .body("name", equalTo("doggie-restassured-updated"));

        String name = response.path("name").toString();
        System.out.println("Pet with ID " + petId + " updated with name: " + name);
    }

    // DELETE: Remove the pet
    @Test(priority = 4, dependsOnMethods = "testPOST")
    public void testDELETE() {
        delete("/pet/" + petId)
                .then()
                .statusCode(200)
                .body("message", equalTo(petId));

        System.out.println("Pet with ID " + petId + " deleted.");
    }

    // GET: Verify the pet is deleted
    @Test(priority = 5, dependsOnMethods = "testDELETE")
    public void testGETAfterDelete() {
        get("/pet/" + petId)
                .then()
                .statusCode(404)
                .body("message", equalTo("Pet not found"));
    }
}
