package site.pages;

import framework.Helper.Utils;
import framework.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class Footer extends AbstractPage{

    @FindBy(xpath = "//div[@class='b-footer__logo']/a")
    private WebElement logoInFuter;

    @FindBy(xpath = "//div[@class='b-footer__socials']//div[contains(@class,'b-footer__fb')]")
    private WebElement fbButtonInFuter;

    @FindBy(xpath = "//div[@class='b-footer__socials']//div[contains(@class,'b-footer__vk')]")
    private WebElement vkButtonInFuter;

    @FindBy(xpath = "//div[@class='b-footer__socials']//div[contains(@class,'b-footer__ok')]")
    private WebElement okButtonInFuter;

    ArrayList<WebElement> listOfButtonsOpensInNewTab = new ArrayList<>();

    public Footer() {
        super();
        setLists();
    }


    private void setLists() {
        listOfButtonsOpensInNewTab.add(logoInFuter);
        listOfButtonsOpensInNewTab.add(fbButtonInFuter);
        listOfButtonsOpensInNewTab.add(vkButtonInFuter);
        listOfButtonsOpensInNewTab.add(okButtonInFuter);
    }

    public String clickOnButtonOpenInNewTab(int num) {
       return Utils.openNewTabAndGetUrl(num, listOfButtonsOpensInNewTab);
    }

}
