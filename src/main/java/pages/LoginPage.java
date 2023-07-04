package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Browser;

import java.net.URL;

public class LoginPage extends BasePage {

    private static final String LOGIN_PAGE_URL = "http://shop.pragmatic.bg/admin/";
    private static final By USERNAME_INPUT_FIELD_LOCATOR = By.id("input-username");
    private static final By PASSWORD_INPUT_FIELD_LOCATOR = By.id("input-password");
    private static final By LOGIN_INPUT_FIELD_LOCATOR = By.xpath("//button[@class='btn btn-primary']");
    private static final By LOGIN_VALIDATION_ERROR_LOCATOR = By.className("alert-dismissible");


    static {
        PageFactory.initElements(driver, LoginPage.class);
    }

    public static void goToLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    public static void writeTextInUsernameInputField(String username) {
        WebElement usernameInputField = driver.findElement(USERNAME_INPUT_FIELD_LOCATOR);
        sendKeysElement(usernameInputField, username);
    }

    public static void writeTextInPasswordInputField(String password) {
        sendKeysElementByLocator(PASSWORD_INPUT_FIELD_LOCATOR, password);
    }

    public static void submitLoginButton() {
        clickOnElementByLocator(LOGIN_INPUT_FIELD_LOCATOR);
    }

    public static void verifyValidationMessage(String expectedValidationMessage) {
        String actualValidationMessage = driver.findElement(LOGIN_VALIDATION_ERROR_LOCATOR).getText();
        Assert.assertTrue(actualValidationMessage.contains(expectedValidationMessage));
    }
}