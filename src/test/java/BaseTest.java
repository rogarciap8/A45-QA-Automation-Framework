import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;

    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupBrowser() {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

   @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void openURL() throws InterruptedException {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    public void fillEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void fillPwd(String password) {
        WebElement pwdField = driver.findElement(By.cssSelector("[type='password']"));
        pwdField.clear();
        pwdField.sendKeys(password);
    }

    public void clickLogIn() throws InterruptedException {
        WebElement logInBtn = driver.findElement(By.cssSelector("[type='submit']"));
        logInBtn.click();
        Thread.sleep(2000);
    }

    //Adding these to delete the song from the playlist at the end, otherwise, it won't display the validation message!
    /* @AfterMethod
    public void clickPL() throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath("//a[contains(text(),'PL')]"));
        playlist.click();
        System.out.println("test");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void deleteSong() throws InterruptedException {
        //WebElement songToDelete = driver.findElement(By.cssSelector("section#playlistWrapper tr.song-item.selected"));
        //WebElement songToDelete = driver.findElement(By.xpath("//td[contains(text(),'Reactor')]"));
        //WebElement songToDelete = driver.findElement(By.cssSelector("tr.song-item.selected > td.title"));
        //WebElement songToDelete = driver.findElement(By.xpath("//tr[@class='song-item selected']//td[text()='Reactor']"));
        WebElement songToDelete = driver.findElement(By.cssSelector("section#playlistWrapper tr.song-item td.title"));
        songToDelete.click();
        System.out.println("clicked on it");
        //Thread.sleep(2000);
        //songToDelete.sendKeys(Keys.DELETE);
        //Thread.sleep(2000);
    } */
}