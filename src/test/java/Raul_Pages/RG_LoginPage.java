package Raul_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RG_LoginPage extends RG_BasePage{
    @FindBy(css = "input[type='email']")
    private WebElement emailField;

    @FindBy(css = "input[type='password']")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement submitBtn;

    @FindBy(css = "img[class='avatar']")
    private WebElement avatarIcon;

    public RG_LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public RG_LoginPage inputEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public RG_LoginPage inputPassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public RG_LoginPage submit(){
        submitBtn.click();
        return this;
    }

    public void logIn(){
        inputEmail("raul.garcia@testpro.io");
        inputPassword("te$t$tudent");
        submit();
    }

    public void isAvatarVisible(){
        Assert.assertTrue(avatarIcon.isDisplayed());
    }
}
