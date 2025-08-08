package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;
    By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardVisible() {
        try {
            return driver.findElement(dashboardHeader).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
