package assignmentsdacucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationPage {

    private WebDriver driver;

    private By firstNameInput = By.id("input-firstname");
    private By lastNameInput = By.id("input-lastname");
    private By emailInput = By.id("input-email");
    private By telephoneInput = By.id("input-telephone");
    private By passwordInput = By.id("input-password");
    private By confirmPasswordInput = By.id("input-confirm");
    private By agreeCheckbox = By.name("agree");
    private By submitButton = By.cssSelector("input[type='submit']");
    private By successAlert = By.cssSelector(".alert.alert-success");
    private By errorAlerts = By.cssSelector(".text-danger");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        return this; // Fluent interface for method chaining
    }
    public RegistrationPage enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this; // Fluent interface for method chaining
    }
    public RegistrationPage enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this; // Fluent interface for method chaining
    }
    public RegistrationPage enterTelephone(String telephone) {
        driver.findElement(telephoneInput).sendKeys(telephone);
        return this; // Fluent interface for method chaining
    }
    public RegistrationPage enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this; // Fluent interface for method chaining
    }
    public RegistrationPage confirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
        return this; // Fluent interface for method chaining
    }
    public RegistrationPage checkAgreeCheckbox() {
        driver.findElement(agreeCheckbox).click();
        return this; // Fluent interface for method chaining
    }
    public RegistrationPage submitRegistration() {
        driver.findElement(submitButton).click();
        return this;
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successAlert).isDisplayed();
    }

    public List<WebElement> getErrorAlerts() {
        return driver.findElements(errorAlerts);
    }

    public String getErrorMessageForField(String fieldName) {
        By errorLocator = null;
        switch (fieldName) {
            case "First Name":
                errorLocator = By.xpath("//input[@id='input-firstname']/following-sibling[@class='text-danger']");
                break;
            // Add similar cases for other fields
        }
        if (errorLocator != null) {
            return driver.findElement(errorLocator).getText();
        } else {
            return null; // Handle case where error locator not found
        }
    }
}
