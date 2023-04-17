import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DirectoryTest extends BaseTest{

    @Category(Smoke.class)
    @Test
    public void checkCardInfo (){
        loginPage.successLogin("Admin", "admin123");
        sideBar.clickOnDirectoryButton();
        directoryPage.clickOnFirstCard();
        directoryPage.selectedCardShouldBeVisible();
        directoryPage.nameSelectedCardShouldBeVisible();
        directoryPage.avatarSelectedCardShouldBeVisible();
        directoryPage.personalDataShouldHaveText();




    }
}
