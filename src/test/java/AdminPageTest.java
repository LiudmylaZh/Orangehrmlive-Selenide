import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminPageTest extends BaseTest {


    @Test
    public void  checkCreatedNewAdmin (){
        Configuration.fastSetValue = true;
        loginPage.successLogin("AdminPage", "admin123");
        sideBar.clickOnAdminButtonInSidebar();
        adminPage.openCreatAdminCard();
        adminPage.selectUserRole();
        adminPage.selectUserStatus();
        adminPage.enterPasswordInTheInputField("12345QWerty!");
        adminPage.enterConfirmPasswordInTheInputField("12345QWerty!");
        adminPage.enterEmployeeName();
        adminPage.selectDropdownEmployeeName();
        adminPage.enterUserName("JohnAdmin");
        adminPage.clickOnTheSaveButton();
        adminPage.createdUserShouldBeExist();

    }
    @Category(Smoke.class)
    @Test
    public void errorMassageIsExist (){
        loginPage.successLogin ("Admin", "admin123");
        sideBar.clickOnAdminButtonInSidebar();
        adminPage.openCreatAdminCard();
        adminPage.clickOnTheSaveButton();
        adminPage.requiredFieldsErrorMessageAreDisplayed();





    }
}
