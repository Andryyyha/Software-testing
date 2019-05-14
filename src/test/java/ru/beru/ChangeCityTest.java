package ru.beru;

import org.testng.annotations.Test;


public class ChangeCityTest extends TestConfig {

//    @Test(dataProvider = "ChangeCityTest")
    public void changeCityTest(String cityName) {
        PageObjectMainPage pageObjectMainPage = new PageObjectMainPage(driver);
        PageObjectLogin pageObjectLogin = new PageObjectLogin(driver);

        pageObjectMainPage.clickToCityChooser();
        pageObjectMainPage.sendKeysToInputBox();
        pageObjectMainPage.clickToSuggester();
        pageObjectMainPage.clickToAcceptButton();


        pageObjectMainPage.getCityName(cityName);

        pageObjectMainPage.clickForLogin();

        pageObjectLogin.sendLogin();

        pageObjectLogin.submitLogin();

        pageObjectLogin.sendPassword();

        pageObjectLogin.submitPassword();

        pageObjectMainPage.openSettings();

        pageObjectMainPage.compareNames(cityName);

        pageObjectMainPage.logout();
    }
}