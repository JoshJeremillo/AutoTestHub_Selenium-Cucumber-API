package com.example.steps;


import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;


public class SampleSteps {


WebDriver driver;


@Given("I open Google")
public void i_open_google() {
driver = new ChromeDriver();
driver.get("https://www.google.com");
}


@Then("the title should be {string}")
public void the_title_should_be(String expectedTitle) {
assertEquals(expectedTitle, driver.getTitle());
driver.quit();
}
}
