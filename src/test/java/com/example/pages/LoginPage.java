package com.example.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage {

    @AndroidFindBy(id = "englishLanguage")
    private WebElement englishLanguage;

    @AndroidFindBy(id="continueBtn")
    private WebElement continueBtn;

    public void selectLanguage() {
        englishLanguage.click();
        continueBtn.click();
        }

}
