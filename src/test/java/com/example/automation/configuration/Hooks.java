
package com.example.automation.configuration;

import com.example.automation.steps.ImportResultsToXRAY;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class Hooks {
    String browser = System.getProperty("selenium.browser");
    @Before
    public void setUp() {
        DriverFactory.getDriver(browser);
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver(browser);
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File("target/screenshots/capture_" + scenario.getName() + ".png");
            FileUtils.copyFile(source, destination);

            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
        DriverFactory.quitDriver();
    }

    /*
    @AfterClass
    public static void exportJSON() throws IOException, NoSuchAlgorithmException, KeyStoreException, InterruptedException, KeyManagementException {
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        ImportResultsToXRAY importXRAY = new ImportResultsToXRAY();
        importXRAY.solution2();
    }
    */
}