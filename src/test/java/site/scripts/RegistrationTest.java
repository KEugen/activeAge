package site.scripts;

import framework.Helper.Utils;
import framework.Helper.User;
import framework.setup.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;
import site.pages.AuthPage;
import site.pages.MainPage;
import site.pages.ProfilePage;

public class RegistrationTest extends Setup {

    @Test
    public void registrationUserTest() {
        driver.get(Setup.getUrl());
        Utils.wait(1000);
        User alreadyExistUser = new User("Rexxar", "rexxar@p33.org", "123qwe");
        User invalidEmailUser = new User("Reno", "asd3@@@..@", "123qwe");
        User validUser = new User("", Utils.generateRandomEmail(), "123");

        MainPage mainPage = new MainPage();
        AuthPage authPage = mainPage.clickOnLogin();

        authPage.goOnRegistrationTab().regUserFail(alreadyExistUser);
        Assert.assertEquals(authPage.getRegErrorMessage(), "Пользователь уже существует");
        authPage.clearEmailEdit()
                .regUserFail(invalidEmailUser);
        Assert.assertEquals(authPage.getRegErrorMessage(), "Неправильный адрес. Возможно, вы не переключили язык или нажали клавишу Caps Lock. Проверьте настройки клавиатуры и введите email еще раз.");
        Assert.assertEquals(authPage.checkOfferText(), "http://activeage1.qa.lan/user-agreement");
        authPage.regUserSuccess(validUser);

        validUser.setConfirmPass("123");
        authPage.setupPasswordFail(validUser);
        Assert.assertEquals(authPage.getRegErrorMessage(), "Пароль меньше 6 символов");
        validUser.setPass("123qwe");
        validUser.setConfirmPass("123123");
        authPage.setupPasswordFail(validUser);
        Assert.assertEquals(authPage.getRegErrorMessage(), "Пароли не совпадают");
        validUser.setPass("123qwe");
        validUser.setConfirmPass("123qwe");

        ProfilePage profilePage = authPage.setupPasswordSuccess(validUser).clickOnProfile();
        Assert.assertEquals(profilePage.getUserEmail(), validUser.getEmail());
    }
}
