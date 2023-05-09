import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest{
    @Test
    public void rename(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        String myNewPl = "Renamed Playlist";

        //GIVEN
        //loginPage.login();
        loginPage.provideEmail("raul.garcia@testpro.io").providePassword("te$t$tudent").clickSubmit();

        //WHEN
        homePage.renamePl(myNewPl);

        //THEN
        Assert.assertTrue(homePage.verifyPlaylistExists(myNewPl));
    }
}
