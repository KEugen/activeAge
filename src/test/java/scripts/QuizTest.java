package scripts;

import framework.Helper.Utils;
import framework.setup.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.QuizPage;

import java.util.ArrayList;

public class QuizTest extends Setup {

    @Test public void quizTest() {

        driver.get(Setup.getUrl());
        Utils.wait(1000);
        MainPage mainPage = new MainPage();

        QuizPage quizPage = mainPage.clickOnGoQuiz();

        //  0 -> 8 -> 15 -> 23 -> 31 -> 38 -> 46 -> 54 -> 62 -> 69 -> 77 -> 85 -> 92 -> тест пройден
        ArrayList<Integer> expectedProgress = new ArrayList<>();
        double k = (100.0 / 13.0);
        int sum = 0;
        for (int i = 0; i < 13; i++) {
            expectedProgress.add((int)(Math.round(i * k)));
            sum += k;
        }

        Assert.assertEquals(expectedProgress.get(0).intValue(), quizPage.getProgress());
        for(int i = 1; i < 13; i ++) {
            quizPage.clickOnAnswer();
            Assert.assertEquals(expectedProgress.get(i).intValue(), quizPage.getProgress());
        }

        quizPage.clickOnAnswer();
        Assert.assertTrue(quizPage.getTestResult().contains("танционер"));

        Utils.wait(1000);
        ArrayList<String> expectedTitle = new ArrayList<>();
        expectedTitle.add("Facebook");
        expectedTitle.add("ВКонтакте | Вход");
        expectedTitle.add("Поделиться ссылкой в Твиттере");
        expectedTitle.add("Одноклассники");
        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(quizPage.clickOnShareButtons(i), expectedTitle.get(i));
        }

        quizPage.clickButtonRead();
        Assert.assertEquals(getDriver().getTitle(), "Главная - Активный возраст");
    }
}
