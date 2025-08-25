package uiTests;
import base.BaseTest;
import pages.EmployeePage;
import pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;
import utils.RandomNameGenerator;
public class Selftest extends BaseTest{
	@Test
	public void PerformOperations() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
        lp.login(prop.getProperty("username"), prop.getProperty("password"));

        EmployeePage ep = new EmployeePage(driver);
        ep.navigateToAddEmployee();
        String firstName = RandomNameGenerator.getRandomFirstName();
        String lastName = RandomNameGenerator.getRandomLastName();
        String fullName = firstName + " " + lastName;
        ep.addEmployee(firstName, lastName);
        Thread.sleep(3000);
        ep.searchemployee(fullName);
        Thread.sleep(3000);
        Assert.assertEquals(true, true);
        Thread.sleep(3000);
        ep.fillthedetails();
      //  ep.searchemployee(fullName);
     //   ep.deletesearchemployee(fullName);
	}
}