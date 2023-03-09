import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertTrue;

public class SideBar {
    private SelenideElement sideBar = $(byClassName("oxd-navbar-nav"));
    private SelenideElement searchInput = $(byAttribute("placeholder", "Search"));
    private SelenideElement linkOnAdmin = $(byClassName("oxd-main-menu-item"));
    private SelenideElement linkOnPim = $(byAttribute("href", "/web/index.php/pim/viewPimModule"));
    private SelenideElement linkOnLeave = $(byAttribute("href", "/web/index.php/leave/viewLeaveModule"));
    private SelenideElement linkOnTime = $(byAttribute("href", "/web/index.php/time/viewTimeModule"));
    private SelenideElement buttonRecruitment = $(byAttribute("href", "/web/index.php/recruitment/viewRecruitmentModule"));
    private SelenideElement linkOnMyInfo = $(byAttribute("href", "/web/index.php/pim/viewMyDetails"));
    private SelenideElement switchSidebar = $(byAttribute("type", "button"));
    private SelenideElement rolledSidebar = $(byClassName("oxd-sidepanel"));
    private ElementsCollection sideBarButtons = $$(byClassName("oxd-main-menu-item-wrapper"));
    private SelenideElement buttonDirectory = $(byAttribute("href", "/web/index.php/directory/viewDirectory"));


    public void sideBarIsVisible() {
        sideBar.shouldBe(visible);
    }

    public void searchInputIsDisplayed() {

    }

    public void attributeShouldExist() {
        linkOnAdmin.shouldHave(attribute("href"));
    }

    public void sideBarItemsAreVisible() {
        searchInput.shouldBe(visible);
        linkOnAdmin.shouldBe(visible);
        linkOnPim.shouldBe(visible);
        linkOnLeave.shouldBe(visible);
        linkOnTime.shouldBe(visible);
    }

    public void linkOnAdminIsValid() {
        linkOnAdmin.click();
        String adminUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertTrue(adminUrl.contains("admin/viewSystemUsers"));

    }

    public void linkOnPimIsValid() {
        linkOnPim.click();
        String pimUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertTrue(pimUrl.contains("pim/viewEmployeeList"));
    }

    public void linkOnLeaveIsValid() {
        linkOnLeave.click();
        String pimUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertTrue(pimUrl.contains("viewLeaveList"));
    }

    public void linkOnTimeIsValid() {
        linkOnTime.click();
        String timeUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertTrue(timeUrl.contains("viewEmployeeTimesheet"));
    }

    public void clickOnRecruitmentButton() {
        buttonRecruitment.click();
    }


    public void linkOnMyInfoIsValid() {
        linkOnMyInfo.click();
        String timeUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertTrue(timeUrl.contains("viewPersonalDetails/empNumber/7"));

    }

    public void clickOnSwitchSideBar() {
        switchSidebar.click();

    }

    public void checkSideBarRolled() {
        rolledSidebar.shouldHave(Condition.attributeMatching("class", ".*toggled.*"));

    }

    public void enterValueToSearch(String searchValue) {
        searchInput.setValue(searchValue);
    }


    public void buttonHasExpectedText(String expectedText) {
        linkOnTime.shouldHave(text(expectedText));

    }

    public void oneButtonIsDisplayed(String expectedText) {
        sideBarButtons.filter(visible).shouldHave(size(1));
        linkOnTime.shouldHave(text(expectedText));
    }

    public void enterInvalidValueToSearch(String searchInvalidValue) {
        searchInput.setValue(searchInvalidValue);
    }

    public void sideBarButtonsShouldBeEmpty() {
        sideBarButtons.shouldHave(size(0));
    }

    public void enterPartText(String searchPartText) {
        searchInput.setValue(searchPartText);
    }

    public void searchByPartTextIsValid() {
        sideBarButtons.shouldHave(size(2));
        buttonDirectory.shouldBe(visible);
        buttonRecruitment.shouldBe(visible);
    }

    public void buttonRecruitmentShouldHavePartText(String searchPartText) {
        buttonRecruitment.shouldHave(partialText(searchPartText));
    }

    public void buttonDirectoryShouldHavePartText(String searchPartText) {
        buttonDirectory.shouldHave(partialText(searchPartText));
    }

    public void eachCollectionElementHasPartTime(String expectedText) {
        for (SelenideElement button :
                sideBarButtons) {
            button.shouldHave(partialText(expectedText));

        }
    }
}
