package Raul_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RG_BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public RG_BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator){
        findElement(locator).click();
    }

    public void doubleClick(By locator){
        actions.doubleClick(findElement(locator)).perform();
    }

    public void rightClick(By locator){
        actions.contextClick(findElement(locator)).perform();
    }
}
