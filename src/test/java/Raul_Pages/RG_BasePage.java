package Raul_Pages;

import A45_Files.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RG_BasePage extends BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public RG_BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    protected WebElement findElement(WebElement webElement){
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void click(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    protected void doubleClick(WebElement webElement){
        actions.doubleClick(findElement(webElement)).perform();
    }

    protected void rightClick(WebElement webElement){
        actions.contextClick(findElement(webElement)).perform();
    }
}
