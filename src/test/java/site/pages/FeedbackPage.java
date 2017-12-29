package site.pages;

import framework.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FeedbackPage extends AbstractPage {

    private static String URL_MATCH = "authDialog=feedback-form";

    /*Кнопка закрыть (Крестик)*/
    @FindBy(xpath = "//div[contains(@class,'b-auth__close g-icon_img_ic_close')]")
    private WebElement closeButton;

    /* Сслыка на попап о персональных данных */
    @FindBy(xpath = "//div[@class='b-feedback-form__check-label']")
    private  WebElement personalDataConfirm;

    /* Закрыть попап согласия на обработку данных */
    @FindBy(css = ".i-control.g-icon.g-icon_age.b-auth__close")
    private WebElement closeButtonOnAgreementPopup;

    /* Поле ввода Фамилии */
    @FindBy(xpath = "//div[contains(@class,'last-name-input')]//input")
    private WebElement lastnameInput;

    /* Поле ввода имени */
    @FindBy(xpath = "//div[contains(@class,'first-name-input')]//input")
    private WebElement firstnameInput;

    /* Поле ввода отчества */
    @FindBy(xpath = "//div[contains(@class,'middle-name-input')]//input")
    private WebElement middlenameInput;

    /* Поле ввода почты */
    @FindBy(xpath = "//div[contains(@class,'first-name-input')]//input")
    private WebElement emailInput;

    /* Поле ввода телефона */
    @FindBy(xpath = "//div[contains(@class,'phone-input')]//input")
    private WebElement phoneInput;

    /* Поле ввода сообщения */
    @FindBy(xpath = "//textarea")
    private WebElement messageInput;

    public FeedbackPage() {
        super();
        // проверяем, что находимся на странице Обратной связи
        isCorrectPage(URL_MATCH);
    }

    public void clickOnCloseButton() {
        closeButton.click();
    }

    public void clickPersonalDataConfirm() {
        personalDataConfirm.click();
        isCorrectPage("agreement-rules");
    }

    public void clickOnCloseButtonOnAgreementPopup() {
        closeButtonOnAgreementPopup.click();
    }

    public void fillMessage() {
        messageInput.sendKeys("sdf asdsd sadasdad" +
                "asdasdasda" +
                "asdasd");
    }

}
