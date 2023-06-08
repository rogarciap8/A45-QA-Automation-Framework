import Raul_Pages.RG_BaseTest;
import Raul_Pages.RG_LoginPage;
import org.testng.annotations.Test;

public class UpdatePWD extends RG_BaseTest {
//    public UpdatePWD(WebDriver givenDriver) {
//        super(givenDriver);
//    }

    @Test
    public void updateMyPWD() {
        RG_LoginPage raulLoginPage = new RG_LoginPage(driver);
        raulLoginPage.logIn();
        raulLoginPage.isAvatarVisible();
    }
}
