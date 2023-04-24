import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        //launch Koel website
        openURL();
        //Log in
        fillEmail("raul.garcia@testpro.io");
        fillPwd("te$t$tudent");
        clickLogIn();

        //Search for a song
        search("Reactor");

        //display search results
        showResults();

        //click first song in results
        clickSong();

        //click to add to playlist
        addToPL();

        //verify notification appears and song has been added to PL
        verifyAdded();
    }

    public void search(String songName) throws InterruptedException {
        WebElement searchBar = driver.findElement(By.cssSelector("[type='search']"));
        searchBar.sendKeys(songName);
        Thread.sleep(2000);
    }

    public void showResults() throws InterruptedException {
        WebElement viewALl = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewALl.click();
        Thread.sleep(2000);
    }

    public void clickSong() throws InterruptedException {
        WebElement song = driver.findElement(By.xpath("//td[text()='Reactor']"));
        song.click();
        Thread.sleep(2000);
    }

    public void addToPL() throws InterruptedException {
        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        WebElement PL = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'PL')]"));
        addTo.click();
        Thread.sleep(2000);
        PL.click();
        Thread.sleep(2000);
    }

    public void verifyAdded() {
        WebElement verifyMsg = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        verifyMsg.getText();
    }
}
