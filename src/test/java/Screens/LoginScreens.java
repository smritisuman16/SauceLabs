package Screens;

import Locators.LoginPageLocators;
import SetupFiles.ConfigReader;
import StepDefinitions.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static StepDefinitions.BasePage.driver;



public class LoginScreens  {

     LoginPageLocators locate=new LoginPageLocators();
     CommonElements commonElements=new CommonElements();
     private final ScreenshotUtil screenshotUtil;

    public LoginScreens(ScreenshotUtil screenshotUtil) {
        this.screenshotUtil = screenshotUtil;
        PageFactory.initElements(BasePage.driver, locate);
    }


    public void navigateToUrl(){

        driver.navigate().to(ConfigReader.get("base.url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        screenshotUtil.takeScreenshot("Navigate to URL");

    }
    public void login(String username,String password){

        WebElement Username=locate.username;
        Username.sendKeys(username);
        locate.password.sendKeys(password);
        screenshotUtil.takeScreenshot("Logging in to sauce Labs");
        locate.submitButton.click();
        try {
            ((JavascriptExecutor) driver).executeScript(
                    "Object.defineProperty(navigator, 'credentials', {" +
                            "  get: () => ({ create: () => Promise.reject(), get: () => Promise.reject() })" +
                            "});"
            );
        } catch (Exception e) {
            System.out.println("Could not disable credentials API: " + e.getMessage());
        }

    }
    public void logout(){
        try{
            commonElements.waitForSeconds(4);
        locate.openMenuButton.click();
            commonElements.waitForSeconds(4);
        locate.logoutButton.click();
        System.out.println("User logged out");
        commonElements.waitForSeconds(5);
        }
        catch (NoSuchElementException e) {
            System.out.println("User is already logged out");
            commonElements.waitForSeconds(5);
        }
        screenshotUtil.takeScreenshot("Log out from sauce Labs");
    }
}
