import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement userNameField = $(byName("username"));
    private SelenideElement passwordField = $(byName("password"));
    private SelenideElement loginButton = $(byAttribute("type", "submit"));

    private SelenideElement invalidDate = $(byCssSelector("[class=\"oxd-text oxd-text--p oxd-alert-content-text\"]"));
    private SelenideElement topLogo = $(byAttribute("alt", "company-branding"));
    private SelenideElement credSection = $(byClassName("orangehrm-login-error"));
    private SelenideElement forgotYourPassword = $(byClassName("orangehrm-login-forgot-header"));

    public void enterUserName(String userNameValue) {
        userNameField.shouldBe(visible, Duration.ofSeconds(15));
        userNameField.setValue(userNameValue);
    }
    public void enterPassword (String passwordValue) {
    passwordField.setValue(passwordValue);
}

public void clickOnTheLoginButton (){
    loginButton.click();
}
    public void checkError() {
        invalidDate.shouldBe(Condition.text("Invalid credentials"));
    }

    public void logoIsDisplayed() {
        topLogo.shouldBe(visible);
    }


    public void credSectionIsDisplayed() {
        credSection.shouldBe(Condition.text("Admin"));
    }

    public void logoImageIsCorrect() {
        //topLogo.shouldHave(attribute("src", "https://opensource-demo.orangehrmlive.com/web/images/ohrm_branding.png?1672659722816"));
        topLogo.shouldHave(attribute("src"));
        //topLogo.shouldHave(attributeMatching("src", ".*branding.png.*"));
    }

    public void followTheForgotYourPasswordLink () {
        forgotYourPassword.click();

    }

    public void successLogin (String userNameValue, String passwordValue) {
        enterUserName(userNameValue);
        enterPassword(passwordValue);
        clickOnTheLoginButton();
    }
}

