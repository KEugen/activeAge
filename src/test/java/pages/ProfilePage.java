package pages;

import framework.Helper.Utils;
import framework.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProfilePage extends AbstractPage {

    private static String URL_MATCH = "/profile";

    public ProfilePage() {
        super();
        isCorrectPage(URL_MATCH);
    }

    @FindBy(xpath = "//span[@class='b-profile-data__email-value']")
    private WebElement email;
    @FindBy(xpath = "//div[text()='Женский']")
    private WebElement femaleButton;
    @FindBy(xpath = "//div[text()='Мужской']")
    private WebElement maleButton;
    @FindBy(xpath = "//div[contains(@class,'female-button_active') and //div[text()='Женский']]")
    private WebElement activeFemaleButton;
    @FindBy(xpath = "//div[contains(@class,'male-button_active') and //div[text()='Мужской']]")
    private WebElement activeMaleButton;
    @FindBy(xpath = "//span[text()='Сохранить']")
    private WebElement saveButton;
    @FindBy(xpath = "//div[text()='Изменения сохранены']")
    private WebElement changesMessage;

    public String getUserEmail() {
        return email.getText();
    }

    public ProfilePage clickMaleButton() {
        maleButton.click();
        return this;
    }

    public ProfilePage clickFemaleButton() {
        femaleButton.click();
        return this;
    }

    public ProfilePage isMaleActive() {
        Assert.assertTrue(Utils.elementIsDisplayed(activeMaleButton), "deactive male button");
        return this;
    }

    public ProfilePage isFemaleActive() {
        Assert.assertTrue(Utils.elementIsDisplayed(activeFemaleButton), "deactive female button");
        return this;
    }

    public ProfilePage saveChanges() {
        saveButton.click();
        Utils.wait(500);
        Assert.assertTrue(Utils.elementIsDisplayed(changesMessage), "не выводится сообщение о внесенных изменениях");
        return this;
    }

}
