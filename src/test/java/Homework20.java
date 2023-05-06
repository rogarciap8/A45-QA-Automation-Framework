import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class Homework20 extends BaseTest{
        @Test
        public void deletePlaylist(){
            //GIVEN
            provideEmail("raul.garcia@testpro.io");
            providePassword("te$t$tudent");
            clickSubmit();

            //WHEN
            clickPl();
            deleteThePL();

            //THEN
            verifyMsg();
            assertTrue(verifyMsg());
        }
    }
