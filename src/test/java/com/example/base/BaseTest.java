package com.example.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {

    public static AndroidDriver driver;

    @BeforeClass
    public void setup() throws IOException {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("resources/capabilities.properties")) {
            props.load(fis);
        } catch (IOException e) {
            System.err.println("❌ Error loading properties file: " + e.getMessage());
            throw e;
        }

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(props.getProperty("platformName"));
        options.setDeviceName(props.getProperty("deviceName"));
        options.setAutomationName(props.getProperty("automationName"));
        options.setApp(props.getProperty("app"));
        options.setAppPackage(props.getProperty("appPackage"));
        options.setAppActivity(props.getProperty("appActivity"));
        options.setNoReset(Boolean.parseBoolean(props.getProperty("noReset")));
        options.setFullReset(Boolean.parseBoolean(props.getProperty("fullReset")));

        try {
            driver = new AndroidDriver(URI.create("http://192.168.117.165:4725/").toURL(), options);
            System.out.println("✅ Appium session started successfully!");
        } catch (MalformedURLException e) {
            System.err.println("❌ Invalid Appium Server URL: " + e.getMessage());
            throw e;
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("✅ Appium session closed successfully!");
        }
    }
}
