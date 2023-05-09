package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    //Locators
    private By emailField = By.cssSelector("input[type='email']");
    private By passwordField = By.cssSelector("input[type='password']");
    private By submit = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void provideEmail(String email) {
        WebElement emailBox = driver.findElement(emailField);
        emailBox.clear();
        emailBox.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordBox = driver.findElement(passwordField);
        passwordBox.clear();
        passwordBox.sendKeys(password);
    }

    public void clickSubmit() {
       driver.findElement(submit).click();
    }

    public void login(){
        provideEmail("raul.garcia@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
    }
}