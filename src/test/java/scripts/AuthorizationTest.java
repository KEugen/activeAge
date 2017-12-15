package scripts;

import framework.Helper.AdditionalMethods;
import framework.Helper.User;
import framework.setup.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthPage;
import pages.MainPage;
import pages.ProfilePage;

public class AuthorizationTest extends Setup{

    AdditionalMethods methods = new AdditionalMethods();

    @Test
    public void authorizationUserTest() {
        driver.get(Setup.getUrl());
        methods.wait(1000);
        User validUser = new User("Rexxar", "rexxar@p33.org", "123qwe");
        User invalidPassUser = new User("Rexxar", "rexxar@p33.org", "123123");
        User invalidMailUser = new User("Rexxar", "123@ggg@ad.ru", "123qwe");
        User invalidLengthPassUser = new User("Rexxar", "rexxar@p33.org", "123");

        MainPage mainPage = new MainPage(driver);
        AuthPage authPage = mainPage.clickOnLogin();

        authPage.authUserFail(invalidPassUser)
                .checkErrorMessage("Неверные данные")
                .clearEdits()
                .authUserFail(invalidMailUser)
                .checkErrorMessage("Неправильный адрес. Возможно, вы не переключили язык или нажали клавишу Caps Lock. Проверьте настройки клавиатуры и введите email еще раз.")
                .clearEdits()
                .authUserFail(invalidLengthPassUser)
                .checkErrorMessage("Пароль меньше 6 символов")
                .clearEdits().authUserSuccess(validUser);
                methods.wait(1000);

        ProfilePage profilePage = mainPage.clickOnProfile();
        Assert.assertEquals(validUser.email, profilePage.getUserEmail());
    }

}
