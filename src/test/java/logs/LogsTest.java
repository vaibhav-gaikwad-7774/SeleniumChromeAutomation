package logs;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class LogsTest {

    @Test
    public void verifyStatusCodeWithLogs() {
        // http://api.zippopotam.us/us/90210

        given()
                .baseUri("http://api.zippopotam.us")
                .log().all() // printing the log information of request object
        .when()
                .get("/us/90210")
        .then()
                .log().all() // printing the log information of response object
                .assertThat().statusCode(200);
    }

    @Test
    public void verifyStatusCodeWithSpecificLogs() {
        // http://api.zippopotam.us/us/90210

        given()
                .baseUri("http://api.zippopotam.us")
                .log().method().and()
                .log().uri().and()
                .log().headers()
        .when()
                .get("/us/90210")
                .then()
                .log().status().and()
                .log().body().and()
                .log().headers()
                .assertThat().statusCode(200);
    }
}