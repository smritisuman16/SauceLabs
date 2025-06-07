package Screens;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class APIScreens {
    ScreenshotUtil screenshotUtil;
    public APIScreens(ScreenshotUtil screenshotUtil){
        this.screenshotUtil = screenshotUtil;
    }
    RequestSpecification requestSpecification;
    Response response;
    public void iSetRequestSpecificationsWithApiKey(String apiKey) {
         requestSpecification= new RequestSpecBuilder().setBaseUri("https://reqres.in/")
                 .addHeader("x-api-key",apiKey)
                 .build()
                ;

        screenshotUtil.addDataInPDF("Request Specification is set with API Key");
    }

    public void iTriggerGetReqestFor(String endPoint) {
        String endPointURL;
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
        screenshotUtil.addDataInPDF("Response Code for the request "+response.getStatusCode()+"\n"+
                "Response of the Request triggered is  \n"+response.asPrettyString());
    }

    public void iTriggerPatchRequestFor(String endPoint, String data) {
        String endPointURL=null;
        HashMap<String,String> body=new HashMap<>();
        if(endPoint.equals("Patch")) {
            endPointURL = "/api/users/2";
            body.put("name", data.split(",")[0]);
            body.put("job", data.split(",")[1]);
        }
        response=given()
                .spec(requestSpecification)
                .when()
                .body(body).patch(endPointURL);
        screenshotUtil.addDataInPDF("Patch Request is triggered for "+endPoint);
    }

    public void iTriggerDeleteRequestFor(String endPoint) {
        String endPointURL=null;
        if(endPoint.equals("DELETE")) {
            endPointURL = "/api/users/2";
        }
        response=given()
                .spec(requestSpecification)
                .when()
                .delete(endPointURL);
        screenshotUtil.addDataInPDF("Delete Request is triggered for "+endPoint);
    }
}
