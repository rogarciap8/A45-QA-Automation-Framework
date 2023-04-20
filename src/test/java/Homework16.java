import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {
    @Test
    public static void registrationNavigation() {
    //Added ChromeOptions argument below to fix websocket error
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");

    WebDriver driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    String url = "https://bbb.testpro.io/";
    driver.get(url);

    WebElement regLink = driver.findElement(By.cssSelector("#hel"));
    regLink.click();

    String regURL = "https://bbb.testpro.io/registration.php";
    Assert.assertEquals(driver.getCurrentUrl(),regURL);
    driver.quit();
    }
}