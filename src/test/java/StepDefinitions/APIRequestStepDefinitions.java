package StepDefinitions;

import Screens.APIScreens;
import Screens.ScreenshotUtil;
import io.cucumber.java.en.*;

public class APIRequestStepDefinitions {
    ScreenshotUtil screenshotUtil;
    APIScreens apiScreens;
   public APIRequestStepDefinitions(ScreenshotUtil screenshotUtil){
       this.screenshotUtil=screenshotUtil;
       apiScreens=new APIScreens(screenshotUtil);


   }
    @Given("I set Request Specifications with API Key {string}")
    public void i_set_request_specifications_with_api_key(String apiKey) {
        // Write code here that turns the phrase above into concrete actions
        apiScreens.iSetRequestSpecificationsWithApiKey(apiKey);

    }
    @Then("I trigger get reqest for {string}")
    public void i_trigger_get_reqest_for(String endPoint) {
        // Write code here that turns the phrase above into concrete actions
        apiScreens.iTriggerGetReqestFor(endPoint);

    }
    @Then("I validate response")
    public void i_vaidate_response() {
        // Write code here that turns the phrase above into concrete actions
        apiScreens.validateResponse();

    }
    @Then("I trigger POST request for {string} and {string}")
    public void i_trigger_post_request_for_and(String endPoint, String data) {
        // Write code here that turns the phrase above into concrete actions
        apiScreens.iTriggerPostRequestFor(endPoint,data);
    }
    @Then("I trigger PUT request for {string} and {string}")
    public void i_trigger_put_request_for_and(String endPoint, String data) {
        // Write code here that turns the phrase above into concrete actions
        apiScreens.iTriggerPutRequestFor(endPoint,data);
    }

}
