package apiTests;

import base.BaseAPI;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class EmployeeAPITest extends BaseAPI {

    @Test(enabled=false	)
    public void createEmployeeViaAPI() {
        String payload = "{\"firstName\":\"ApiJohn\", \"lastName\":\"ApiDoe\"}";
        given()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("/employees")
        .then()
            .statusCode(anyOf(is(200), is(201)));
    }
}
