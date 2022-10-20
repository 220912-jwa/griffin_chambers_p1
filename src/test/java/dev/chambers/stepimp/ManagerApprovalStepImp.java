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
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

public class ManagerApprovalStepImp {
    ChromeDriver driver = TestRunner.driver;
    @Given("the manager is logged in on the home page")
    public void the_manager_is_logged_in_on_the_home_page() {
        driver.get("http://localhost:8080/index.html");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("bigboss@corpo.org");
        WebElement pass = driver.findElement(By.id("pass"));
        pass.sendKeys("hunter2");
        //should really use env for user info
        WebElement login = driver.findElement(By.id("login"));
        login.click();
    }

    @When("the manager clicks {string} for a test case")
    public void the_manager_clicks_for_a_test_case(String string) {
        WebElement firstDetailsButton = driver.findElement(By.xpath("/html/body/div/table/tr[1]/td[8]/button"));
        firstDetailsButton.click();
    }

    @Then("the manager should be on a request page populated with the correct information")
    public void the_manager_should_be_on_a_request_page_populated_with_the_correct_information() {
        assertEquals("Request Details",driver.getTitle());
        //does not check to make sure table populates

    }

    @Then("the manager should have access to the manager-only tools")
    public void the_manager_should_have_access_to_the_manager_only_tools() {
        List<WebElement> statusSelect = driver.findElements(By.xpath("/html/body/p[1]/select"));
        assertTrue(statusSelect.size()!=0);
    }

    @When("the manager updates the request status to {string}")
    public void the_manager_updates_the_request_status_to(String string) {
        WebElement statusSelect = driver.findElement(By.xpath("/html/body/p[1]/select"));
        statusSelect.sendKeys(Keys.DOWN);
    }


    @Then("the request should update with the new information")
    public void the_request_should_update_with_the_new_information() {
        WebElement caseStatus = driver.findElement(By.xpath("/html/body/div/p[3]"));
        assertEquals("Approved -- Pending Grade",caseStatus.getText());
    }

    @When("the manager clicks the Confirm Changes button")
    public void theManagerClicksTheConfirmChangesButton() {
        WebElement confirmChanges = driver.findElement(By.xpath("/html/body/p[2]/button"));
    }

    @Then("the request should update with the new amount, and the Exceeds Funds box should be checked")
    public void theRequestShouldUpdateWithTheNewAmountAndTheExceedsFundsBoxShouldBeChecked() {
        WebElement exceedsFunds = driver.findElement(By.xpath("/html/body/div/p[5]"));
        assertEquals("true",exceedsFunds.getText());
    }

    @When("the manager enters {string} into the new Requested Funds input")
    public void theManagerEntersIntoTheNewRequestedFundsInput(String arg0) {
        WebElement updateAmount = driver.findElement(By.xpath("/html/body/div/p[4]/input"));
        updateAmount.sendKeys(arg0);
    }

    @Then("an alert with the text {string} should appear")
    public void anAlertWithTheTextShouldAppear(String arg0) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());
        assertEquals(arg0,driver.switchTo().alert().getText());
    }

    @When("the employee confirms the alert")
    public void theEmployeeConfirmsTheAlert() {
        driver.switchTo().alert().accept();
    }

    @Given("the employee is logged in on the home page")
    public void theEmployeeIsLoggedInOnTheHomePage() {
        driver.get("http://localhost:8080/index.html");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("john@corpo.org");
        WebElement pass = driver.findElement(By.id("pass"));
        pass.sendKeys("john1234");
        //should really use env for user info
        WebElement login = driver.findElement(By.id("login"));
        login.click();
    }

    @Then("an alert should appear notifying the employee of the altered request")
    public void anAlertShouldAppearNotifyingTheEmployeeOfTheAlteredRequest() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());
    }
}
