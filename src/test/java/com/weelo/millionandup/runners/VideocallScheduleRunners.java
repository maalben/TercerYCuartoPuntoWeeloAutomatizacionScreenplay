package com.weelo.millionandup.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/videocall_schedule.feature",
        glue = "com.weelo.millionandup.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)

public class VideocallScheduleRunners {
}
