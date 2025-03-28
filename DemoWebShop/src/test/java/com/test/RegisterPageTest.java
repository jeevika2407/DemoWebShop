package com.test;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import com.page.RegisterPage;
import com.util.ListenerMethod;
import com.page.HomePage;

@Listeners(ListenerMethod.class)
public class RegisterPageTest extends BaseTest {

    @Test
    public void verifyRegisterPageNavigation() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        HomePage reg = new HomePage(getDriver());
        reg.clickRegister();

        WebElement registerHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        String actualText = registerHeading.getText();
        String expectedText = "Register"; 
        Assert.assertEquals(actualText, expectedText, "Register Page is not displayed!");
    }

    @Test(dataProvider = "excelData", dataProviderClass = com.util.ExcelMethod.class)
    public void verifyRegisterPageNavigation1(String gen, String fname, String lname, String email, String pass, String cpassword, String status) throws InterruptedException {
        HomePage reg = new HomePage(getDriver());
        reg.clickRegister();
        RegisterPage reg2 = new RegisterPage(getDriver());
        reg2.enterRegistrationDetails(gen, fname, lname, email, pass, cpassword);
        if (status.equals("pass")) {
            String exp = "Your registration completed";
            String act = reg2.Status();
            Assert.assertEquals(act, exp);
            System.out.println("Registration completed");
        } else if (status.equals("duplicate")) {
            String exp = "The specified email already exists";
            String act = reg2.getEmailError();
            Assert.assertEquals(act, exp);
            System.out.println("Error displayed");
        } else if (status.equals("required")) {
            String exp = "Last name is required.";
            String act = reg2.getRegError();
            Assert.assertEquals(act, exp);
            System.out.println("Error displayed");
        }
    }
}
