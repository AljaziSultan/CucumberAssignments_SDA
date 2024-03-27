package assignmentsdacucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StepDefinitions_Assign02Week08 {

    private WebDriver driver;
    @Before
    @Given(" the user navigates to \"<page_url>\"")
    public void setup(String pageUrl) {
        driver = new ChromeDriver();
        driver.navigate().to(pageUrl);
    }




    @When("the user waits for the page to load (5 seconds)")
    public void waitSeconds() throws InterruptedException {
    Thread.sleep(5000);
    }


    @Then("the page title should contain the word \"<title>\"")
    public void verifyTitle(String title) {
        String actualTitle = driver.getTitle();
        Assertions.assertTrue( actualTitle.contains(title), "Page title does not contain" + title + "");
    }
    @After
    @Then("the user closes the browser window")
    public void clearUp() {
        driver.quit();
    }

}
