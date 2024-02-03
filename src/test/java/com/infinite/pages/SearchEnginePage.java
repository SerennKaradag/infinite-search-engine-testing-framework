package com.infinite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.infinite.utilities.BrowserUtil.waitForVisibilityOf;

public class SearchEnginePage {

    private WebDriver driver;

    public SearchEnginePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSearchEngineUrl(String searchEngine) {

        switch (searchEngine.toLowerCase()) {
            case "google":
                return "https://www.google.com";
            case "bing":
                return "https://www.bing.com";
            case "yahoo":
                return "https://www.yahoo.com";
            default:
                throw new IllegalArgumentException("Unsupported search engine: " + searchEngine);
        }
    }

    public void navigateToSearchEngine(String searchEngineDefault) {
        try {
            if (searchEngineDefault != null && !searchEngineDefault.isEmpty()) {
                driver.get(searchEngineDefault);
            } else {
                throw new IllegalArgumentException("Search engine URL is null or empty.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void performSearchGoogle(String searchItem) {
        WebElement searchBoxGoogle = driver.findElement(By.xpath("//textarea[@name='q']"));
        waitForVisibilityOf(searchBoxGoogle);
        searchBoxGoogle.sendKeys(searchItem);
        searchBoxGoogle.sendKeys(Keys.ENTER);
    }

    public void performSearchBing(String searchItem) {
        WebElement bingSearchBox = driver.findElement(By.xpath("//textarea[@name='q']"));
        waitForVisibilityOf(bingSearchBox);
        bingSearchBox.sendKeys(searchItem);
        bingSearchBox.sendKeys(Keys.ENTER);
    }

    public void performSearchYahoo(String searchItem) {
        WebElement yahooSearchBox = driver.findElement(By.xpath("//input[@id='ybar-sbq']"));
        waitForVisibilityOf(yahooSearchBox);
        yahooSearchBox.sendKeys(searchItem);
        yahooSearchBox.sendKeys(Keys.ENTER);
    }


    public String getFirstResultText(String searchEngine) {

        if (searchEngine.contains("google")) {
            WebElement firstResultGoogle = driver.findElement(By.xpath("(//div[@id='search']//h3)[1]")); // Adjust the locator based on your actual first result element
            waitForVisibilityOf(firstResultGoogle);
            return firstResultGoogle.getText();
        } else if (searchEngine.contains("yahoo")) {
            WebElement firstResultYahoo = driver.findElement(By.xpath("(//div[@id='main']//h3//a)[1]"));
            waitForVisibilityOf(firstResultYahoo);
            return firstResultYahoo.getText();
        } else if (searchEngine.contains("bing")) {
            WebElement firstResultBing = driver.findElement(By.xpath("(//ol[@id='b_results']//h2//a)[1]"));
            waitForVisibilityOf(firstResultBing);
            return firstResultBing.getText();
        }
        return ("No search engine matched - not first result matched");
    }
}
