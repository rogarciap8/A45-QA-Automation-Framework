import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Homework19 extends BaseTest{
    @Test
    public static void deletePL() throws InterruptedException {
        //GIVEN
        provideEmail("raul.garcia@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        //WHEN
        clickPL();
        deleteThePL();

        //THEN
        verifyMsg();
        assertTrue(verifyMsg());
    }
}
