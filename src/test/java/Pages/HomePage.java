package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    //Locators
    By playlist = By.cssSelector(".playlist:nth-child(3)");
    By editBtn = By.cssSelector("nav.menu.playlist-item-menu > ul > li:nth-child(1)");
    By playlistBox = By.cssSelector("[name='name']");

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void renamePl(String newPlName){
        rightClick(playlist);
        findElement(editBtn);
        click(editBtn);
        findElement(playlistBox).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        findElement(playlistBox).sendKeys(newPlName);
        findElement(playlistBox).sendKeys(Keys.ENTER);
    }

    public boolean verifyPlaylistExists(String newPlaylist){
        By newPl = By.xpath("//a[text()='"+newPlaylist+"']");
        return findElement(newPl).isDisplayed();
    }
}
