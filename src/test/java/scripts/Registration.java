package scripts;

import framework.Helper.AdditionalMethods;
import framework.Helper.User;
import framework.setup.Setup;
import org.testng.annotations.Test;
import pages.AuthPage;
import pages.MainPage;

public class Registration extends Setup {

    @Test
    public void registrationUserTest() {
        driver.get(Setup.getUrl());
        AdditionalMethods.wait(1000);
        User validUser = new User("", "dfdf@p33.org", "123qwe");

        MainPage mainPage = new MainPage(driver);
        AuthPage authPage = mainPage.clickOnLogin();

        authPage.goOnRegistrationTab()
                .regUserSuccess(validUser);
    }



}
