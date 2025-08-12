package uiTests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.EmployeePage;

public class EmployeeCRUDTest extends BaseTest {
    @Test
    public void addEmployee() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.login(prop.getProperty("username"), prop.getProperty("password"));
        
        EmployeePage ep = new EmployeePage(driver);
        ep.navigateToAddEmployee();
        Thread.sleep(3000);
        ep.addEmployee("TESTJOHN", "TESTDOE");
        // Add assertions as needed to validate creation
        // Test Comments
        //test Comments
    }
}
