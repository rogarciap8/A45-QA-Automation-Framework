import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest{
    @Test
    public void rename(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        String myNewPl = "Renamed Playlist";

        //GIVEN
        loginPage.login();

        //WHEN
        homePage.renamePl(myNewPl);

        //THEN
        Assert.assertTrue(homePage.verifyPlaylistExists(myNewPl));
    }
}
