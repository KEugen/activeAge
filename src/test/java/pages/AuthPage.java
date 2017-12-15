package pages;

import framework.Helper.AdditionalMethods;
import framework.Helper.User;
import framework.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AuthPage extends AbstractPage {

    AdditionalMethods methods = new AdditionalMethods();

    private static String URL_MATCH = "/main?authDialog=login";

//    private By userMail = By.xpath("//div[contains(@class, 'b-auth-login__email')]//input");
//    private By userPassword = By.xpath("//div[contains(@class, 'b-auth-login__password')]//input");
//    private By rememberMeCheckbox = By.xpath("c");
//    private By loginButtnon = By.xpath("//div[contains(@class,'b-auth-login__enter')]");

    /**
     *  Поле ввода почты
     */
    @FindBy(xpath = "//div[contains(@class, 'b-auth-login__email')]//input")
    private WebElement userMail;
    /**
     *  Поле ввода пароля
     */
    @FindBy(xpath = "//div[contains(@class, 'b-auth-login__password')]//input")
    private WebElement userPassword;
    /**
     * Чекбокс Запомнить
     */
    @FindBy(xpath = "//div[contains(@class, 'b-auth-login__password')]//input")
    private WebElement rememberMeCheckbox;
    /**
     * Кнопка Войти
     */
    @FindBy(xpath = "//div[contains(@class,'b-auth-login__enter')]")
    private WebElement loginButton;

    /**
     * Сообщение об ошибке
     */
    @FindBy(xpath = "//div[@class='b-auth-login__error']")
    private WebElement errorMessage;


    public AuthPage(WebDriver driver) {
        super(driver);
        // проверяем, что находимся на странице авторизации
        if(!driver.getCurrentUrl().contains(URL_MATCH)) {
            throw new IllegalStateException(
              "This is not auth page"
            );
        }
    }

    /**
     * Авторизация пользователя
     */
    private void authorizationUser(User user) {
        userMail.sendKeys(user.email);
        userPassword.sendKeys(user.pass);
        rememberMeCheckbox.click();
        loginButton.click();
        loginButton.click(); // добавил потому что на qa херово работает
    }

    /**
     * Очистить поля почты и пароля
     */
    public AuthPage clearEdits() {
        userMail.clear();
        userPassword.clear();
        return this;
    }

    /**
     * Успешная авторизация
     */
    public MainPage authUserSuccess(User user) {
        authorizationUser(user);
        return new MainPage(driver);
    }

    /**
     * Неуспешная авторизация
     */
    public AuthPage authUserFail(User user) {
        authorizationUser(user);
        return new AuthPage(driver);
    }

    /**
     * Проверка сообщения об ошибке
     */
    public AuthPage checkErrorMessage(String expectedMessage) {
        Assert.assertTrue(errorMessage.isDisplayed(), "Сообщение об ошибке не выводится");
        Assert.assertTrue(errorMessage.getText().contains(expectedMessage), "Сообщение об ошибке дожно содержать" + expectedMessage);
        return this;
    }


}
