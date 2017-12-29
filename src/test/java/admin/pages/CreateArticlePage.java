package admin.pages;

import framework.Helper.Article;
import framework.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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



    public CreateArticlePage sendImgPath() {
        Article article = new Article();
        inputImg.get(1).sendKeys(article.leadImg);
        return this;
    }

    ////////////////////////////

    public CreateArticlePage sendsInputFields(Article article) {
        titleInput.sendKeys(article.getTitle());
        authorInput.sendKeys(article.getAutor());
        leadInput.sendKeys(article.getLead());
        personInput.sendKeys(article.getPerson());
        return this;
    }

}
