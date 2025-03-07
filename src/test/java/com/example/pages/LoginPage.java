package com.example.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.github.ashwith.flutter.FlutterFinder;

public class LoginPage {

    private RemoteWebDriver driver;
    private FlutterFinder finder;
    private WebDriverWait wait;

    public LoginPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.finder = new FlutterFinder(driver);
    }

    // Method to select language
    public void selectLanguage() {
        WebElement englishLanguage = driver.findElement(AppiumBy.accessibilityId("ENGLISH"));
        englishLanguage.click();
        WebElement btnContinue = driver.findElement(AppiumBy.accessibilityId("Continue\nContinue"));
        btnContinue.click();
    }

    // Method to login
    public void loginToApp() {
        WebElement userName = driver.findElement(AppiumBy.xpath("//android.view.View//android.widget.EditText[1]"));
        userName.click();
        userName.sendKeys("USR-260848");
        WebElement password = driver.findElement(AppiumBy.xpath("//android.view.View//android.widget.EditText[2]"));
        password.click();
        password.sendKeys("eGov@123");
        WebElement privacyCheckbox = driver.findElement(AppiumBy.xpath("//android.view.View[4]"));
        privacyCheckbox.click();
        WebElement btnLogin = driver.findElement(AppiumBy.accessibilityId("Login\nLogin"));
        btnLogin.click();
    }
}


