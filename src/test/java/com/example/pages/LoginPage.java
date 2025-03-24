package com.example.pages;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.github.ashwith.flutter.FlutterFinder;

public class LoginPage {

    private RemoteWebDriver driver;
    private FlutterFinder finder;
   
    public LoginPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.finder = new FlutterFinder(driver);
    }

    // Method to select language
    public void selectLanguage() {
        WebElement englishLanguage = driver.findElement(AppiumBy.accessibilityId("ENGLISH"));
        englishLanguage.click();
        WebElement btnContinue = driver.findElement(AppiumBy.accessibilityId("Continue"));
        btnContinue.click();
    }

    // Method to login
    public void loginToApp() {
        WebElement userName = driver.findElement(AppiumBy.xpath("(//android.widget.EditText)[1]"));
        userName.click();
        userName.sendKeys("USR-260848");
        WebElement password = driver.findElement(AppiumBy.xpath("//android.widget.EditText[2]"));
        password.click();
        password.sendKeys("eGov@123");
        WebElement privacyCheckbox = driver.findElement(AppiumBy.xpath("//android.view.View[4]"));
        privacyCheckbox.click();
        WebElement btnLogin = driver.findElement(AppiumBy.accessibilityId("Login"));
        btnLogin.click();
    }

    // Method to validate projects
    public void validateLogin(){
        System.out.println("--------------validate login--------------");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement projects = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@content-desc=\"Projects\"]")));

//        WebElement projects=driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Projects\"]"));

        Boolean isProjectsDisplayed=projects.isDisplayed();
        Assert.assertTrue(isProjectsDisplayed, "Project lists are displayed");
    }
}


