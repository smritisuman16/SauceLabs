package StepDefinitions;

import Screens.APIScreens;
import Screens.ScreenshotUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;

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
    @Then("I trigger PATCH request for below")
    public void i_trigger_patch_request_for_below(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<List<String>> dataTableList=dataTable.asLists(String.class);
        String endPoint= dataTableList.get(0).get(0);
        String data= dataTableList.get(0).get(1);
        apiScreens.iTriggerPatchRequestFor(endPoint,data);


    }

    @Then("I trigger delete request for {string}")
    public void iTriggerDeleteRequestFor(String arg0) {
       apiScreens.iTriggerDeleteRequestFor(arg0);
    }
}
