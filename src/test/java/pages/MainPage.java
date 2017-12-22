package pages;

import framework.Helper.Utils;
import framework.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage{

    private static String URL_MATCH = "/main";

    /* Кнопка Пройти тест или ЕЩЕ РАЗ */
    @FindBy(xpath = "//a[@class='b-quiz-header__go-button']")
    private WebElement goQuizButton;

    /* Кнопка Войти */
    @FindBy(xpath = "//div[@class='b-items-header__login-status']")
    private WebElement loginButton;

    /*Кнопка профиля */
    @FindBy(xpath = "//div[@class='b-main-page__items-header']//div[text()='Профиль']")
    private WebElement profileButton;

    /* Вкладка Финансы // !!! потом разобраться с тем, как можно работать со всей панелью с разными табами (аля массив) */
    @FindBy(xpath = "//a[contains(@class,'item_opportunities')]/div[contains(@class,'header__item-label')]")
    private WebElement financesTab;

    /* Кнопка Обратной связи */
    @FindBy(xpath = "//span[text()='Обратная связь']")
    private WebElement feedbackButton;

    /* Кнопка О Нас */
    @FindBy(xpath = "//span[@class='b-footer__help']")
    private WebElement aboutButton;

    /* Картинка на странице О Нас */
    @FindBy(xpath = "//div[@class='b-about__image']")
    private WebElement aboutImage;

    public MainPage() {
        super();
        isCorrectPage(URL_MATCH);
    }

    // / / / / / / / /
    // М Е Т О Д Ы     Д Л Я    П Р О Х О Ж Д Е Н И Я     Т Е С Т А
    // / / / / / / / / / / / / / / / / / / / /

    public String getQuizButtonText() {
        return goQuizButton.getText();
    }

    public ProfilePage clickOnProfile() {
        profileButton.click();
        return new ProfilePage();
    }

    public AuthPage clickOnLogin() {
        loginButton.click();
        return new AuthPage();
    }

    public FinancesPage clickOnFinancesTab() {
        financesTab.click();
        return new FinancesPage();
    }


    // / / / / / / / / /
    // Ф У Т Е Р
    // / / / / / / / / / / / /

    public FeedbackPage clickOnFeedbackButton() {
        feedbackButton.click();
        return new FeedbackPage();
    }

    public Boolean checkAboutPage() {
        aboutButton.click();
        Boolean flag = Utils.elementIsDisplayed(aboutImage);
        isCorrectPage("/about-us");

        return flag;
    }
}
