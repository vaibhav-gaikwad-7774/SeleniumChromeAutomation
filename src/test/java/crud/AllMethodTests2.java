package crud;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import models.Pet;

public class AllMethodTests2 {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "/v2";

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType("application/json")
                .build();
    }

    // POST: Create a new pet
    @Test(priority = 1)
    public void testPOST() {
        Map<String, Object> petData = getPetData();
        Response response = given()
                .body(petData) // Serialization (Java object to JSON)
                .when()
                .post("/pet");

        response.then()
                .statusCode(200)
                .body("name", equalTo("doggie"));

        String id = response.path("id").toString();
        System.out.println("New Pet created with ID: " + id);
    }

    // GET: Verify the newly created pet
    @Test(priority = 2, dependsOnMethods = "testPOST")
    public void testDeserialization() {
        Map<String, Object> petData = getPetData();

        // Create a new pet - POST
        String newPetID = given()
                .body(petData)
                .when()
                .post("/pet")
                .path("id")
                .toString();
        System.out.println("New Pet created with ID: " + newPetID);

        // Verify the new pet - GET
        Response response = get("/pet/" + newPetID);
 Pet pet = response.as(Pet.class); // Deserialization (JSON to Java Object)

  System.out.println("Pet Name: " + pet.getName());
  System.out.println("Pet Status: " + pet.getStatus());
    }

    // PUT: Update the pet
    @Test(priority = 3, dependsOnMethods = "testPOST")
    public void testPUT() {
        Map<String, Object> petData = getPetData();
        petData.put("status", "available");

        Response response = given()
                .body(petData)
                .when()
                .put("/pet");

        response.then()
                .statusCode(200)
                .body("status", equalTo("available"));

        String id = response.path("id").toString();
        String name = response.path("name").toString();
        System.out.println("Pet with ID " + id + " updated with name: " + name);
    }

    // Test All Methods in Sequence
    @Test(priority = 4)
    public void testAllMethods() {
        Map<String, Object> petData = getPetData();

        // Create a new pet - POST
        String newPetID = given()
                .body(petData)
                .when()
                .post("/pet")
                .path("id")
                .toString();
        System.out.println("New Pet created with ID: " + newPetID);

        // Verify the new pet - GET
        get("/pet/" + newPetID)
                .then()
                .statusCode(200)
                .and()
                .body("status", equalTo("pending"));

        // Update the pet - PUT
        petData.put("status", "available");
        petData.put("id", newPetID);
        given()
                .body(petData)
                .when()
                .put("/pet")
                .then()
                .statusCode(200);

        // Verify the pet with updated status - GET
        get("/pet/" + newPetID)
                .then()
                .statusCode(200)
                .and()
                .body("status", equalTo("available"));

        // Delete the pet - DELETE
        delete("/pet/" + newPetID)
                .then()
                .statusCode(200);

        // Verify the deleted pet - GET
        get("/pet/" + newPetID)
                .then()
                .statusCode(404);
    }

    // Helper method to generate pet data
    private Map<String, Object> getPetData() {
        Map<String, Object> categoryMap = new HashMap<>();
        categoryMap.put("id", 1);
        categoryMap.put("name", "dog");

        Map<String, Object> petMap = new HashMap<>();
        petMap.put("name", "doggie");
        petMap.put("status", "pending");
        petMap.put("category", categoryMap);
        return petMap;
    }
}
