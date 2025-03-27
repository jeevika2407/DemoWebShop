package com.page;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    private WebElement confirmPassword;
    
    @FindBy(xpath="//input[@value='M']")
    private WebElement male;
    
    @FindBy(xpath="//input[@value='F']")
    private WebElement female;
 
    @FindBy(xpath="//input[@id='register-button']")
    private WebElement register;
    
    @FindBy(xpath="//div[@class=\"page-body\"]")
	public WebElement regSts;

	@FindBy(xpath="//div[@class=\"validation-summary-errors\"]")
	public WebElement emailError;
	
	@FindBy(xpath="//span[text()='Last name is required.']")
	public WebElement reqError;

    public void enterRegistrationDetails(String gender, String fName, String lName, String mail, String pwd, String confirmPwd) throws InterruptedException {
        if (gender.equals("male")) {
            male.click();
        } else {
            female.click();
        }

        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(mail);
        password.sendKeys(pwd);
        confirmPassword.sendKeys(confirmPwd);
        
        register.click();
        Thread.sleep(1000);
    }
    public String Status() {
		return  regSts.getText();
	}
	public String getEmailError() {
		return emailError.getText();
	}
	public String getRegError() {
		return reqError.getText();
	}

}
