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

public class GradeUploadStepImp {
    ChromeDriver driver = TestRunner.driver;

    @When("the employee inputs {string} into the grade field")
    public void the_employee_inputs_into_the_grade_field(String string) {
        WebElement inputGrade = driver.findElement(By.id("inputGrade"));
        inputGrade.sendKeys(string);
    }

    @When("the employee clicks the Confirm Grade button")
    public void the_employee_clicks_the_confirm_grade_button() {
        WebElement confirm = driver.findElement(By.id("confirmGrade"));
        confirm.click();
    }

    @Then("the status of the case should change")
    public void the_status_of_the_case_should_change() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the manager updates the request status {string}")
    public void the_manager_updates_the_request_status(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
