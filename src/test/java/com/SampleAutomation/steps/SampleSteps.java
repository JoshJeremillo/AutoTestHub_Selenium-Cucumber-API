package com.example.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.assertEquals;

public class SampleSteps {

    private WebDriver driver;

    @Given("I open Google")
    public void i_open_google() {
        // Automatically setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Configure Chrome to run headless (required for Codespaces / CI environments)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");           // Run without GUI
        options.addArguments("--no-sandbox");         // Linux requirement
        options.addArguments("--disable-dev-shm-usage"); // Reduce resource usage

        // Initialize WebDriver
        driver = new ChromeDriver(options);

        // Open Google homepage
        driver.get("https://www.google.com");
    }

    @Then("the title should be {string}")
    public void the_title_should_be(String expectedTitle) {
        // Verify the page title
        assertEquals(expectedTitle, driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
