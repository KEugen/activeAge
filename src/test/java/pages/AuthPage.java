package pages;

import framework.Helper.Utils;
import framework.Helper.User;
import framework.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthPage extends AbstractPage {

    private static String URL_MATCH = "/main?authDialog=login";

    public AuthPage() {
        super();
        // проверяем, что находимся на странице авторизации
        isCorrectPage(URL_MATCH);
    }
//    private By userMail = By.xpath("//div[contains(@class, 'b-auth-login__email')]//input");
//    private By userPassword = By.xpath("//div[contains(@class, 'b-auth-login__password')]//input");
//    private By rememberMeCheckbox = By.xpath("c");
//    private By loginButtnon = By.xpath("//div[contains(@class,'b-auth-login__enter')]");

    /* Поле ввода почты AUTH */
    @FindBy(xpath = "//div[contains(@class, 'b-auth-login__email')]//input")
    private WebElement userMail;

    /* Поле ввода почты REGISTRATION */
    @FindBy(xpath = "//div[contains(@class, 'registration__email-step')]//input")
    private WebElement newUserMail;
    /* Поле ввода пароля */
    @FindBy(xpath = "//div[contains(@class, 'b-auth-login__password')]//input")
    private WebElement userPassword;
    /* Чекбокс Запомнить */
    @FindBy(xpath = "//div[contains(@class, 'b-auth-login__password')]//input")
    private WebElement rememberMeCheckbox;
    /* Кнопка Войти */
    @FindBy(xpath = "//div[contains(@class,'b-auth-login__enter')]")
    private WebElement loginButton;

    /* Сообщение об ошибке AUTH */
    @FindBy(xpath = "//div[@class='b-auth-login__error']")
    private WebElement errorMessageAuth;

    /* Сообщение об ошибке REG */
    @FindBy(xpath = "//div[@class='b-auth-registration__error']")
    private WebElement errorMessageReg;

    /* Таб Новый участник */
    @FindBy(xpath = "//span[text()='Новый участник']")
    private WebElement newUserTab;

    /* Кнопка Вступить в клуб */
    @FindBy(xpath = "//span[text()='Вступить в клуб']")
    private WebElement newUserButton;

    @FindBy(xpath = "//div[contains(@class,'input-password')]//div[contains(@class,'input_age_password')]//input")
    private WebElement setPassword;

    @FindBy(xpath = "//div[contains(@class,'confirm-password')]//div[contains(@class,'input_age_password')]//input")
    private WebElement confirmPassword;

    /* Условия Публичной оферты */
    @FindBy(xpath = "//span[@class='b-auth-registration__offer-text']")
    private WebElement offerText;

    /* Кнопка назад на странице оффера */
    @FindBy(xpath = "//div[contains(@class,'back-to-auth')]")
    private WebElement backButtonOnOffer;

    /* У меня нет такой карты */
    @FindBy(xpath = "//a[contains(@class,'no-card')]")
    private WebElement noCardButton;

    /* Закрыть (крестик) на попапе с картой */
    @FindBy(xpath = "//div[contains(@class, 'b-auth')]//div[contains(@class,'close g-icon')]")
    private WebElement closeCardPopup;

    // / / / / / /
    // М Е Т О Д Ы
    // / / / / / / / / /

    /* Авторизация пользователя */
    private void authorizationUser(User user) {
        userMail.sendKeys(user.email);
        userPassword.sendKeys(user.pass);
        rememberMeCheckbox.click();
        loginButton.click();
        loginButton.click(); // добавил потому что на qa херово работает
    }

    /* Регистрация пользователя */
    private void registrationUser(User user) {
        newUserMail.sendKeys(user.email);
        newUserButton.click();
    }

    /* Переход на Таб регистрации */
    public AuthPage goOnRegistrationTab() {
        newUserTab.click();
        return this;
    }

    /* Проверка пользовательского соглашения */
    public String checkOfferText() {
        offerText.click();
        String Url = getDriver().getCurrentUrl();
        backButtonOnOffer.click();
        return Url;
    }

    /* Очистить поля почты и пароля а странице авторизации */
    public AuthPage clearEdits() {
        userMail.clear();
        userPassword.clear();
        return this;
    }

    /* Очистить поле почты на странице регистрации */
    public AuthPage clearEmailEdit() {
        newUserMail.clear();
        return this;
    }

    /* Очистить поля пароля и подтверждения пароля */
    public AuthPage clearPasswordEdits() {
        setPassword.clear();
        confirmPassword.clear();
        return this;
    }

    /* УСПЕШНАЯ авторизация */
    public MainPage authUserSuccess(User user) {
        authorizationUser(user);
        return new MainPage();
    }

    /* НЕУСПЕШНАЯ авторизация */
    public AuthPage authUserFail(User user) {
        authorizationUser(user);
        return this;
    }

    /* Проверка сообщения об ошибке на странице авторизации */
    public String getAuthErrorMessage() {
        return errorMessageAuth.getText();
    }

    /* Проверка сообщения об ошибке на странице авторизации */
    public String getRegErrorMessage() {
        return errorMessageReg.getText();
    }

    /* Успешная регистраниця  /// сделать чтоб возвращался JournalPage */
    public void regUserSuccess(User user) {
        registrationUser(user);
    }

    /* Неуспешная регистрация */
    public void regUserFail(User user) {
        registrationUser(user);
        Utils.wait(1000);
    }

    /* УСПЕШНАЯ Установка Пароля */
    public MainPage setupPasswordSuccess(User user) {
        if (!(setPassword.getAttribute("value").length() == 0)) {
            clearPasswordEdits();
        }
        setPassword.sendKeys(user.pass);
        confirmPassword.sendKeys(user.confirmPass);
        newUserButton.click();
        noCardButton.click();
        closeCardPopup.click();
        return new MainPage();
    }

    /* НЕУСПЕШНАЯ Установка Пароля */
    public AuthPage setupPasswordFail(User user) {
        if (!(setPassword.getAttribute("value").length() == 0)) {
            clearPasswordEdits();
        }
        setPassword.sendKeys(user.pass);
        confirmPassword.sendKeys(user.confirmPass);
        newUserButton.click();
        return this;
    }
}
