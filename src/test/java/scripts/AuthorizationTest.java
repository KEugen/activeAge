package scripts;

import framework.Helper.Utils;
import framework.Helper.User;
import framework.setup.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthPage;
import pages.MainPage;
import pages.ProfilePage;

public class AuthorizationTest extends Setup{

    @Test
    public void authorizationUserTest() {
        driver.get(Setup.getUrl());
        Utils.wait(1000);
        User validUser = new User("Rexxar", "rexxar@p33.org", "123qwe");
        User invalidPassUser = new User("Rexxar", "rexxar@p33.org", "123123");
        User invalidMailUser = new User("Rexxar", "123@ggg@ad.ru", "123qwe");
        User invalidLengthPassUser = new User("Rexxar", "rexxar@p33.org", "123");

        MainPage mainPage = new MainPage();
        AuthPage authPage = mainPage.clickOnLogin();

        authPage.authUserFail(invalidPassUser);
        Assert.assertEquals(authPage.getAuthErrorMessage(), "Неверные данные");
        authPage.clearEdits().authUserFail(invalidMailUser);
        Assert.assertEquals(authPage.getAuthErrorMessage(), "Неправильный адрес. Возможно, вы не переключили язык или нажали клавишу Caps Lock. Проверьте настройки клавиатуры и введите email еще раз.");
        authPage.clearEdits().authUserFail(invalidLengthPassUser);
        Assert.assertEquals(authPage.getAuthErrorMessage(), "Пароль меньше 6 символов");
        authPage.clearEdits();
        authPage.authUserSuccess(validUser);
        Utils.wait(1000);

        ProfilePage profilePage = mainPage.clickOnProfile();
        Assert.assertEquals(validUser.email, profilePage.getUserEmail());
    }
}
