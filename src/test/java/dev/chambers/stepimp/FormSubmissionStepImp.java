package dev.chambers.stepimp;

import dev.chambers.runner.TestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

import java.security.Key;
import java.time.Duration;

public class FormSubmissionStepImp {
    ChromeDriver driver = TestRunner.driver;

    @When("the employee clicks {string}")
    public void the_employee_clicks(String string) {
        WebElement newRequest= driver.findElement(By.id("submitRequest"));
        newRequest.click();
    }

    @When("the employee enters {string} into the Event Date field")
    public void the_employee_enters_into_the_event_date_field(String string) {
        WebElement date= driver.findElement(By.id("event_date"));
        date.sendKeys(string);
    }

    @When("the employee enters {string} into the Event Description field")
    public void the_employee_enters_into_the_event_description_field(String string) {
        WebElement desc= driver.findElement(By.id("event_description"));
        desc.sendKeys(string);
    }

    @When("the employee selects {string} from the Event Type dropdown")
    public void the_employee_selects_from_the_event_type_dropdown(String string) {
        WebElement eventType= driver.findElement(By.id("event_type"));
        eventType.sendKeys(string);
    }

    @When("the employee enters {string} into the Event Amount field")
    public void the_employee_enters_into_the_event_amount_field(String string) {
        WebElement amt= driver.findElement(By.id("event_amount"));
        amt.sendKeys(string);
    }

    @When("the employee selects \"Letter Grade \\(C to Pass) from the dropdown")
    public void the_employee_selects_letter_grade_c_to_pass_from_the_dropdown() {
        WebElement format= driver.findElement(By.id("grading_format"));
        format.sendKeys(Keys.DOWN);
    }

    @When("the employee clicks the {string} button")
    public void the_employee_clicks_the_button(String string) {
        WebElement submit = driver.findElement(By.id("submitRequest"));
        submit.click();
    }

    @When("the employee clicks the Check If Enough Funds button")
    public void the_employee_clicks_the_check_if_enough_funds_button() {
        WebElement chk = driver.findElement(By.id("checkFunds"));
        chk.click();
    }

    @Then("the employee should receive an alert stating that their allotted funds are insufficient to fully fulfill the request")
    public void the_employee_should_receive_an_alert_stating_that_their_allotted_funds_are_insufficient_to_fully_fulfill_the_request() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());
        assertEquals("Not enough funds to provide maximum allowed coverage. Full reimbursement is not guaranteed.",driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }

    @Then("the employee should receive an alert and be prompted to fill in more information")
    public void the_employee_should_receive_an_alert_and_be_prompted_to_fill_in_more_information() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());
        assertEquals("Please Select an Event Type",driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }

    @Then("an alert describing success should appear")
    public void anAlertDescribingSuccessShouldAppear() {
        driver.switchTo().alert().dismiss(); //dismisses the "enough funds" alert
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());
        assertEquals("Request Submitted",driver.switchTo().alert().getText());

    }

    @Given("there is no alert open")
    public void thereIsNoAlertOpen() {
        driver.switchTo().alert().dismiss();
    }
}
