package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageBase {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected Actions actions;
    protected JavascriptExecutor js;
    protected Select select;
    protected List<WebElement> webElements;
    protected WebElement webElement;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    public void click(By by, int index) {
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));
        webElements = driver.findElements(by);
        webElement = webElements.get(index - 1);
        webElement.click();
    }

    public void click(By by) {
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));
        webElement = driver.findElement(by);
        webElement.click();
    }

    public void type(By by, String Word) {
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));
        webElement = driver.findElement(by);
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(webElement)));
        webElement.clear();
        webElement.sendKeys(Word);
    }

    public void hover(By by, int numOfStars) {
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));
        webElements = driver.findElements(by);
        webElement = webElements.get(numOfStars - 1);
        actions.moveToElement(webElement).build().perform();
    }

    public void scrollInto(By by) {
        webElement = driver.findElement(by);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void select(By by, String value) {
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));
        webElements = driver.findElements(by);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }
}
