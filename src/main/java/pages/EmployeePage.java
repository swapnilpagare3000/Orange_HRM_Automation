package pages;

import java.time.Duration;
import java.time.LocalDate;

import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePage {
	protected final Logger logger = LogManager.getLogger(this.getClass());
	WebDriver driver;
	By pimMenu = By.xpath("//span[text()='PIM']");
	By addEmployee = By.xpath("//a[text()='Add Employee'] | //button[contains(.,'Add')]");
	By firstName = By.name("firstName");
	By lastName = By.name("lastName");
	By saveBtn = By.xpath("//button[@type='submit']");
	By empsearchname = By
			.xpath("//label[text()='Employee Name']/following::input[@placeholder='Type for hints...'][1]");
	By searchbutton = By.xpath("//button[@type=\"submit\"]");
	By namedropdisplay = By
			.xpath("//div[@class=\"oxd-autocomplete-text-input oxd-autocomplete-text-input--active\"][1]");
	By middlename = By.xpath("//input[@placeholder='Middle Name']");
	By otherId = By.xpath("//label[text()='Other Id']/following::input[1]");
	By editbutton = By.xpath("//button[@class=\"oxd-icon-button oxd-table-cell-action-space\"][1]");
	By Nationdropdownpage = By
			.xpath("//label[text()='Nationality']/following::div[@class='oxd-select-text oxd-select-text--active'][1]");
	By DdwonIndian = By.xpath("//div[@role='option']/span[text()='Indian']");
	By Maritaldropdownpage = By.xpath(
			"//label[text()='Marital Status']/following::div[@class='oxd-select-text oxd-select-text--active'][1]");
	By Ddwonmarital = By.xpath("//div[@role='option']/span[text()='Single']");
	By editsaveBtn = By.xpath(
			"//h6[text()='Personal Details']/ancestor::div[contains(@class, 'orangehrm-horizontal-padding')]//button[@type='submit' and normalize-space()='Save']");
	By deleteemployee = By.xpath("//button[@class=\"oxd-icon-button oxd-table-cell-action-space\"][2]");
	By deletepopup = By.xpath("//button[@type='button' and normalize-space()='Yes, Delete']");
	By dobdateselect = By.xpath("//label[text()='Date of Birth']/following::i[contains(@class,'oxd-date-input-icon')]");

	public EmployeePage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToAddEmployee() {
		driver.findElement(pimMenu).click();
		driver.findElement(addEmployee).click();
		logger.info("Test");

		// driver.findElement(addEmployee).click();

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
		// WebElement menuItem =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(empsearchname));
		// menuItem.click();

		// driver.findElement(empsearchname).sendKeys(searchname);
		Thread.sleep(3000);
		driver.findElement(namedropdisplay).isDisplayed();
		driver.findElement(empsearchname).sendKeys(searchname);
		logger.info("Is displayed ?");
		// System.out.println(isd);

		Thread.sleep(3000);
		// driver.findElement(namedropdisplay).click();
		// logger.info("Is namedrop click ?");
		// Thread.sleep(3000);
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
		driver.findElement(Nationdropdownpage).click();
		driver.findElement(DdwonIndian).click();
		driver.findElement(Maritaldropdownpage).click();
		driver.findElement(Ddwonmarital).click();
		logger.info("dropdown selected");
		// Save the button
		
		// Generate and store random DOB day, month, year (between 20 to 70 years)
		LocalDate dob = generateRandomDOB();
		int dobDay = dob.getDayOfMonth();
		int dobMonth = dob.getMonthValue();
		int dobYear = dob.getYear();
		logger.info("Random DOB: Day=" + dobDay + ", Month=" + dobMonth + ", Year=" + dobYear);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Wait until loader disappears
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
		    By.cssSelector("div.oxd-form-loader")
		));
		driver.findElement(dobdateselect).click();
		Thread.sleep(3000);
		/*
		 * String dropdobyear =driver.findElement(By.
		 * xpath("cant find xpath for year because calendar is vanishing")).getText();
		 * String dropdobmonth =driver.findElement(By.
		 * xpath("cant find xpath for year because calendar is vanishing")).getText();
		 * String dropdobday =driver.findElement(By.
		 * xpath("cant find xpath for year because calendar is vanishing")).getText();
		 * 
		 * if( dropdobyear.equals(dobYear)) { //do action until we find the correct year
		 * }
		 * 
		 * if( dropdobmonth.equals(dobMonth)) { //do action until we find the correct
		 * month } if( dropdobday.equals(dobDay)) { //do action until we find the
		 * correct day }
		 */

		// Click calendar icon
		// driver.findElement(By.xpath("//label[text()='Date of
		// Birth']/following::i[contains(@class,'oxd-date-input-icon')]")).click();

		// Select Year
		while (true) {
			String year = driver.findElement(By.xpath("//div[contains(@class,'oxd-calendar-selector-year-selected')]"))
					.getText();
			if (year.equals(dobYear)) {
				Thread.sleep(3000);
				break;

			} else {
				// click previous/next arrow depending on your logic
				driver.findElement(By.xpath("//button[contains(@class,'oxd-calendar-nav-prev')]")).click();
				Thread.sleep(3000);
			}
		}

		// Select Month
		while (true) {
			String month = driver
					.findElement(By.xpath("//div[contains(@class,'oxd-calendar-selector-month-selected')]")).getText();
			if (month.equals(dobMonth)) {
				Thread.sleep(3000);
				break;

			} else {
				// click previous/next arrow depending on your logic
				driver.findElement(By.xpath("//button[contains(@class,'oxd-calendar-nav-prev')]")).click();
				Thread.sleep(3000);
			}
			
			
		}

		// Select Day
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='oxd-calendar-date' and text()='" + dobDay + "']")).click();
		
		driver.findElement(editsaveBtn).click();

	}

	public static LocalDate generateRandomDOB() {
		LocalDate today = LocalDate.now();
		LocalDate maxDOB = today.minusYears(20); // youngest
		LocalDate minDOB = today.minusYears(70); // oldest
		long start = minDOB.toEpochDay();
		long end = maxDOB.toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(start, end + 1);
		return LocalDate.ofEpochDay(randomDay);
	}

	public void deletesearchemployee(String searchname) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		logger.info("Before PIM menu");
		driver.findElement(pimMenu).click();
		WebElement pim = driver.findElement(By.xpath("//span[text()='PIM']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(pim).click().perform();

		logger.info("After PIM menu");
		driver.findElement(empsearchname).sendKeys(searchname);
		Thread.sleep(3000);
		driver.findElement(searchbutton).click();
		Thread.sleep(3000);
		logger.info("Search Click");
		driver.findElement(deleteemployee).click();
		logger.info("click on button");
		WebElement deletepopupm = driver.findElement(deletepopup);
		Actions actionss = new Actions(driver);
		actionss.moveToElement(deletepopupm).click().perform();
		logger.info("Employee deleted");
		// driver.findElement(Deletepopup).click();

	}

}