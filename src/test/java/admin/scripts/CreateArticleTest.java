package admin.scripts;

import admin.pages.ArticlesPage;
import admin.pages.CreateArticlePage;
import framework.Helper.Article;
import framework.Helper.Utils;
import framework.setup.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateArticleTest extends Setup {

    @Test
    public void createArticleTest() {

        driver.get(Setup.getAdminUrl());
        Utils.wait(2000);

        ArticlesPage articlesPage = new ArticlesPage();
        System.out.println(articlesPage.getDropSize());
        //CreateArticlePage createArticlePage = articlesPage.clickOnAddArticleButton();
        articlesPage.changeShowsCounter(1);
        Utils.wait(500);
        System.out.println(articlesPage.getTableInfo());

        articlesPage.changeShowsCounter(2);
        Utils.wait(500);
        articlesPage.changeShowsCounter(3);
        Utils.wait(500);
        System.out.println(articlesPage.getTableInfo());

        CreateArticlePage createArticlePage = articlesPage.clickOnAddArticleButton();
        Article midValidArticle = new Article();
        midValidArticle.setMiddleArticle();

        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add("Необходимо заполнить заголовок");
        expectedErrors.add("Необходимо указать автора!");
        expectedErrors.add("Необходимо указать героя статьи для карточки 25%");
        expectedErrors.add("Проверьте наличие и корректность лид-абзаца!");
        expectedErrors.add("Необходимо выбрать хотя бы один тэг!");
        expectedErrors.add("Поле обязательно для заполнения");
        expectedErrors.add("Поле обязательно для заполнения");
        expectedErrors.add("Поле обязательно для заполнения");
        expectedErrors.add("Поле обязательно для заполнения");
        expectedErrors.add("Поле обязательно для заполнения");
        expectedErrors.add("Поле обязательно для заполнения");
        expectedErrors.add("Необходимо выбрать изображение для карточки 25%");
        expectedErrors.add("Необходимо выбрать изображение для карточки 25%");

        List<String> actualErrors = createArticlePage.failCreate().getListOfErrors();
        Assert.assertEquals(actualErrors, expectedErrors);

        actualErrors.clear();
        expectedErrors.remove(2);
        expectedErrors.set(10, "Необходимо выбрать изображение для карточки 100%");
        expectedErrors.set(11, "Необходимо выбрать изображение для карточки 100%");
        actualErrors = createArticlePage.changeCardType(1).failCreate().getListOfErrors();
        Assert.assertEquals(actualErrors, expectedErrors);

        createArticlePage.sendsInputFields(midValidArticle).failCreate();


        //createArticlePage.sendImgPath();
    }
}
