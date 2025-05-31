package StepDefinitions;


import Screens.LoginScreens;

import Screens.ScreenshotUtil;
import io.cucumber.java.en.*;


public class LoginFunctionalities  {
    ScreenshotUtil screenshotUtil;
    LoginScreens loginScreens;

    public LoginFunctionalities(ScreenshotUtil screenshotUtil) {
        this.screenshotUtil = screenshotUtil;
        loginScreens=new LoginScreens(screenshotUtil);

    }


    @Given("Navigate to url")
    public void navigate_to_url() {
        loginScreens.navigateToUrl();

        // Write code here that turns the phrase above into concrete actions
    }
    @And("Provide {string} and {string} to login")
    public void provide_and_to_login(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        loginScreens.login(username,password);

    }
    @And("User logout from the website")
    public void userLogoutFromTheSauceLabs() {
        // Write code here that turns the phrase above into concrete actions
        loginScreens.logout();

    }


}
