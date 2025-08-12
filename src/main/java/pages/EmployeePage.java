package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage {
	protected final Logger logger = LogManager.getLogger(this.getClass());
    WebDriver driver;
    By pimMenu = By.xpath("//span[text()='PIM']");
    By addEmployee = By.xpath("//a[text()='Add Employee'] | //button[contains(.,'Add')]");
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By saveBtn = By.xpath("//button[@type='submit']");

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAddEmployee() {
        driver.findElement(pimMenu).click();
        driver.findElement(addEmployee).click();
        logger.info("TEst");
        //driver.findElement(addEmployee).click();
        
    }

    public void addEmployee(String fName, String lName) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(saveBtn).click();
    }
}
