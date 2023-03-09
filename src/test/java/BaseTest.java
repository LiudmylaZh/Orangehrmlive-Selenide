import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    public final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";


    @Before
    public void setUp(){
        //Configuration.headless = true; // тесты будут работать в фоновом режиме без открытия браузера, + делает скрины для Аллюра//
        //Configuration.browser = "firefox";
        //Configuration.browser = "safari"; - in settings of Safari to allow using safari
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open(BASE_URL);
    }
    @After
    public void tearDown(){
        closeWebDriver();
    }

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    SideBar sideBar = new SideBar();
    RecruitmentPage recruitmentPage = new RecruitmentPage();
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
}
