package org.prog.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.cucumber.steps.WebSteps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.prog.cucumber.steps",
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-report.html"
        })
public class CucumberAllTestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setUp() {
        WebSteps.driver = new ChromeDriver();
    }

    @AfterSuite
    public void tearDown() {
        WebSteps.driver.quit();
    }
}
