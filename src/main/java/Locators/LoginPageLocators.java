package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {
    @FindBy(id="user-name")
    public WebElement username;
    @FindBy(id="password")
    public WebElement password;
    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//*[text()='Open Menu']")
    public WebElement openMenuButton;
    @FindBy(xpath = "//*[text()='Logout']")
    public WebElement logoutButton;
    
}
