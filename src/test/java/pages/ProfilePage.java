package pages;

import framework.Helper.AdditionalMethods;
import framework.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProfilePage extends AbstractPage {
    private static String URL_MATCH = "/profile";

    public ProfilePage(WebDriver driver) {
        super(driver);
        if(!driver.getCurrentUrl().contains(URL_MATCH)) {
            throw new IllegalStateException(
                    "This is not profile page"
            );
        }
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
        Assert.assertTrue(AdditionalMethods.elementIsDisplayed(activeMaleButton), "deactive male button");
        return this;
    }

    public ProfilePage isFemaleActive() {
        Assert.assertTrue(AdditionalMethods.elementIsDisplayed(activeFemaleButton), "deactive female button");
        return this;
    }

    public ProfilePage saveChanges() {
        saveButton.click();
        AdditionalMethods.wait(500);
        Assert.assertTrue(AdditionalMethods.elementIsDisplayed(changesMessage), "не выводится сообщение о внесенных изменениях");
        return this;
    }

}
