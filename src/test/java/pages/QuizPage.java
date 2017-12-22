package pages;

import framework.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuizPage extends AbstractPage {

    private static String URL_MATCH = "quiz/";

    /* Прогресс бар */
    @FindBy(xpath = "//div[contains(@class,'bar__lane')]")
    private WebElement progressBar;

    public QuizPage() {
        super();
        isCorrectPage(URL_MATCH);
    }

    public int getProgress() {

        return 0;
    }


}
