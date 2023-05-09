package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    //Locators
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement playlist;
    @FindBy(css= "nav.menu.playlist-item-menu > ul > li:nth-child(1)")
    private WebElement editBtn;
    @FindBy(css = "[name='name']")
    private WebElement playlistBox;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public HomePage renamePl(String newPlName){
        rightClick(playlist);
        findElement(editBtn);
        click(editBtn);
        findElement(playlistBox).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        findElement(playlistBox).sendKeys(newPlName);
        findElement(playlistBox).sendKeys(Keys.ENTER);
        return this;
    }

    public boolean verifyPlaylistExists(String newPlaylist){
        //@FindBy(xpath = "//a[text()='"+newPlaylist+"']")
        WebElement newPl = driver.findElement(By.xpath("//a[text()='" + newPlaylist + "']"));
        return findElement(newPl).isDisplayed();
    }
}
