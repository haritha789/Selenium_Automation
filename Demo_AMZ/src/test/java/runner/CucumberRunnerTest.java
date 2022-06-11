/**
 * Copyright 2020 (C)
 *
 * @author Mohamed Mokhtar
 */

package test.java.runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import main.java.utils.manageDriver.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

@CucumberOptions(glue = {"test.java.definition"},
        plugin = {"pretty", "json:target/cucumber-parallel/cucumber.json", "html:target/cucumber-reports",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"},
        features = {"src/test/resources/features/"}
)
/**
 * The Class RunnerIT.
 */
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
    public static void setSystemInfo(String key, String value) {
        getExtentReports().setSystemInfo(key, value);
    }

    private static ExtentReports getExtentReports() {
        return ExtentService.getInstance();
    }

    @AfterClass
    public void writeExtent() {

        setSystemInfo("OS", System.getProperty("platform"));
        setSystemInfo("Java Version", System.getProperty("java.version"));
        setSystemInfo("EndPoint", System.getProperty("endPoint"));
        setSystemInfo("Country", System.getProperty("country"));
        setSystemInfo("Environment", System.getProperty("environment"));
        setSystemInfo("Language", System.getProperty("language"));
    }

    @AfterSuite
    public void teardown() {
        DriverManager.quitBrowser();
    }

}
