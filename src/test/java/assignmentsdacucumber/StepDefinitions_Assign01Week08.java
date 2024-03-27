package assignmentsdacucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StepDefinitions_Assign01Week08 {

    private WebDriver driver;
    private RegistrationPage registrationPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        registrationPage = new RegistrationPage(driver);
    }

    @After
    public void clearUp() {
        driver.quit();
    }

    @Given("I am on the registration page")
    public void goToRegistrationPage() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
    }

    @When("I enter valid registration details")
    public void enterValidDetails() {
        registrationPage
                .enterFirstName("Jaz")
                .enterLastName("Sul")
                .enterEmail("jazSul@gmail.com")
                .enterTelephone("966555555")
                .enterPassword("PassStrongWord123")
                .confirmPassword("PassStrongWord123")
                .checkAgreeCheckbox();
    }

    @When("I enter \"<invalid_data_field>\" with \"<invalid_value>\"")
    public void enterInvalidData(String field, String value) {
        switch (field) {
            case "First Name":
                registrationPage.enterFirstName(value);
                break;
            case "Last Name":
                registrationPage.enterLastName(value);
                break;
        }
    }

    @When("I submit the registration form")
    public void submitRegistration() {
        registrationPage.submitRegistration();
    }

    @Then("I should see a successful registration message")
    public void verifySuccessfulRegistration() {
        assert registrationPage.isSuccessMessageDisplayed();
    }

    @Then("I should see an error message for \"<invalid_data_field>\"")
    public void verifyErrorMessage(String field) {
        List<WebElement> errors = registrationPage.getErrorAlerts();
        boolean foundError = false;
        for (WebElement error : errors) {
            if (error.getText().contains(field)) {
                foundError = true;
                break;
            }
        }
        assert foundError : "Error message for " + field + " not found";
        String errorMessage = registrationPage.getErrorMessageForField(field);
        assert errorMessage != null && !errorMessage.isEmpty();
    }
}
