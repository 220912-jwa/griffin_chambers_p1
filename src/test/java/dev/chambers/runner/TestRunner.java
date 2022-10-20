package dev.chambers.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}, glue={"dev.chambers.stepimp"})
public class TestRunner {
    public static ChromeDriver driver;

    @BeforeClass
public static void setup(){
        File chrome = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",chrome.getAbsolutePath());
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    @AfterClass
public static void teardown(){driver.quit();}
}
