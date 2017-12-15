package pages;

import framework.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage{

    private static String URL_MATCH = "/main";

    /**
     * Кнопка Войти
     */
    @FindBy(xpath = "//div[@class='b-items-header__login-status']")
    private WebElement loginButton;

    /**
     * Кнопка профиля
     */
    @FindBy(xpath = "//div[@class='b-main-page__items-header']//div[text()='Профиль']")
    private WebElement profileButton;

    public MainPage(WebDriver driver) {
        super(driver);
        if(!driver.getCurrentUrl().contains(URL_MATCH)) {
            throw new IllegalStateException(
                    "This is not main page"
            );
        }
    }

    public ProfilePage clickOnProfile() {
        profileButton.click();
        return new ProfilePage(driver);
    }

    public AuthPage clickOnLogin() {
        loginButton.click();
        return new AuthPage(driver);
    }
}
