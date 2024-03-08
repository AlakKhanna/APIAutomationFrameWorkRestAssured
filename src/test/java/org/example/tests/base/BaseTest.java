package org.example.tests.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.Actions.AssertActions;
import org.example.EndPoints.APIConstants;
import org.example.Modules.PayloadManager;
import org.testng.annotations.BeforeTest;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseTest {//caal coomon code should be present here

    public RequestSpecification requestSpecification;
    public AssertActions assertActions;

    public Response response;

    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public ValidatableResponse validatableResponse;


    @BeforeTest(alwaysRun = true)

    public void setconfig() {
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build().log().all();
    }

    public String gettoken() throws JsonProcessingException {
        RequestSpecification requestSpecification;
        requestSpecification = RestAssured.given().baseUri(APIConstants.BASE_URL).basePath("/auth");

        String payload = payloadManager.setToken();
        response = requestSpecification.contentType(ContentType.JSON)
                .body(payload)
                .when().post();
        jsonPath = new JsonPath(response.asString());
        return jsonPath.getString("token");


    }
}

