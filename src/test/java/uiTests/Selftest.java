package uiTests;
import base.BaseTest;
import pages.EmployeePage;
import pages.LoginPage;

public class Selftest extends BaseTest{

	public void PerformOperations(){
		LoginPage lp = new LoginPage(driver);
        lp.login(prop.getProperty("username"), prop.getProperty("password"));

        EmployeePage ep = new EmployeePage(driver);
        ep.navigateToAddEmployee();
        ep.addEmployee("John", "Doe");

	}
}
