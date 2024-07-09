package Steps;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-test-frontend-ce07bae316f3.herokuapp.com/");
        loginPage = new LoginPage(driver);
        loginPage.login();
        loginPage.Verify();
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        loginPage.enterUsername("nxttester");
        loginPage.enterPassword("nxt#qA@23");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        // Implement verification of successful login
        driver.quit();
    }
}
