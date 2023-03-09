import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

public class DashboardPage {

        private SelenideElement sideBar = $(byCssSelector("[role=\"navigation\"]"));

        public void dashboardPageIsOpen (){
            sideBar.shouldBe(visible, Duration.ofSeconds(10));
        }
        public void currentUrlIsCorrect(){
            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            assertTrue(currentUrl.contains("php/dashboard/index"));
            //webdriver().shouldHave(url("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
        }
}
