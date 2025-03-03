package com.example.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Properties;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {

    public static RemoteWebDriver driver;
    @BeforeClass
    public void setup() throws InterruptedException, IOException {

        System.out.println("Starting Emulator...");
            Process bootCheck = Runtime.getRuntime().exec("adb wait-for-device shell getprop sys.boot_completed");
            bootCheck.waitFor();
            System.out.println("Emulator is ready!");
            
        Properties props = new Properties();
        // try (FileInputStream fis = new FileInputStream("resources/config_" + env + ".properties")) {
            try (FileInputStream fis = new FileInputStream("resources/config_qa.properties")) {
            props.load(fis);
        } catch (IOException e) {
            System.err.println("❌ Error loading properties file: " + e.getMessage());
            throw e;
        }

        UiAutomator2Options options = new UiAutomator2Options();
        System.out.println("-------------setting capabilities---------------");
        options.setPlatformName(props.getProperty("platformName"));
        options.setDeviceName(props.getProperty("deviceName"));
        options.setAutomationName(props.getProperty("automationName"));
        options.setCapability("platformVersion", "14.0");
        options.setApp(props.getProperty("app"));
        options.setAppPackage(props.getProperty("appPackage"));
        options.setAppActivity(props.getProperty("appActivity"));
        options.setNoReset(Boolean.parseBoolean(props.getProperty("noReset")));
        // options.setFullReset(Boolean.parseBoolean(props.getProperty("fullReset")));

        try {
            System.out.println("-------------driver try---------------");
            driver = new RemoteWebDriver(URI.create("http://127.0.1.1:4723/wd/hub/").toURL(), options);
            System.out.println("✅ Appium session started successfully!");
        } catch (MalformedURLException e) {
            System.out.println("-------------driver catch---------------");
            System.err.println("❌ Invalid Appium Server URL: " + e.getMessage());
            throw e;
        }
    }


    @AfterClass
    public void tearDown() throws MalformedURLException {
        if (driver != null) {
            driver.quit();
            System.out.println("✅ Appium session closed successfully!");
        }
    }
}