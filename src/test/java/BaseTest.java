import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {

    public static WebDriver driver = null;
    public static String url = "";
    static WebDriverWait wait;

    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @DataProvider(name="IncorrectLoginData")
    public static Object[][] getDataFromDataProviders() {

        return new Object[][] {
                {"invalid@mail.com", "invalidPass"},
                {"demo@class.com", ""},
                {"", ""}
        };
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        navigateToPage();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver,Duration.ofSeconds(4));
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public static void navigateToPage() {
        driver.get(url);
    }

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();//not needed
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();//not needed
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

    public static void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public static void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public static void provideCurrentPassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    public static void clickPL(){
        WebElement pl = driver.findElement(By.xpath("//a[text()='PL']"));
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='PL']")));
        pl.click();
    }

    public static void deleteThePL(){
        WebElement delPlBtn = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        //Thread.sleep(1000);*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.del.btn-delete-playlist")));
        delPlBtn.click();

        /* WebElement okBtn = driver.findElement(By.cssSelector("button.ok"));
        okBtn.click();
        //Thread.sleep(1000); */
    }

    public static boolean verifyMsg(){
        boolean present = true;
        try {
            driver.findElement(By.xpath("//*[contains(text(),'Deleted playlist')]"));
        } catch (NoSuchElementException e){
            present = false;
        }
        return present;
    }
}