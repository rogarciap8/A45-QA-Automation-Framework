package stepDefinition;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I open a browser")
    public void iOpenABrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And("I open the Login Page")
    public void iOpenTheLoginPage() {
        driver.get("https://bbb.testpro.io");
    }

    @When("I enter the email address{string}")
    public void iEnterTheEmailAddress(String email) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
        LoginPage logInEmail= new LoginPage(driver);
        logInEmail.provideEmail(email);
    }

    @And("I enter the password {string}")
    public void iEnterThePassword(String password) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
        LoginPage logInPassword = new LoginPage(driver);
        logInPassword.providePassword(password);
    }

    @And("I submit")
    public void iSubmit() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();
        LoginPage submit = new LoginPage(driver);
        submit.clickSubmit();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
        driver.quit();
    }
}