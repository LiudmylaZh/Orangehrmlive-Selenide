import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

public class RecruitmentPage {
    private SelenideElement titleOfRecruitment = $(byClassName("oxd-topbar-header-breadcrumb"));

    public void theTitleRecruitmentIsExist () {
        titleOfRecruitment.shouldHave(text("Recruitment"));
    }

    public void checkLinkOnRecruitment () {
        String timeUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertTrue(timeUrl.contains("recruitment/viewCandidates"));
    }
}
