import org.junit.Test;

public class SidebarTest extends BaseTest{
    @Test
    public void allItemsAreDisplayed () {

        loginPage.successLogin("Admin", "admin123");
        sideBar.sideBarIsVisible ();
        sideBar.attributeShouldExist();
        sideBar.sideBarItemsAreVisible();
        sideBar.linkOnMyInfoIsValid();


    }

    @Test
    public void allLinksInSidebarAreValid () {
        loginPage.successLogin("Admin", "admin123");
        sideBar.linkOnAdminIsValid();
        sideBar.linkOnPimIsValid();
        sideBar.linkOnLeaveIsValid();
        sideBar.linkOnTimeIsValid();
        sideBar.clickOnRecruitmentButton();


    }
    @Test
    public void recruitmentPageIsOpened (){
        loginPage.successLogin("Admin", "admin123");
        sideBar.clickOnRecruitmentButton();
        recruitmentPage.theTitleRecruitmentIsExist();
        recruitmentPage.checkLinkOnRecruitment();
    }

    @Test
    // @Category(Smoke.class)
    public void sideBarRolled(){
        loginPage.successLogin("Admin", "admin123");
        sideBar.clickOnSwitchSideBar();
        sideBar.checkSideBarRolled();

    }
    @Test
    public void searchInputOneValue () {
        String searchValue = "Time";
        loginPage.successLogin ("Admin", "admin123");
        sideBar.enterValueToSearch(searchValue);
        sideBar.oneButtonIsDisplayed(searchValue);
        sideBar.buttonHasExpectedText(searchValue);
    }
    @Test
    public void searchInvalidButton (){
        String searchInvalidValue = "Two";
        loginPage.successLogin ("Admin", "admin123");
        sideBar.enterInvalidValueToSearch(searchInvalidValue);
        sideBar.sideBarButtonsShouldBeEmpty();
    }

    @Test
    public void searchPartText (){
        String searchPartText = "re";
        loginPage.successLogin ("Admin", "admin123");
        sideBar.enterPartText(searchPartText);
        sideBar.searchByPartTextIsValid();
        sideBar.buttonRecruitmentShouldHavePartText(searchPartText);
        sideBar.buttonDirectoryShouldHavePartText(searchPartText);
        sideBar.eachCollectionElementHasPartTime(searchPartText);
    }

}
