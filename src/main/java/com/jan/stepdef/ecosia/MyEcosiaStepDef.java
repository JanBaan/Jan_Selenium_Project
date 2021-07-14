package com.jan.stepdef.ecosia;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyEcosiaStepDef {
    private WebDriver driver;
    private WebElement searchBar;
    private WebDriverWait wait;

    public MyEcosiaStepDef()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 20);
    }

    @After
    public void afterTest()
    {
        driver.close();
        driver.quit();
    }

    @Given("user goes to home page")
    public void userGoesToHomePAge() {
        driver.navigate().to("https://www.ecosia.org");
    }

    @Given("user selects the search bar")
    public void userClicksOnTheSearchBar() {
        searchBar = driver.findElement(By.className("search-form__input"));
    }

    @Then("user types {string} in the search bar")
    public void userSearchFor(String input) {
        searchBar.sendKeys(input);
        searchBar.submit();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        String url = driver.getCurrentUrl();

        boolean checkInput = url.contains(input);
        Assert.assertTrue(checkInput);
    }

    @And("select the {string} tab")
    public void selectsTheTab(String tabName) throws InterruptedException{
        WebElement tab = driver.findElement(By.linkText(tabName));
        tab.click();

        Thread.sleep(2000);

        String url = driver.getCurrentUrl();

        boolean checkTabName = url.contains(tabName.toLowerCase());
        Assert.assertTrue(checkTabName);
    }
}
