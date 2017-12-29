package site.pages;

import framework.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InnerHeader extends AbstractPage{

    public InnerHeader() {
        super();
    }

    @FindBy(xpath = "//div[contains(@class,'b-header__inner-desktop')]/a")
    private List<WebElement> innerHeaderItems;

    /* Блок иннер хедера
       1 - Лого [0]
       3 - Журнал [2]
       4 - Финансы [3]
       5 - Выгоды [4]
       6 - Курсы [5]
       7 - Здоровье [6]
     */
    public AbstractPage clickOnItemOnHeader(int item) {
        innerHeaderItems.get(item).click();
        switch(item) {
            case 0:
                return new MainPage();
            case 3:
                return new FinancesPage();
            default:
                return new MainPage();
        }
    }



}
