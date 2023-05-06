import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() throws InterruptedException {
        //GIVEN
        provideEmail("raul.garcia@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        //WHEN
        renamePl();

        //THEN
        verifyRenamed();
        assertTrue(verifyRenamed());
    }
}
