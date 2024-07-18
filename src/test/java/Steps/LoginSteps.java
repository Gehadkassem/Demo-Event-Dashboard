package Steps;

import Pages.LoginPage;
import Steps.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps() {
        this.driver = BaseTest.driver; // Get the WebDriver instance from BaseTest
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage = new LoginPage(driver);
        loginPage.login();
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        loginPage.enterUsername("nxttester");
        loginPage.enterPassword("nxt#qA@23");
    }

    @When("I click the login button")
    public void i_click_the_login_button() throws InterruptedException {
        loginPage.clickLogin();

    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        // Implement verification of successful login
        BaseTest.tearDown();
    }
}
