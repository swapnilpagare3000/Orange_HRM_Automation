package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import java.util.Properties;
import java.io.FileInputStream;

public class BaseAPI {
    protected String token;
    protected Properties prop = new Properties();

    @BeforeClass
    public void setupAPI() throws Exception {
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);
        RestAssured.baseURI = prop.getProperty("api.base");
        //TEst Changes
    }
}
