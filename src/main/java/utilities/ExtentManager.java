package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportName = "TestReport_" + timeStamp + ".html";

            ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + reportName);
            spark.config().setDocumentTitle("Orange HRM Automation Report");
            spark.config().setReportName("Automation Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
