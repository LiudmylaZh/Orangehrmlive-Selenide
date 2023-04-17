import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class AdminPage {

    private SelenideElement addAdminButton = $(byText("Add"));
    private ElementsCollection dropdownElements = $$(byClassName("oxd-select-wrapper"));
    private SelenideElement dropdownSelectUserRole = dropdownElements.get(0);
    private SelenideElement dropdownSelectStatus = dropdownElements.get(1);

    private ElementsCollection inputPasswordFields = $$(byAttribute("type", "password"));
    private SelenideElement enterPassword = dropdownElements.get(0);
    private SelenideElement enterConfirmPassword = dropdownElements.get(1);
    private SelenideElement enterEmployeeNameField = $(byAttribute("placeholder", "Type for hints..."));
    private SelenideElement enterUserNameField = $(byAttribute("autocomplete", "off"));


    private SelenideElement inputPasswordField = $(byAttribute("type", "password"));
    private SelenideElement dropdownNameEmployee = $(byClassName("oxd-autocomplete-text-input--after"));
    private SelenideElement saveButton = $(byAttribute("type", "submit"));

    private ElementsCollection createdUsers = $$(byAttribute("role=", "row"));
    private ElementsCollection requiredFieldErrorMessages = $$(byCssSelector("[class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]"));
    public void openCreatAdminCard() {
        addAdminButton.click();
    }

    public void selectUserRole() {
        dropdownSelectUserRole.click();
        dropdownSelectUserRole.val("AdminPage");
        dropdownSelectUserRole.shouldBe(visible, Duration.ofSeconds(10));


    }

    public void selectUserStatus() {
        dropdownSelectStatus.click();
        dropdownSelectStatus.val("Enable");
        dropdownSelectUserRole.shouldBe(visible, Duration.ofSeconds(5));
    }

    public void enterPasswordInTheInputField(String passwordValue) {
        inputPasswordField.setValue(passwordValue);
    }

    public void enterConfirmPasswordInTheInputField(String confirmPasswordValue) {
        inputPasswordField.setValue(confirmPasswordValue);
    }

    public void enterEmployeeName() {
        enterEmployeeNameField.setValue("Linda Smith");
        //enterEmployeeNameField.shouldBe(visible, Duration.ofSeconds(10));
        sleep(10000);
    }

    public void selectDropdownEmployeeName() {
        dropdownNameEmployee.val("Linda Marry Smith");
        sleep(10000);

    }

    public void enterUserName(String userName) {
        enterUserNameField.setValue(userName);
    }

    public void clickOnTheSaveButton() {
        saveButton.click();
    }

    public void createdUserShouldBeExist() {
        for (SelenideElement users :
                createdUsers) {
            users.shouldBe(partialText("JohnAdmin"));
        }
    }

    public void requiredFieldsErrorMessageAreDisplayed(){
        requiredFieldErrorMessages.filterBy(visible).shouldHave(CollectionCondition.size(6));
        for (SelenideElement elements:
                requiredFieldErrorMessages) {
            elements.shouldHave(text("Required"));

        }
        }
    }

