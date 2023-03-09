import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

public class ResetPasswordPage {
    private SelenideElement resetPasswordButton = $(byAttribute("type", "submit"));

    public void resetPasswordButtonIsDisplayed() {
        resetPasswordButton.shouldBe(Condition.visible);
    }

    public void urlIsCorrect () {
        // WebDriverRunner.getWebDriver().getCurrentUrl();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertTrue(currentUrl.contains("requestPasswordResetCode"));
    }
}
