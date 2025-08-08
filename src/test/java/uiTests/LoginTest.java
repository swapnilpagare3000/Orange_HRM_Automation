package uiTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;

public class LoginTest extends BaseTest {
    @Test
    public void verifyLogin() {
        LoginPage lp = new LoginPage(driver);
        lp.login(prop.getProperty("username"), prop.getProperty("password"));
        DashboardPage dp = new DashboardPage(driver);
        Assert.assertTrue(dp.isDashboardVisible(), "Dashboard not visible - login may have failed");
    }
}
