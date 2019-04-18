package ru.beru;

import org.testng.annotations.Test;

public class LoginTest extends TestConfig {

    @Test
    public void loginTest() {
        PageObjectLogin pageObjectLogin = new PageObjectLogin(driver);
        PageObjectMainPage pageObjectMainPage = new PageObjectMainPage(driver);

        pageObjectMainPage.clickForLogin();
        pageObjectLogin.sendLogin();
        pageObjectLogin.submitLogin();
        pageObjectLogin.sendPassword();
        pageObjectLogin.submitPassword();
        pageObjectMainPage.isMyProfileDisplayed();
    }
}
