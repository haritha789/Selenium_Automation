/**
 *
 * Copyright 2020 (C)
 * @author Mohamed Mokhtar
 */

package test.java.runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

import java.net.InetAddress;
import java.net.UnknownHostException;

@CucumberOptions(glue = {"test.java.definitions"},
        plugin = {"json:target/cucumber-parallel/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"},
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

    private String getHostName(){
        String hostname = "Unknown";

        try
        {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        }
        catch (UnknownHostException ex)
        {
            System.out.println("Hostname can not be resolved");
        }
        return hostname;
    }


    @AfterClass
    public void writeExtent(){

        setSystemInfo("UserName",getHostName());
        setSystemInfo("OS",System.getProperty("platform"));
        setSystemInfo("Java Version",System.getProperty("java.version"));
        setSystemInfo("EndPoint",System.getProperty("endPoint"));
        setSystemInfo("Country",System.getProperty("country"));
        setSystemInfo("Environment",System.getProperty("environment"));
        setSystemInfo("Language",System.getProperty("language"));

    }

}
