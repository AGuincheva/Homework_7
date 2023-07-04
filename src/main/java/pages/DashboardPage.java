package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.WaitTool;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//img[@id='user-profile']/ ..")
    private static WebElement usernameLink;
    @FindBy(xpath = "//*[@id='menu-customer']/a")
    private static WebElement customersLabel;
    @FindBy(xpath = "//h1[@class='panel-title']")
    private static WebElement loginCredentials;
    @FindBy(xpath = "//button[@value='theme']/ ../ ../td[2]/div/label[1]")
    private  static WebElement themeOnButton;
    @FindBy(xpath = "//button[@value='theme']/ ../ ../td[2]/div/label[2]")
    private static WebElement themeOffButton;
    @FindBy(xpath = "//button[@value='sass']/ ../ ../td[2]/div/label[1]")
    private static WebElement onSASSButton;
    @FindBy(xpath = "//button[@value='sass']/ ../ ../td[2]/div/label[2]")
    private static WebElement offSASSButton;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private static WebElement successfullyModifyingSettings;
    @FindBy(xpath = "//i[@class='fa fa-check-circle']//following::button[1]") private static WebElement closeButton;

    static {
        PageFactory.initElements(driver, DashboardPage.class);
    }

    public static void verifyingUsernameLabelText(String expectedUsernameLabelText) {
        WaitTool.ExplicitWait(By.xpath("//img[@id='user-profile']/ .."), 5);
        Assert.assertEquals(usernameLink.getText(), expectedUsernameLabelText);
    }

    public static void verifyingEnterLoginDetailsMessage(String expectedEnterLoginDetailsMessage) {
        WaitTool.ExplicitWait(By.xpath("//h1[@class='panel-title']"), 5);
        Assert.assertEquals(loginCredentials.getText(), expectedEnterLoginDetailsMessage);
    }
    public static  void themeButtonOn(){
        WaitTool.ExplicitWait(By.xpath("//button[@value='theme']/ ../ ../td[2]/div/label[2]"), 5);

        if (!themeOffButton.isSelected()){
            LoginPage.clickOnElement(themeOffButton);
            Assert.assertTrue(themeOffButton.isSelected());
        } else if (themeOffButton.isSelected()) {
            LoginPage.clickOnElement(themeOnButton);
            Assert.assertTrue(themeOnButton.isSelected());
        }
    }


    public static void verifyingThemeButtonsWorking(String expectedThemeButtonsWorking){
        WaitTool.ExplicitWait(By.xpath("//div[@class='alert alert-success alert-dismissible']"), 5);
        Assert.assertEquals(successfullyModifyingSettings.getText(), expectedThemeButtonsWorking);
    }

}

