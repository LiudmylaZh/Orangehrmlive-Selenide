import com.codeborne.selenide.Configuration;
import org.junit.Test;

public class LoginTest extends BaseTest{
    @Test
    public void elementsAreVisible () {
        loginPage.logoImageIsCorrect();
        loginPage.credSectionIsDisplayed();
        loginPage.logoIsDisplayed();
    }
    @Test
    public void successLogin() {
        Configuration.fastSetValue = true;
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnTheLoginButton();
        dashboardPage.dashboardPageIsOpen();
        dashboardPage.currentUrlIsCorrect();
    }

    @Test
    public void loginWithInvalidDates() {
        Configuration.fastSetValue = true;
        loginPage.enterUserName("Adm");
        loginPage.enterPassword("ad23");
        loginPage.clickOnTheLoginButton();
        loginPage.checkError();

    }

    @Test
    // @Category(Smoke.class) // для того чтобы со смока запустить именно этот тест
    public void forgotYourPasswordLink () {
        loginPage.followTheForgotYourPasswordLink();
        resetPasswordPage.resetPasswordButtonIsDisplayed();
        resetPasswordPage.urlIsCorrect();


    }
}
