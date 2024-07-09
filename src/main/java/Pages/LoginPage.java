// LoginPage.java
package Pages;

import configration.LoadProperties;
import org.example.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    By usernameField = By.id("UserName");
    By passwordField = By.id("password");

    By SkipButton = By.xpath("//*[@id=\"root\"]/div[1]/div[5]/main/div/div/form/div/div[3]/button");
    By submitButton = By.id("//*[@id=\"root\"]/div[1]/div[5]/main/div/div/form/div/div[2]/button");




    public void login(){
        type(usernameField, LoadProperties.env.getProperty("UserName"));
    }

    public void Verify(){
        type(passwordField, LoadProperties.env.getProperty("PASSWORD"));
        click(SkipButton);
        click(submitButton);
    }


}
