package admin.scripts;

import admin.pages.ArticlesPage;
import admin.pages.CreateArticlePage;
import framework.Helper.Article;
import framework.Helper.Utils;
import framework.setup.Setup;
import org.testng.annotations.Test;

public class CreateArticleTest extends Setup {

    @Test
    public void createArticleTest() {

        driver.get(Setup.getAdminUrl());
        Utils.wait(2000);

        ArticlesPage articlesPage = new ArticlesPage();
        System.out.println(articlesPage.getDropSize());
        //CreateArticlePage createArticlePage = articlesPage.clickOnAddArticleButton();
        articlesPage.changeShowsCounter(1);
        Utils.wait(3000);
        System.out.println(articlesPage.getTableInfo());

        // ПОЧЕМУ_ТО НЕ ВИСИБЛ ПОСЛЕДНИЕ ДВА ЭЛЕМЕНТА ДРОПДАУНА
//        articlesPage.changeShowsCounter(1);
//        Utils.wait(3000);
//        articlesPage.changeShowsCounter(2);
//        Utils.wait(3000);
        System.out.println(articlesPage.getTableInfo());

        CreateArticlePage createArticlePage = articlesPage.clickOnAddArticleButton();
        Article midValidArticle = new Article();
        midValidArticle.setMiddleArticle();

        createArticlePage.sendsInputFields(midValidArticle);

        //createArticlePage.sendImgPath();
    }
}
