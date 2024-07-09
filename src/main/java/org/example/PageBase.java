package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class PageBase {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-test-frontend-ce07bae316f3.herokuapp.com/");
       // driver.close();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }



        WebDriverWait webDriverWait;
        Actions actions;
        JavascriptExecutor js;
        Select select;
        List<WebElement> webElements;
        WebElement webElement;
        WebDriver webDriver;

        public PageBase(WebDriver webDriver) {
            webDriverWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(30));
            webDriverWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(30));
            actions = new Actions(this.webDriver);
            js = (JavascriptExecutor) this.webDriver;
        }


        /* custom click action with waiting to avoid loading issues*/
        public void click(By by, int index) {
            webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));
            webElements = webDriver.findElements(by);
            webElement = webElements.get(index - 1);
            webElement.click();
        }

        public void click(By by) {
            webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));
            webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));
            webElement = webDriver.findElement(by);
            webElement.click();
        }

        /* custom sendKey action with waiting to avoid element loading issues */
        public void type(By by, String Word) {
            webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));
            webElement = webDriver.findElement(by);
            webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(webElement)));
            webElement.clear();
            webElement.sendKeys(Word);
        }

        public void hover(By by, int numOfStars) {
            webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));
            webElements = webDriver.findElements(by);
            webElement = webElements.get(numOfStars - 1);
            actions.moveToElement(webElement).build().perform();
        }


        public void scrollInto(By by) {
            webElement = webDriver.findElement(by);
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
            js.executeScript("arguments[0].scrollIntoView();", webElement);
        }

        public void select (By by, String value){
            webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));
            webElements = webDriver.findElements(by);
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
            select= new Select(webDriver.findElement(by));
            select.selectByValue(value);
        }


    public void enterUsername(String nxttester) {
    }

    public void enterPassword(String s) {
    }

    public void clickLogin() {
    }
}
