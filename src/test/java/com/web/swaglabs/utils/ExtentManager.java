package com.web.swaglabs.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

    public class ExtentManager {
        private static ExtentReports extent;

        public static ExtentReports createInstance() {
            String reportPath = "reports/extent-report.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("Automation Test Web Report");
            reporter.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Squad", "Cuan Squad");
            return extent;
        }

}
