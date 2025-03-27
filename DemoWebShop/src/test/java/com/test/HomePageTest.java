package com.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.page.HomePage;
import com.util.ListenerMethod;

@Listeners(ListenerMethod.class)
public class HomePageTest extends BaseTest {
    @Test
    public void verifyLoginPageText() {
        HomePage p = new HomePage(getDriver());
        String expected = "Welcome to the new Tricentis store!";
        String actual = p.getParagraphElement();

        System.out.println("Actual Login Text: " + actual);
        Assert.assertEquals(actual, expected, "Login Page Text Mismatch");
    }
}

