package specification;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

public class SpecificationTests2 {

    @BeforeClass
    public void setUp() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                                                .setBaseUri("http://api.zippopotam.us")
                                                .setContentType("application/json")
                                                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                                                .expectStatusCode(200)
                                                .expectContentType("application/json")
                                                .expectResponseTime(lessThan(2000L))
                                                .build();
    }

    @Test
    public void verifyStatusCode() {
        // http://api.zippopotam.us/us/90210

       get("/us/90210");
    }

    @Test
    public void verifyCountryDetails() {
        get("/us/90210")
            .then()
                    .body("country", equalTo("United States")) // JSON object
                    .body("'country abbreviation'", equalTo("US"))
                    .body("'post code'", equalTo("90210"));
    }

    @Test
    public void verifyPlacesDetails() {
        get("/us/90210")
            .then()
                    .body("places[0].state", equalTo("California")) // JSON Array
                    .body("places[0].longitude", equalTo("-118.4065"))
                    .body("places[0].latitude", equalTo("34.0901"))
                    .body("places[0].'place name'", equalTo("Beverly Hills"))
                    .body("places[0].'state abbreviation'", equalTo("CA"));
    }
}