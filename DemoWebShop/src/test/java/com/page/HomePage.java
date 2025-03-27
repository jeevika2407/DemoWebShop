package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//p)[1]")
    private WebElement paraElement;

    @FindBy(xpath = "//a[text()='Register']")
    private WebElement regButton;  

    public String getParagraphElement() {
        return paraElement.getText();
    }

    public void clickRegister() {
        regButton.click();
    }
}
