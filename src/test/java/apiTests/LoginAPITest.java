package apiTests;

import base.BaseAPI;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LoginAPITest extends BaseAPI {

    @Test
    public void verifyAPILogin() {
        String requestBody = "{"
                + "\"username\":\"" + prop.getProperty("username") + "\","
                + "\"password\":\"" + prop.getProperty("password") + "\""
                + "}";

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/auth/login")
        .then()
            .statusCode(anyOf(is(200), is(201), is(204)));
    }
}
