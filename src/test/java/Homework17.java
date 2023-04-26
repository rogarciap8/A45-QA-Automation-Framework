import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
    //Given
        String addedNotif = "Added 1 song into";

        //Launch Koel website
        openURL();

        //Log in
        fillEmail("raul.garcia@testpro.io");
        fillPwd("te$t$tudent");
        clickLogIn();

    //When
        //Search for a song
        search("Reactor");

        //Display search results
        showResults();

        //Click first song in results
        clickSong();

        //Click add to button
        clickAddTo();

        //Click to add to playlist
        addToPL();

    //Then
        //Verify notification appears and song has been added to PL
        Assert.assertTrue(verifyAdded().contains(addedNotif));
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
        WebElement song = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        song.click();
        Thread.sleep(2000);
    }

    public void clickAddTo() throws InterruptedException {
        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        addTo.click();
        Thread.sleep(2000);
    }
    public void addToPL() throws InterruptedException {
        WebElement PL = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'PL')]"));
        PL.click();
        Thread.sleep(2000);
    }

    public String verifyAdded() throws InterruptedException {
        WebElement verifyMsg = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        //System.out.println("The message was displayed and the song was added!");
        //Thread.sleep(2000);
        return verifyMsg.getText();
    }
}
