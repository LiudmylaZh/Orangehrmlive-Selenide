import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DirectoryPage {

    private ElementsCollection personalCards = $$(byXpath ("//div[@class='orangehrm-corporate-directory']//div[@class='oxd-grid-item oxd-grid-item--gutters']"));
    private SelenideElement selectedCardinRightSideBar = $(byClassName("orangehrm-corporate-directory-sidebar"));
    private ElementsCollection avatarSelectedCard = $$ (byAttribute("src", "/web/index.php/pim/viewPhoto/empNumber/2"));
    private SelenideElement nameSelectedCard = $(byXpath("(//div[@class='orangehrm-corporate-directory-sidebar']//p)[1]"));
    private ElementsCollection personalData = $$(byClassName ("orangehrm-directory-card-body"));
    public void clickOnFirstCard (){
        personalCards.get(0).shouldBe(Condition.visible);
        personalCards.get(0).click();
    }

    public void selectedCardShouldBeVisible (){
        selectedCardinRightSideBar.shouldBe(Condition.visible);
    }
    public void avatarSelectedCardShouldBeVisible (){
        avatarSelectedCard.get(0).shouldBe(Condition.visible);

    }

    public void nameSelectedCardShouldBeVisible (){
        nameSelectedCard.shouldBe(Condition.visible);
    }
    public void personalDataShouldHaveText (){
        personalData.get(14).shouldHave(Condition.text("Administration"));
    }



}
