package com.jan.stepdef.pathe;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyPatheStepdefs {

    private WebDriver driver;

    public MyPatheStepdefs()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void afterTest()
    {
        driver.close();
        driver.quit();
    }

    @Given("user navigates to the home page")
    public void userNavigatesToTheHomePage() {
        driver.navigate().to("https://www.pathe.nl/");

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.pathe.nl/");
    }

    @Given("user is reading column {string}")
    public void userIsReadingColumnColumn(String columnName) {
        WebElement columnElement = driver.findElement(By.linkText(columnName));

        Assert.assertNotNull(columnElement);
        Assert.assertEquals(columnName, columnElement.getText());
    }
}
