Orange HRM Automation Project
=============================

How to import in Eclipse:
1. Unzip the project.
2. In Eclipse: File -> Import -> Maven -> Existing Maven Projects -> select the project's pom.xml.
3. Update Maven dependencies (Right-click project -> Maven -> Update Project).
4. Run tests using Maven or TestNG suite (testng.xml).

Notes:
- WebDriver binaries are managed via WebDriverManager dependency.
- Configurations in src/test/resources/config.properties
- Some locators may need adjustments if OrangeHRM UI changes.
- API endpoints used are example paths; validate API availability on the demo instance.
