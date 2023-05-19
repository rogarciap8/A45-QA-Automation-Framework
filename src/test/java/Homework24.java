import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework24 extends BaseTest{
    @Test
    public void rename(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        String myNewPl = "Renamed Playlist";

        //GIVEN
        loginPage.login();
        //loginPage.provideEmail("raul.garcia@testpro.io").providePassword("te$t$tudent").clickSubmit();

        //WHEN
        homePage.renamePl(myNewPl);

        //THEN
        Assert.assertTrue(homePage.verifyPlaylistExists(myNewPl));
    }
}