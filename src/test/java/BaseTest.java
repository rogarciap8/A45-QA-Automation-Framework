import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    public static WebDriver driver = null;
    public ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static String url = "";
//    static WebDriverWait wait;
//    Actions action;

/*
    @BeforeSuite
    public static void setupClass() {WebDriverManager.chromedriver().setup();}
*/

//    @DataProvider(name="IncorrectLoginData")
//    public static Object[][] getDataFromDataProviders() {
//
//        return new Object[][] {
//                {"invalid@mail.com", "invalidPass"},
//                {"demo@class.com", ""},
//                {"", ""}
//        };
//    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
/*
      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
*/
        try {
            driver = pickBrowser(System.getProperty("browser"));
            threadDriver.set(driver);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        getDriver().get(BaseURL);
//        navigateToPage();
        driver.manage().window().maximize();
        System.out.println(
                "Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getDriver());

//        wait = new WebDriverWait(driver,Duration.ofSeconds(4));
//        action = new Actions(driver);
    }

    @AfterMethod
    public void closeBrowser() {
        getDriver().close();
        threadDriver.remove();
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }

//    public void navigateToPage() {
//        threadDriver.get(url);
//    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.162:4444";

        switch (browser) {
            case "firefox": //gradle clean test -Dbrowser=firefox
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return driver = new FirefoxDriver(optionsFirefox);
            case "MicrosoftEdge": //gradle clean test -Dbrowser=Microsoft Edge
                WebDriverManager.edgedriver().setup();
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(eOptions);
            case "grid-firefox": //gradle clean test -Dbrowser=grid-firefox
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome": //gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-edge": //gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }

    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "rogarciap8";
        String accessToken = "I0lwv2TvaOM1uhUEbbvkRZvGpNYtAMK4Qlh9a3NJojsIor79nw";
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        FirefoxOptions browserOptions = new FirefoxOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("112.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", accessToken);
        ltOptions.put("project", "Untitled");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }
}

    /*
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

    public void clickPl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='PL']")));
        WebElement pl = driver.findElement(By.xpath("//a[text()='PL']"));
        action.moveToElement(pl).perform();
        action.click(pl).perform();
        //pl.click();
    }

    public void renamePl(){
        WebElement pl = driver.findElement(By.xpath("//a[text()='PL']"));
        action.contextClick(pl).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav.menu.playlist-item-menu > ul > li:nth-child(1)")));
        WebElement renameOption = driver.findElement(By.cssSelector("nav.menu.playlist-item-menu > ul > li:nth-child(1)"));

        action.moveToElement(renameOption).perform();
        action.click(renameOption).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='inline-playlist-name-input']")));
        WebElement textBox = driver.findElement(By.cssSelector("[data-testid='inline-playlist-name-input']"));
        textBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        textBox.sendKeys("Renamed Playlist");
        textBox.sendKeys(Keys.ENTER);
    }

    public static void deleteThePL(){
        WebElement delPlBtn = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.del.btn-delete-playlist")));
        delPlBtn.click();

        WebElement okBtn = driver.findElement(By.cssSelector("button.ok"));
        okBtn.click();
        //Thread.sleep(1000);
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

    public static boolean verifyRenamed(){
        boolean renamed = true;
        try {
            driver.findElement(By.cssSelector("div.success.show"));
        } catch (NoSuchElementException e){
            renamed = false;
        }
        return renamed;
    }
} */