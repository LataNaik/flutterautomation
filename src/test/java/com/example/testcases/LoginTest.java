package com.example.testcases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.example.base.BaseTest;
import com.example.pages.LoginPage;

import io.appium.java_client.AppiumBy;

public class LoginTest extends BaseTest {

    RemoteWebDriver driver;
    LoginPage login;

    @Test
    public void testValidLogin() {
        System.out.println("-------------testValidLogin - pre---------------");
        driver = BaseTest.driver; // Assign the initialized driver
        login = new LoginPage(driver); // Initialize LoginPage AFTER driver is set up

        // Handle permission popups before selecting language
        allowPermissions();
        
        // **🔹 Wait for 10 seconds before selecting language**


    login.selectLanguage();
        // login.loginToApp(username, password);
    }

    // Function to handle permission popups
    
    public void allowPermissions() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Explicit wait
    
        String[] permissionIds = {
            "com.android.permissioncontroller:id/permission_allow_button", // Normal Allow
            "com.android.permissioncontroller:id/permission_allow_foreground_only_button" // Allow while using app
        };
    
        // Handle normal permissions
        for (int i = 0; i < 2; i++) { // Assuming max 2 permission popups
            for (String id : permissionIds) {
                try {
                    WebElement allowButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(id)));
                    if (allowButton.isDisplayed()) {
                        allowButton.click();
                        System.out.println("Permission granted: " + id);
                        Thread.sleep(1000); // Allow time for next popup
                        break;
                    }
                } catch (Exception e) {
                    // Continue to the next ID if not found
                }
            }
        }
    
        // Handle "Run in Background" permission
        try {
            WebElement backgroundPopup = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[contains(@text, 'Allow')]")));
            backgroundPopup.click();
            System.out.println("Allowed background service.");
        } catch (Exception e) {
            System.out.println("No background service popup found.");
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
