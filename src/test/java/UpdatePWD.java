import Raul_Pages.RG_LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UpdatePWD extends RG_LoginPage {
    public UpdatePWD(WebDriver givenDriver) {
        super(givenDriver);
    }

    @Test
    public void updateMyPWD() {
        RG_LoginPage raulLoginPage = new RG_LoginPage(driver);
        //raulLoginPage.logIn();
        //raulLoginPage.isAvatarVisible();
        raulLoginPage.inputEmail("raul.garcia@testpro.io");
        raulLoginPage.inputPassword("te$t$tudent");
        raulLoginPage.submit();
        raulLoginPage.isAvatarVisible();
    }
}
