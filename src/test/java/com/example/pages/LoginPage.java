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
        System.out.println("Searching for 'ENGLISH'...");
        WebElement englishLanguage = driver.findElement(AppiumBy.accessibilityId("FRENCH"));
        englishLanguage.click();
        System.out.println("Clicked on English");

    //     // **🔹 Wait dynamically for 10 seconds OR until the 'Continue' button is visible**
    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Continue")));
        System.out.println("Searching for 'Continue'...");
        WebElement btnContinue = driver.findElement(AppiumBy.accessibilityId("Continue"));
        // finder.byText("Continue");
        btnContinue.click();
        System.out.println("Clicked on Continue");
    }

    public void loginToApp(String userName, String password) {
        System.out.println("---------------- Login --------");

        WebElement userNameField = finder.byText("username");
        WebElement passwordField = finder.byText("password");
        WebElement btnLogin = finder.byText("Login");

        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        btnLogin.click();
    }
}
