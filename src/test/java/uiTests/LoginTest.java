package uiTests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	
	 private static final Logger logger = LogManager.getLogger(LoginTest.class);
	 
    @Test
    public void verifyLogin() {
        LoginPage lp = new LoginPage(driver);
        lp.login(prop.getProperty("username"), prop.getProperty("password"));
        logger.info("Username and password fetched from cconfig. property file");
        DashboardPage dp = new DashboardPage(driver);
        Assert.assertTrue(dp.isDashboardVisible(), "Dashboard not visible - login may have failed");
        logger.info("Assertion might have failed");
    }
    
}
