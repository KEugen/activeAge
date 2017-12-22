package pages;

import framework.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FeedbackPage extends AbstractPage {

    private static String URL_MATCH = "authDialog=feedback-form";

    /*Кнопка закрыть (Крестик)*/
    @FindBy(xpath = "//div[contains(@class,'b-auth__close g-icon_img_ic_close')]")
    private WebElement closeButton;

    public FeedbackPage() {
        super();
        // проверяем, что находимся на странице Обратной связи
        isCorrectPage(URL_MATCH);
    }

    public void clickOnCloseButton() {
        closeButton.click();
    }

}
