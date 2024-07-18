package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[contains(text(),'Login')]");
    private By SkipButton = By.xpath("//button[contains(text(),'Skip (only for testing)')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLogin() throws InterruptedException {
        click(loginButton);
        Thread.sleep(3000);
        click(SkipButton);
    }

    public void login() {
        driver.get("https://qa-test-frontend-ce07bae316f3.herokuapp.com/");
    }
}
