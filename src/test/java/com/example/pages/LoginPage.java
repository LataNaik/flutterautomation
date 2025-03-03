package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.example.base.BaseTest;

import io.github.ashwith.flutter.FlutterFinder;

public class LoginPage extends BaseTest {

    public LoginPage(RemoteWebDriver driver) {
        BaseTest.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //define all locators
    FlutterFinder finder = new FlutterFinder(driver);
    WebElement englishLanguage = finder.bySemanticsLabel("ENGLISH");
    WebElement btnContinue = finder.bySemanticsLabel("Continue");
    WebElement userNameField=finder.bySemanticsLabel("username");
    WebElement passwordField=finder.bySemanticsLabel("password");
    WebElement btnLogin = finder.bySemanticsLabel("Login");

    //method to select language
    public void selectLanguage() {
        System.out.println("searching english");
        englishLanguage.click();
        System.out.println("Clicked on english");
        btnContinue.click();
        System.out.println("Clicked on continue");
    }

    public void loginToApp(String userName, String password){
        System.out.println("----------------Login--------");
        userNameField.sendKeys("Reg-1");
        passwordField.sendKeys("eGov@1234");
        btnLogin.click();
    }
}
