package Screens;

import StepDefinitions.BasePage;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class APIScreens {
    ScreenshotUtil screenshotUtil=new ScreenshotUtil();
    public APIScreens(ScreenshotUtil screenshotUtil){
        this.screenshotUtil = screenshotUtil;
    }
    RequestSpecification requestSpecification;
    Response response;
    public void iSetRequestSpecificationsWithApiKey(String apiKey) {
         requestSpecification= new RequestSpecBuilder().setBaseUri("https://reqres.in/")
                 .addHeader("x-api-key","reqres-free-v1")
                 .build()
                ;

        screenshotUtil.addDataInPDF("Request Specification is set with API Key");
    }

    public void iTriggerGetReqestFor(String endPoint) {
        String endPointURL=null;
        switch (endPoint) {
            case "List users":
                endPointURL = "/api/users?page=2";
                break;
            case "Single user":
                endPointURL = "/api/users/2";
                break;
            case "List Resource":
                endPointURL = "/api/unknown";
                break;
            case "Single Resource":
                endPointURL="/api/unknown/2";
                break;
            default:
                throw new RuntimeException("You don't want to access correct get method. Please try again");
        }
        response=given().spec(requestSpecification).
                when().get(endPointURL);
        screenshotUtil.addDataInPDF("Get Request is triggered for "+endPoint);


    }
    public void iTriggerPostRequestFor(String endPoint,String data){
        String endPointURL=null;
        HashMap<String,String> body=new HashMap<>();
        if(endPoint.equals("Create")) {
            endPointURL = "/api/users";
            body.put("name", data.split(",")[0]);
            body.put("job", data.split(",")[1]);
        }
        response=given()
                .spec(requestSpecification)
                .when()
                .body(body).post(endPointURL);
        screenshotUtil.addDataInPDF("Post Request is triggered for "+endPoint);
    }
    public void iTriggerPutRequestFor(String endPoint,String data){
        String endPointURL=null;
        HashMap<String,String> body=new HashMap<>();
        if(endPoint.equals("Put")) {
            endPointURL = "/api/users/2";
            body.put("name", data.split(",")[0]);
            body.put("job", data.split(",")[1]);
        }
        response=given()
                .spec(requestSpecification)
                .when()
                .body(body).put(endPointURL);
        screenshotUtil.addDataInPDF("Put Request is triggered for "+endPoint);
    }

    public void validateResponse() {
        System.out.println("Status code received for the response "+response.getStatusCode());
        System.out.println("JSON Response Body received for the response"+response.getBody().prettyPrint());
        screenshotUtil.addDataInPDF("Response of the Request triggered is  \n"+response.asPrettyString());
    }
}
