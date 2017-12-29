package admin.pages;

import admin.scripts.CreateArticleTest;
import framework.Helper.Article;
import framework.Helper.Utils;
import framework.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CreateArticlePage extends AbstractPage {

    public CreateArticlePage() {
        super();
        isCorrectPage("http://admin.activeage1.qa.lan/journal/article/create");
    }


    /* input for image*/
    @FindBy(xpath = "//input[@class = 'b-ap-input__file']")
    private List<WebElement> inputImg;

    /* title */
    @FindBy(xpath = "//input[@name = 'title']")
    private WebElement titleInput;

    /* author */
    @FindBy(xpath = "//input[@placeholder = 'author']")
    private WebElement authorInput;

    /* person */
    @FindBy(xpath = "//input[@name = 'person']")
    private WebElement personInput;

    /* author */
    @FindBy(xpath = "//textarea[@name = 'lead']")
    private WebElement leadInput;

    /* Дропдаун Позиции
    * [0] - Не выбрано
    * [1] - 1
    * [2] - 2
    * [3] - 3
    * [4] - 4
    * */
    @FindBy(xpath = "//label[text()='Позиция']//parent::div")
    private WebElement positionDropdown;
    @FindBy(xpath = "//label[text()='Позиция']//parent::div//li")
    private List<WebElement> positionDropdownElement;

    /* Дропдаун Рубрики
    * [0] - Советы
    * [1] - Полезное
    * [2] - Интересное
    * [3] - Новости
    * [4] - ...
    * */
    @FindBy(xpath = "//label[text()='Рубрика']//parent::div")
    private WebElement rubricksDropdown;
    @FindBy(xpath = "//label[text()='Рубрика']//parent::div//li")
    private List<WebElement> rubricksDropdownElement;

    /* Дропдаун Тип карточки
    * [0] - 25
    * [1] - 100
    * [2] - 200
    * */
    @FindBy(xpath = "//label[text()='Тип карточки']//parent::div")
    private WebElement cardTypeDropdown;
    @FindBy(xpath = "//label[text()='Тип карточки']//parent::div//li")
    private List<WebElement> cardTypeDropdownElement;

    /* СОЗДАТЬ */
    @FindBy(xpath = "//button[text()='Создать']")
    private WebElement createButton;

    // * * *  E R R O R S    L O C A T O R S * * * //
    /* Лист всех ошибок */
        @FindBy(xpath = "//div[@class= 'b-ap-input__error-message']")
    private List<WebElement> listOfErrors;



    ////////////////////////////

    public CreateArticlePage sendImgPath() {
        Article article = new Article();
        inputImg.get(1).sendKeys(article.leadImg);
        return this;
    }

    public CreateArticlePage sendsInputFields(Article article) {
        titleInput.sendKeys(article.getTitle());
        authorInput.sendKeys(article.getAutor());
        leadInput.sendKeys(article.getLead());
        personInput.sendKeys(article.getPerson());
        return this;
    }

    public CreateArticlePage failCreate() {
        createButton.click();
        return this;
    }

    public List<String> getListOfErrors() {
        List<String> list = new ArrayList<>();
        for (WebElement element:listOfErrors) {
            list.add(element.getText());
        }
        return list;
    }

    public CreateArticlePage changeCardType(int type) {
        cardTypeDropdown.click();
        Utils.wait(500);
        cardTypeDropdownElement.get(type).click();
        return this;
    }

}
