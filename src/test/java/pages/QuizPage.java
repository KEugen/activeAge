package pages;

import framework.Helper.Utils;
import framework.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class QuizPage extends AbstractPage {

    private static String URL_MATCH = "quiz/";

    /* Прогресс бар */
    @FindBy(xpath = "//div[contains(@class,'bar__lane')]/div")
    private WebElement progressBar;

    /* Чекбокс варианта Ответа (всегда первый вариант) */
    @FindBy(xpath = "//div[@class ='g-checkbox-group__checkbox'][1]")
    private WebElement answer;

    /* Результат теста */
    @FindBy(xpath = "//div[contains(@class,'type_pensioner-type')]")
    private WebElement resultTest;

    /* Кнопки Шеринга после результата теста  (4 штуки) */
    @FindBy(xpath = "//div[@class='i-control g-share g-share_age g-share_icons-theme']//a")
    private List<WebElement> shareButtons;

    /* Кнопка Пройти тест еще раз */
    @FindBy(xpath = "//div[contains(@class,'test-again')]")
    private WebElement goTestAgain;

    /* Кнопка Перейти */
    @FindBy(xpath = "//span[text()='Перейти']")
    private WebElement buttonRead;

    public QuizPage() {
        super();
        isCorrectPage(URL_MATCH);
    }

    public int getProgress() {
        String progress = progressBar.getAttribute("style").replaceAll("[^0-9]", "");
        return Integer.parseInt(progress);
    }

    public void clickOnAnswer() {
        answer.click();
    }

    public String getTestResult() {
        return resultTest.getText();
    }

    public String clickOnShareButtons(int num) {
        return Utils.openNewTabAndGetTitle(num, shareButtons);
    }

    public QuizPage cliclGoTestAgain() {
        goTestAgain.click();
        return this;
    }

    public MainPage clickButtonRead() {
        buttonRead.click();
        return new MainPage();
    }
}
