package testrunner;

import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import setup.Setup;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;

//    @Test(priority = 1, description = "User can not login with wrong credential")
//    public void doLoginWithWrongCreds() {
//        driver.get("https://www.saucedemo.com/");
//        loginPage = new LoginPage(driver);
//        loginPage.doLogin("wrongUser", "password");
//        String validationErrorActual = driver.findElement(By.className("oxd-alert-content-text")).getText();
//        String validationErrorExpected = "Invalid credentials";
//        Assert.assertTrue(validationErrorActual.contains(validationErrorExpected));
//        Allure.description("Admin failed to log in");
//    }

    @Test(priority = 2, description = "Admin log in successfully")
    public void doLogin() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.doLogin("standard_user", "secret_sauce");
        String urlActual = driver.getCurrentUrl();
        String urlExpected = "https://www.saucedemo.com/inventory.html";
        Assert.assertTrue(urlActual.contains(urlExpected));
        Allure.description("Admin logged in successfully");
    }

}
