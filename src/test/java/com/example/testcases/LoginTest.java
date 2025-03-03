package com.example.testcases;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.example.base.BaseTest;
import com.example.pages.LoginPage;

public class LoginTest extends BaseTest {

    RemoteWebDriver driver;
    LoginPage login = new LoginPage(driver);


    @Test
    public void testValidLogin() {
        System.out.println("-------------testvalidlogin - pre---------------");
        login.selectLanguage();
        // login.loginToApp(username, password);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
