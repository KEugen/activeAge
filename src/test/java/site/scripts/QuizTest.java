package site.scripts;

import site.pages.InnerHeader;
import framework.Helper.Utils;
import framework.setup.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;
import site.pages.MainPage;
import site.pages.QuizPage;

import java.util.ArrayList;

public class QuizTest extends Setup {

    ArrayList<Integer> expectedProgress = new ArrayList<>();
    ArrayList<Integer> expectedProgressCount = new ArrayList<>();
    ArrayList<String> expectedTitle = new ArrayList<>();

    @Test public void quizTest() {

        driver.get(Setup.getUrl());
        Utils.wait(1000);
        MainPage mainPage = new MainPage();

        QuizPage quizPage = mainPage.clickOnGoQuiz();
        setExpectedResults();

        Assert.assertEquals(expectedProgress.get(0).intValue(), quizPage.getProgress());
        for(int i = 1; i < 13; i ++) {
            quizPage.clickOnAnswer();
            Assert.assertEquals(expectedProgress.get(i).intValue(), quizPage.getProgress());
            Assert.assertEquals(expectedProgressCount.get(i).intValue(), quizPage.getProgressCount());
        }
        quizPage.clickOnAnswer();
        Assert.assertTrue(quizPage.getTestResult().contains("танционер"));

        Utils.wait(1000);
        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(quizPage.clickOnShareButtons(i), expectedTitle.get(i));
        }

        InnerHeader innerHeader = new InnerHeader();
        innerHeader.clickOnItemOnHeader(0);
        Utils.wait(1000);

        Assert.assertEquals(getDriver().getTitle(), "Главная - Активный возраст");
        Assert.assertEquals(mainPage.getQuizButtonText(), "ЕЩЕ РАЗ");
    }

    private void setExpectedResults() {
        //  0 -> 8 -> 15 -> 23 -> 31 -> 38 -> 46 -> 54 -> 62 -> 69 -> 77 -> 85 -> 92 -> тест пройден
        double k = (100.0 / 13.0);
        int sum = 0;
        for (int i = 0; i < 13; i++) {
            expectedProgressCount.add(i + 1);
            expectedProgress.add((int)(Math.round(i * k)));
            sum += k;
        }

        expectedTitle.add("Facebook");
        expectedTitle.add("ВКонтакте | Вход");
        expectedTitle.add("Поделиться ссылкой в Твиттере");
        expectedTitle.add("Одноклассники");
    }
}
