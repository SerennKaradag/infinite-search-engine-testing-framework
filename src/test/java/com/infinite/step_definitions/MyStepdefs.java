package com.infinite.step_definitions;

import com.infinite.pages.SearchEnginePage;
import com.infinite.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
    private final SearchEnginePage searchEnginePageObj = new SearchEnginePage(Driver.getDriver());


    @Given("User open the browser")
    public void userOpenTheBrowser() {

    }

    @When("user search for {string} on {string}")
    public void userSearchForOn(String searchItem, String searchEngine) {
        String searchEngineUrl = searchEnginePageObj.getSearchEngineUrl(searchEngine);
        searchEnginePageObj.navigateToSearchEngine(searchEngineUrl);
        if (searchEngineUrl.contains("google")) {
            searchEnginePageObj.performSearchGoogle(searchItem);
        } else if (searchEngineUrl.contains("yahoo")) {
            searchEnginePageObj.performSearchYahoo(searchItem);
        } else if (searchEngineUrl.contains("bing")) {
            searchEnginePageObj.performSearchBing(searchItem);
        }
    }


    @Then("first result should contain {string} on {string}")
    public void firstResultShouldContainOn(String expectedText, String searchEngine) {
        String actualResult = searchEnginePageObj.getFirstResultText(searchEngine);
        Assert.assertTrue("Actual Result: " + actualResult + " does not contain Expected Text: " + expectedText,
                actualResult.contains(expectedText));

    }
}
