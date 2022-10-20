package dev.chambers.stepimp;

import dev.chambers.runner.TestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

import java.time.Duration;

public class LoginStepImp {
    ChromeDriver driver = TestRunner.driver;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get("http://localhost:8080/index.html");
    }

    @When("the user types {string} into the email field")
    public void the_user_types_into_the_email_field(String string) {
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(string);
    }

    @When("the user types {string} into the password field")
    public void the_user_types_into_the_password_field(String string) {
        WebElement pass = driver.findElement(By.id("pass"));
        pass.sendKeys(string);
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        WebElement login = driver.findElement(By.id("login"));
        login.click();
    }

    @Then("the Manager should see the cases they have access to")
    public void the_manager_should_see_the_cases_they_have_access_to() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/table/tr[2]/td[2]")));
        WebElement firstRequest = driver.findElement(By.xpath("/html/body/div/table/tr[2]/td[2]"));
        //does not yet programmatically check to see if more than one user ID is present in this column, just makes sure at least two requests are loaded
    }

    @Then("the Employee should see the cases they have access to")
    public void the_employee_should_see_the_cases_they_have_access_to() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/table/tr/td[2]")));
        WebElement firstRequest = driver.findElement(By.xpath("/html/body/div/table/tr/td[2]"));
        //does not yet programmatically check to see if user IDs match the current employee, just makes sure at least one request is loaded
    }


    @Then("the user should receive an alert prompting them to try again")
    public void theUserShouldReceiveAnAlertPromptingThemToTryAgain() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());
        String alertuser = driver.switchTo().alert().getText();
        assertEquals("Incorrect email/password combination. Please try again.",alertuser);
        driver.switchTo().alert().accept();
    }

}
