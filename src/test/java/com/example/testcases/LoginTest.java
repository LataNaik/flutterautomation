package com.example.testcases;

import org.testng.annotations.Test;

import com.example.base.BaseTest;
import com.example.pages.LoginPage;

public class LoginTest extends BaseTest{
@Test
    public void testValidLogin() {
        System.out.println("-------------testvalidlogin - pre---------------");
        LoginPage loginPage = new LoginPage();
        System.out.println("-------------testvalidlogin - post---------------");
        loginPage.selectLanguage();
    }
}
