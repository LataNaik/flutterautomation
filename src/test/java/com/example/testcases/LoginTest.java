package com.example.testcases;

import org.testng.annotations.Test;

import com.example.base.BaseTest;
import com.example.pages.LoginPage;

public class LoginTest extends BaseTest{
@Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.selectLanguage();
    }
}
