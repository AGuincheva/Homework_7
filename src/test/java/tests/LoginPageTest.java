package tests;

import core.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {

    @Test
    public static void loginSuccessfully() {
        LoginPage.goToLoginPage();
        LoginPage.writeTextInUsernameInputField("admin");
        LoginPage.writeTextInPasswordInputField("parola123!");
        LoginPage.submitLoginButton();
        DashboardPage.verifyingUsernameLabelText("Milen Strahinski");
    }

    @Test
    public static void loginWithInvalidUsername() {
        LoginPage.goToLoginPage();
        LoginPage.writeTextInUsernameInputField("adminn");
        LoginPage.writeTextInPasswordInputField("parola123!");
        LoginPage.submitLoginButton();
        LoginPage.verifyValidationMessage("No match for Username and/or Password.");
    }

    @Test
    public static void loginWithInvalidPassword() {
        LoginPage.goToLoginPage();
        LoginPage.writeTextInUsernameInputField("admin2");
        LoginPage.writeTextInPasswordInputField("parola123");
        LoginPage.submitLoginButton();
        LoginPage.verifyValidationMessage("No match for Username and/or Password.");
    }

    @Test
    public static void successfulLogout() {
        loginSuccessfully();
        LoginPage.clickOnElementByLocator(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md']"));
        DashboardPage.verifyingEnterLoginDetailsMessage("Please enter your login details.");
    }

    @Test
    public static void radioButtonsActivity() {
        loginSuccessfully();
        LoginPage.clickOnElementByLocator(By.xpath("//button[@id='button-developer']"));
        DashboardPage.themeButtonOn();
        //DashboardPage.verifyingThemeButtonsWorking("Success: You have modified developer settings!");

    }
}
