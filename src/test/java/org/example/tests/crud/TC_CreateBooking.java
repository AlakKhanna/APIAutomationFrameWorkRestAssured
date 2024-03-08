package org.example.tests.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.example.EndPoints.APIConstants;
import org.example.tests.base.BaseTest;
import org.testng.annotations.Test;

public class TC_CreateBooking extends BaseTest {
    //step1- post
    //url-Base uri + Base Path
    //header
    //body
    //auth-no


    //step2
    //prepare the payload (object- json string
    //send the request


    //step 3
    //validate response (json string - object)
    //firstname
    //status code

    @Owner("Alak")
    @Description("Verify That the create booking with the vaid payload, status code 200")
    @Test
    public  void testpositivePOSTreq(){
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING);
        response= RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createpayload()).post();
        validatableResponse= response.then().log().all();
        validatableResponse.statusCode(200);

        }

    }
