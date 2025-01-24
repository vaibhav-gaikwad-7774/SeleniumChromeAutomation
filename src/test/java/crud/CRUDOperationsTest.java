package crud;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CRUDOperationsTest {

    // Base URI
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

    /**
     * Create (POST Request)
     */
    @Test
    public void testCreate() {
        // JSON request body
        String requestBody = """
                {
                    "title": "foo",
                    "body": "bar",
                    "userId": 1
                }
                """;

        // Sending POST request
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(BASE_URL);

        // Printing and validating the response
        System.out.println("Create Response: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 201, "Status Code Check");
        Assert.assertTrue(response.getBody().asString().contains("foo"), "Response Body Check");
    }

    /**
     * Read (GET Request)
     */
    @Test
    public void testRead() {
        // Sending GET request
        Response response = RestAssured.given()
                .when()
                .get(BASE_URL + "/1");

        // Printing and validating the response
        System.out.println("Read Response: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200, "Status Code Check");
        Assert.assertTrue(response.getBody().asString().contains("id"), "Response Body Check");
    }

    /**
     * Update (PUT Request)
     */
    @Test
    public void testUpdate() {
        // JSON request body
        String requestBody = """
                {
                    "id": 1,
                    "title": "updated title",
                    "body": "updated body",
                    "userId": 1
                }
                """;

        // Sending PUT request
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put(BASE_URL + "/1");

        // Printing and validating the response
        System.out.println("Update Response: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200, "Status Code Check");
        Assert.assertTrue(response.getBody().asString().contains("updated title"), "Response Body Check");
    }

    /**
     * Delete (DELETE Request)
     */
    /**
     * Delete (DELETE Request)
     */
    @Test
    public void testDelete() {
        // Sending DELETE request
        Response response = RestAssured.given()
                .when()
                .delete(BASE_URL + "/1");

        // Printing the response body
        System.out.println("Delete Response: " + response.getBody().asString());

        // Validating the response
        Assert.assertEquals(response.getStatusCode(), 200, "Status Code Check");

        // Checking if the response body is empty or contains an empty JSON
        String responseBody = response.getBody().asString();
        boolean isResponseEmpty = responseBody.isEmpty() || "{}".equals(responseBody.trim());
        Assert.assertTrue(isResponseEmpty, "Response Body Check");
    }

}
