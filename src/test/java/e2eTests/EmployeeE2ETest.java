package e2eTests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.EmployeePage;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class EmployeeE2ETest extends BaseTest {

    @Test
    public void createEmployeeViaAPI_ValidateInUI() throws Exception {
        // Create via API (simple example)
        String payload = "{\"firstName\":\"E2EJohn\", \"lastName\":\"E2EDoe\"}";
        int status = given()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("https://opensource-demo.orangehrmlive.com/web/index.php/api/v2/employees")
        .then()
            .extract()
            .statusCode();

        // Validate via UI
        LoginPage lp = new LoginPage(driver);
        lp.login(prop.getProperty("username"), prop.getProperty("password"));
        EmployeePage ep = new EmployeePage(driver);
        ep.navigateToAddEmployee();
        // Normally you'd search for the employee created and assert presence.
    }
}
