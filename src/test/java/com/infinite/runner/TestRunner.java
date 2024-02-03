package com.infinite.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/infinite/step_definitions",
        plugin = {
                "pretty", "html:target/cucumber-reports"
        },
        dryRun = false

)

public class TestRunner {
}

