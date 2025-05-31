package StepDefinitions;


import Screens.LoginScreens;

import Screens.ScreenshotUtil;
import io.cucumber.java.en.*;


public class LoginFunctionalities  {
    LoginScreens loginScreens=new LoginScreens();
    @Given("Navigate to url")
    public void navigate_to_url() {
        loginScreens.navigateToUrl();
        ScreenshotUtil.takeScreenshot("Navigate to URL");
        // Write code here that turns the phrase above into concrete actions
    }
    @And("Provide {string} and {string} to login")
    public void provide_and_to_login(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        loginScreens.login(username,password);
        ScreenshotUtil.takeScreenshot("Logging in to sauce Labs");
    }
    @And("User logout from the website")
    public void userLogoutFromTheSauceLabs() {
        // Write code here that turns the phrase above into concrete actions
        loginScreens.logout();
        ScreenshotUtil.takeScreenshot("Log out from sauce Labs");
    }


}
