package admin.pages;

import framework.Helper.Utils;
import framework.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ArticlesPage extends AbstractPage {

    public ArticlesPage() {
        super();
        isCorrectPage("http://admin.activeage1.qa.lan/journal/article");
    }

    // * * * L O C T O R S * * * //
    /* Кнопка Добавить */
    @FindBy(xpath = "//a[@class='waves-effect waves-light btn light-green btn-floating btn-large']")
    private WebElement addArticleButton;

    /* Дропдаун "Показывать по" */
    @FindBy(xpath = "//div[@class='select-wrapper']")
    private WebElement showDropdown;

    /* Элементы дропдауна */
    @FindBy(xpath = "//ul[contains(@class, 'select-dropdown')]//li")
    private List<WebElement > elementsOfDropdown;

    /* Таблица - Шапка */
    @FindBy(xpath = "//table//thead")
    private WebElement tableHead;

    /* Таблица - Фильтр */
    @FindBy(xpath = "//table//tfoot")
    private WebElement tableFoot;

    /* Таблица - Контент */
    @FindBy(xpath = "//table//tbody")
    private List<WebElement> tableBody;

    /* table info */
    @FindBy(xpath = "//div[@class = 'dataTables_info']")
    private WebElement tableInfo;

    /* Disable Previous Button */
    @FindBy(xpath = "//a[@class = 'paginate_button previous disabled']")
    private WebElement disablePreviousButton;

    /* Enabled previous button */
    @FindBy(xpath = "//a[@class = 'paginate_button previous']")
    private WebElement enablePreviousButton;

    /* Панель пагинации
    * 0 - prev
    * 1 -
    *
    * */
    @FindBy(xpath = "//div[@class = 'dataTables_paginate paging_simple_numbers']//descendant::a")
    private List<WebElement> paginationPanel;


    // * * * M E T H O D S * * * //
    public CreateArticlePage clickOnAddArticleButton() {
        addArticleButton.click();
        return new CreateArticlePage();
    }

    public ArticlesPage changeShowsCounter(int count) {
        showDropdown.click();
        Utils.wait(500);
        elementsOfDropdown.get(count).click();
        return this;
    }

    public String getTableInfo() {
        String str = tableInfo.getText().replaceAll("[^0-9]", "");
        String substr = str.substring(1, str.length());
        return substr.substring(0, substr.length() - 3);
    }

    public int getDropSize() {
        return elementsOfDropdown.size();
    }

}
