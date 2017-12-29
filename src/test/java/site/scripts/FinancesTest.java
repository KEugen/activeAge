package site.scripts;

import framework.Helper.Utils;
import framework.setup.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;
import site.pages.FinancesPage;
import site.pages.MainPage;

import java.util.ArrayList;

public class FinancesTest extends Setup {

    @Test
    public void financesTest() {

        driver.get(Setup.getUrl());
        Utils.wait(1000);
        MainPage mainPage = new MainPage();
        FinancesPage financesPage = mainPage.clickOnFinancesTab();

        for (int i = 0; i < financesPage.getOrderButtonsSize(); i++) {
            Assert.assertEquals(financesPage.clickAndOpenNewTab(i), "https://www.sberbank.ru/ru/person/bank_cards/debet/social/mir#debet-out");
        }

        ArrayList<String> expectedUrls = new ArrayList<String>();
        expectedUrls.add("https://www.sberbank.ru/ru/person/contributions/deposits/save");
        expectedUrls.add("https://www.sberbank.ru/ru/person/contributions/deposits/save_online");
        expectedUrls.add("https://www.sberbank.ru/ru/person/bank_cards/debet/social/mir");
        expectedUrls.add("https://online.sberbank.ru/CSAFront/index.do");
        expectedUrls.add("https://ipoteka.domclick.ru/?prod=4&term=7&devdisc=true&elreg=true&#calc_");
        expectedUrls.add("https://www.sberbank.ru/ru/person/investments/securities/certificates");
        expectedUrls.add("http://www.sberbank.ru/ru/person");
        expectedUrls.add("https://spasibosberbank.ru/");
        expectedUrls.add("http://www.sberbank.ru/ru/person/pensioner/get");
        expectedUrls.add("https://www.facebook.com/sberbank/");
        expectedUrls.add("https://vk.com/sberbank");
        expectedUrls.add("https://ok.ru/sberbank");

        financesPage.getListOnSaveTab();
        for (int i = 0; i < expectedUrls.size(); i++) {
            Assert.assertEquals(financesPage.clickOtherLinksInTab(i, "save"), expectedUrls.get(i));
            i++;
        }

        financesPage.clickOnTab("add");
        financesPage.getListOnAddTab();

        ArrayList<String> expectedAddUrls = new ArrayList<String>();
        expectedAddUrls.add("https://www.sberbank.ru/ru/person/contributions/deposits/renew_online");
        expectedAddUrls.add("https://www.sberbank.ru/ru/person/contributions/deposits/renew");

        for (int i = 0; i< expectedAddUrls.size(); i++) {
            Assert.assertEquals(financesPage.clickOtherLinksInTab(i, "add"), expectedAddUrls.get(i));
            i++;
        }
    }
}
