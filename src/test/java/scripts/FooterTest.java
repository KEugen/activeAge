package scripts;

import framework.Helper.Utils;
import framework.setup.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FeedbackPage;
import pages.MainPage;


public class FooterTest extends Setup {

    @Test
    public void feedbackTest() {

        driver.get(Setup.getUrl());
        Utils.wait(5000);
        MainPage mainPage = new MainPage();
        FeedbackPage feedbackPage = mainPage.clickOnFeedbackButton();

        feedbackPage.clickOnCloseButton();
    }

    @Test
    public void aboutUsTest() {
        driver.get(Setup.getUrl());
        Utils.wait(5000);
        MainPage mainPage = new MainPage();

        Assert.assertTrue(mainPage.checkAboutPage());
    }
}
