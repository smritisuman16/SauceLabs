package Screens;

import Locators.LoginPageLocators;
import SetupFiles.ConfigReader;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
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
        locate.submitButton.click();try{
            driver.switchTo().alert().accept();
        }
        catch (NoAlertPresentException e){

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
    }
}
