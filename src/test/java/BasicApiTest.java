import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasicApiTest {

    @Test
    public void testGetRequest() {
        // Base URL of the API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Sending GET request
        Response response = RestAssured
                                .given()
                                .when()
                                .get("/posts/1");

        // Print Response Body
        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200, "Status Code Check");
        Assert.assertTrue(response.getBody().asString().contains("userId"), "Response Contains userId");
    }
}
