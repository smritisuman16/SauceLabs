package Screens;

import Locators.LoginPageLocators;
import SetupFiles.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;
import static StepDefinitions.BasePage.driver;



public class LoginScreens  {
     LoginPageLocators locate=new LoginPageLocators();
     CommonElements commonElements=new CommonElements();

    public void navigateToUrl(){

        driver.navigate().to(ConfigReader.get("base.url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, locate);
    }
    public void login(String username,String password){

        WebElement Username=locate.username;
        Username.sendKeys(username);
        locate.password.sendKeys(password);
        locate.submitButton.click();;
    }
    public void logout(){
        try{
        locate.openMenuButton.click();
        locate.logoutButton.click();
        System.out.println("User logged out");
        commonElements.waitForSeconds(5);
        }
        catch (NullPointerException e) {
            System.out.println("User is already logged out");
            commonElements.waitForSeconds(5);
        }
    }
}
