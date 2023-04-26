import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
    //GIVEN
        //Log in to Koel website
        navigateToPage();
        provideEmail("raul.garcia@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

    //WHEN
        //Click the next song button & click play
        clickNextSongBtn();
        pressPlay();
        Thread.sleep(2000);

    // THEN
        //Validate that a song is playing by verifying if the pause button is displayed.
        assertTrue(verifyPlaying());
    }
}
