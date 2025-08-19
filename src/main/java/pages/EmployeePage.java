package pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePage {
	protected final Logger logger = LogManager.getLogger(this.getClass());
    WebDriver driver;
    By pimMenu = By.xpath("//span[text()='PIM']");
    By addEmployee = By.xpath("//a[text()='Add Employee'] | //button[contains(.,'Add')]");
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By saveBtn = By.xpath("//button[@type='submit']");
    By empsearchname=By.xpath("//label[text()='Employee Name']/following::input[@placeholder='Type for hints...'][1]");
    By searchbutton=By.xpath("//button[@type=\"submit\"]");
    By namedropdisplay=By.xpath("//div[@class=\"oxd-autocomplete-text-input oxd-autocomplete-text-input--active\"][1]");
    By middlename=By.xpath("//input[@placeholder='Middle Name']");
    By otherId=By.xpath("//label[text()='Other Id']/following::input[1]");
    By editbutton=By.xpath("//button[@class=\"oxd-icon-button oxd-table-cell-action-space\"][1]");
    By Nationdropdownpage=By.xpath("//label[text()='Nationality']/following::div[@class='oxd-select-text oxd-select-text--active'][1]");
    By DdwonIndian=By.xpath("//div[@role='option']/span[text()='Indian']");   
    By Maritaldropdownpage=By.xpath("//label[text()='Marital Status']/following::div[@class='oxd-select-text oxd-select-text--active'][1]");   
    By Ddwonmarital=By.xpath("//div[@role='option']/span[text()='Single']");  
    public EmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAddEmployee() {
        driver.findElement(pimMenu).click();
        driver.findElement(addEmployee).click();
        logger.info("Test");
        
        //driver.findElement(addEmployee).click();
        
    }

    public void addEmployee(String fName, String lName) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(saveBtn).click();
        logger.info("Employee Added");
    }
    public void searchemployee(String searchname) throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	logger.info("Before PIM menu");
    	driver.findElement(pimMenu).click();
    	WebElement pim = driver.findElement(By.xpath("//span[text()='PIM']"));
    	Actions actions = new Actions(driver);
    	actions.moveToElement(pim).click().perform();

    	logger.info("After PIM menu");
    	//WebElement menuItem = wait.until(ExpectedConditions.visibilityOfElementLocated(empsearchname));
    	//menuItem.click();

    	//driver.findElement(empsearchname).sendKeys(searchname);
    	Thread.sleep(3000);
    	driver.findElement(namedropdisplay).isDisplayed();
    	driver.findElement(empsearchname).sendKeys(searchname);
    	logger.info("Is displayed ?");
    //	System.out.println(isd);
    	
    	Thread.sleep(3000);
    	//driver.findElement(namedropdisplay).click();
    	//logger.info("Is namedrop click ?");
    	//Thread.sleep(3000);
    	driver.findElement(searchbutton).click();
    	Thread.sleep(3000);
    	logger.info("Search Click");  	
    	
    }
    
    public void fillthedetails() throws InterruptedException {
    	
    	driver.findElement(editbutton).click();
    	logger.info("edit bottton clicked");
    	Thread.sleep(3000);
    	driver.findElement(middlename).sendKeys("middlename");
    	driver.findElement(otherId).sendKeys("98654");
    	logger.info("details filled");
    	//Select Nationality    	// Click on the dropdown
    	driver.findElement(Nationdropdownpage).click();
    	driver.findElement(DdwonIndian).click();
    	driver.findElement(Maritaldropdownpage).click();
    	driver.findElement(Ddwonmarital).click();
    	
    	//Select birth date
    	//int EmpPageDate=
    	/* LocalDate dob = generateRandomDOB();
         int age = Period.between(dob, LocalDate.now()).getYears();
         System.out.println("date of birth"+dob);
         System.out.println("date of birth"+age);*/
    }
    
    public static LocalDate generateRandomDOB() {
        LocalDate today = LocalDate.now();

        // Age range: 20 to 60 years
        LocalDate maxDOB = today.minusYears(20); // latest possible DOB (youngest)
        LocalDate minDOB = today.minusYears(60); // oldest possible DOB

        // Random date between minDOB and maxDOB
        long start = minDOB.toEpochDay();
        long end = maxDOB.toEpochDay();

        long randomDay = ThreadLocalRandom.current().nextLong(start, end + 1);
        return LocalDate.ofEpochDay(randomDay);
    }
    
    
}
