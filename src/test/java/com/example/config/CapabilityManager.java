package com.example.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityManager {

    public static DesiredCapabilities getCapabilities(String filePath) {
        DesiredCapabilities caps = new DesiredCapabilities();
        Properties properties = new Properties();
        
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
            for (String key : properties.stringPropertyNames()) {
                caps.setCapability(key, properties.getProperty(key));
            }
        } catch (IOException e) {
        }
        return caps;
    }
}