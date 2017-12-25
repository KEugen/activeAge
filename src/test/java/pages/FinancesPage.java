package pages;

import framework.Helper.Utils;
import framework.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FinancesPage extends AbstractPage {

    private static String URL_MATCH = "/finances";
//    public LinkInNewTab linkInNewTab;
//
//    public enum LinkInNewTab {
//        SAVE {public void click() {saveButton.click();}},
//        SAVE_ONLINE {public void click() {saveOnlineButton.click();}},
//        MORE_INFO {public void click() {moreInfoButton.click();}},
//        SBERBANK_ONLINE {public void click() {sberbankOnlineLink.click();}},
//        IPOTEKA {public void click() {ipotekaLink.click();}},
//        CERTIFICATES {public void click() {certificatesLink.click();}},
//        SBERBANK {public void click() {sberbankLink.click();}},
//        SPASIBO {public void click() {spasiboLink.click();}},
//        SBERBANK_PENSIONER{public void click() {sberbankPensioneramLink.click();}},
//        FB{public void click() {FBLink.click();}},
//        VK{public void click() {VKLink.click();}},
//        OK{public void click() {OKLink.click();}},
//
//        ADD {public void click() {addButton.click();}},
//        ADD_ONLINE{public void click() {addOnlineButton.click();}};
//
//        public abstract void click();
//    }

    public FinancesPage() {
        super();
        // проверяем, что находимся на странице финансов
        isCorrectPage(URL_MATCH);
    }

    /*Таб Пополняй*/
    @FindBy(xpath = "//div[contains(@class,'g-tabs') and text()='Пополняй']")
    private WebElement addTab;
    /*Таб Сохряняй*/
    @FindBy(xpath = "//div[contains(@class,'g-tabs') and text()='Сохраняй']")
    private WebElement saveTab;
    /*первая Кнопка Заказать карту*/
    @FindBy(xpath = "//a[contains(@class, 'card-order')]//span")
    private WebElement cardOrderButton;
    /*Все 3 кнопки Заказать карту (ведут на одну страницу)*/
    @FindBy(xpath = "//span[text()='Заказать карту']")
    private List<WebElement> cardOrderButtons;
    /*Кнопка Подробнее*/
    @FindBy(xpath = "//span[text()='Подробнее']")
    private static WebElement moreInfoButton;
    /*Сохраняй Онлайн*/
    @FindBy(xpath = "//span[text()='Сохраняй онлайн']")
    private static WebElement saveOnlineButton;
    /*Сохраняй*/
    @FindBy(xpath = "//span[text()='Сохраняй']")
    private static WebElement saveButton;
    /*Пополняй Онлайн*/
    @FindBy(xpath = "//span[text()='Пополняй онлайн']")
    private static WebElement addOnlineButton;
    /*Пополняй*/
    @FindBy(xpath = "//span[text()='Пополняй']")
    private static WebElement addButton;
    /*Сбербанк Онлайн*/
    @FindBy(xpath = "//a[text()='«Сбербанк онлайн»']")
    private static WebElement sberbankOnlineLink;
    /*Ипотека*/
    @FindBy(xpath = "//a[text()='ипотеке']")
    private static WebElement ipotekaLink;
    /*Сертификаты*/
    @FindBy(xpath = "//a[text()='сберегательным сертификатам']")
    private static WebElement certificatesLink;
    /*Сбербанк*/
    @FindBy(xpath = "//a[text()='sberbank.ru']")
    private static WebElement sberbankLink;
    /*Спасибо*/
    @FindBy(xpath = "//a[text()='spasibosberbank.ru']")
    private static WebElement spasiboLink;
    /*Сбербанк Пенсионерам*/
    @FindBy(xpath = "//img[@class='b-footer__logo-image']")
    private static WebElement sberbankPensioneramLink;
    /*FB*/
    @FindBy(xpath = "//div[contains(@class,'fb_around')]")
    private static WebElement FBLink;
    /*VK*/
    @FindBy(xpath = "//div[contains(@class,'vk_around')]")
    private static WebElement VKLink;
    /*OK*/
    @FindBy(xpath = "//div[contains(@class,'ok_around')]")
    private static WebElement OKLink;

    ArrayList<WebElement> listOnSaveTab = new ArrayList<>();
    ArrayList<WebElement> listOnAddTab = new ArrayList<>();
    /**
     *
     * М Е Т О Д Ы
     *
     */

    public int getOrderButtonsSize() {
        return cardOrderButtons.size();
    }

    public void clickOnTab(String tab) {
        if (tab.equalsIgnoreCase("add")) {
            addTab.click();
        }
        else {
            saveTab.click();
        }
    }

    public void getListOnSaveTab() {
        listOnSaveTab.add(saveButton);
        listOnSaveTab.add(saveOnlineButton);
        listOnSaveTab.add(moreInfoButton);
        listOnSaveTab.add(sberbankOnlineLink);
        listOnSaveTab.add(ipotekaLink);
        listOnSaveTab.add(certificatesLink);
        listOnSaveTab.add(sberbankLink);
        listOnSaveTab.add(spasiboLink);
        listOnSaveTab.add(sberbankPensioneramLink);
        listOnSaveTab.add(FBLink);
        listOnSaveTab.add(VKLink);
        listOnSaveTab.add(OKLink);
    }

    public void getListOnAddTab() {
        listOnAddTab.add(addOnlineButton);
        listOnAddTab.add(addButton);
    }

    public String clickOtherLinksInTab(int num, String tab) {
        String url;
        String parentWindowId = getDriver().getWindowHandle();
        final Set<String> oldWindowsSet = getDriver().getWindowHandles();

        if (tab.equalsIgnoreCase("save")) {
            listOnSaveTab.get(num).click();
        }
        else
        {
            listOnAddTab.get(num).click();
        }

        Utils.moveFocusToTheNewWindow(oldWindowsSet);
        url = getDriver().getCurrentUrl();
        getDriver().close();
        getDriver().switchTo().window(parentWindowId);
        return url;
    }

//    public String clickOtherLinks(LinkInNewTab link) {
//        String url;
//        String parentWindowId = driver.getWindowHandle();
//        final Set<String> oldWindowsSet = driver.getWindowHandles();
//
//        link.click();
//
//        Utils.moveFocusToTheNewWindow(oldWindowsSet);
//        url = driver.getCurrentUrl();
//        driver.close();
//        driver.switchTo().window(parentWindowId);
//        return url;
//    }

    public String clickAndOpenNewTab(int num) {
        String url;
        String parentWindowId = getDriver().getWindowHandle();
        final Set<String> oldWindowsSet = getDriver().getWindowHandles();

        cardOrderButtons.get(num).click();

        Utils.moveFocusToTheNewWindow(oldWindowsSet);
        url = getDriver().getCurrentUrl();
        getDriver().close();
        getDriver().switchTo().window(parentWindowId);
        return url;
    }
}
