package site.scripts;

import site.pages.Footer;
import framework.Helper.Utils;
import framework.setup.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;
import site.pages.FeedbackPage;
import site.pages.MainPage;

import java.util.ArrayList;
import java.util.List;


public class FooterTest extends Setup {

    @Test
    public void feedbackTest() {

        driver.get(Setup.getUrl());
        Utils.wait(5000);
        MainPage mainPage = new MainPage();
        FeedbackPage feedbackPage = mainPage.clickOnFeedbackButton();

        feedbackPage.clickPersonalDataConfirm();
        feedbackPage.clickOnCloseButtonOnAgreementPopup();
        feedbackPage.fillMessage();

        feedbackPage.clickOnCloseButton();
    }

    @Test
    public void aboutUsTest() {
        driver.get(Setup.getUrl());
        Utils.wait(5000);
        MainPage mainPage = new MainPage();

        Assert.assertTrue(mainPage.checkAboutPage());
    }

    @Test
    public void linksTest() {
        driver.get(Setup.getUrl());
        Utils.wait(5000);
        Footer footer = new Footer();

        List<String> expectedTitles = new ArrayList<>();
        expectedTitles.add("http://www.sberbank.ru/ru/person/pensioner/get");
        expectedTitles.add("https://www.facebook.com/sberbank/");
        expectedTitles.add("https://vk.com/sberbank");
        expectedTitles.add("https://ok.ru/sberbank");

        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(footer.clickOnButtonOpenInNewTab(i), expectedTitles.get(i));
        }
    }
}
