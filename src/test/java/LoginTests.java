import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTests extends BaseTest{
    //@Test
    public static void registrationNavigation(){
        if (System.getProperty("os.name").toLowerCase().contains("win")){
            System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        }
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement regLink = driver.findElement(By.cssSelector("button[type='submit']"));
        regLink.click();

        //WebElement register = driver.findElement(By.cssSelector(""));
        String regURL = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(),regURL);
        driver.quit();
    }
}

