package base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Properties;
import java.io.FileInputStream;

public class BaseTest {
    protected WebDriver driver;
    protected Properties prop = new Properties();
    protected final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeClass
    public void loadConfig() throws Exception {
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("base.url"));
    }

    @AfterMethod
    public void tearDown() {
     //   if (driver != null) driver.quit();
    }
}
